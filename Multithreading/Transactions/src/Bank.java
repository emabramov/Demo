import java.util.*;

public class Bank {

    private Map<String, Account> accounts = new TreeMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        synchronized (this){
            Account from = accounts.get(fromAccountNum);
            Account to = accounts.get(toAccountNum);
            if (from.isBlocked()){
                System.out.println("Аккаунт " + from.getAccNumber() + " заблокирован");
            } else if (to.isBlocked()){
                System.out.println("Аккаунт " + to.getAccNumber() + " заблокирован");
            } else {
                if(amount < 50000){
                    if(!isFraud(fromAccountNum, toAccountNum, amount)){
                        from.setMoney(from.getMoney() - amount);
                        to.setMoney(to.getMoney() + amount);
                        System.out.println("Перевод выполнен");
                    } else {
                        System.out.println("Обнаружено мошенничество! Операция прервана, счета заблокированы.");
                        from.setBlock(true);
                        to.setBlock(true);
                    }
                } else {
                    from.setMoney(from.getMoney() - amount);
                    to.setMoney(to.getMoney() + amount);
                    System.out.println("Перевод выполнен");
                }
            }
        }
    }

    private void setBlocked(String accNumber){
        accounts.get(accNumber).setBlock(true);
    }

    private void setUnblocked(String accNumber){
        accounts.get(accNumber).setBlock(false);
    }
    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        Long balance = accounts.get(accountNum).getMoney();
        return balance;
    }

    public List<String> getAccNumber(){
        List<String> accNumbers = new ArrayList<>();
        for(Account account : accounts.values()){
            accNumbers.add(account.getAccNumber());
        }
        return accNumbers;
    }

    public long getSumAllAccounts() {
        Long sumBalance = new Long(0);
        try {
            for(Account account : accounts.values()){
                sumBalance += account.getMoney();
            }
        } catch (Exception ex){
            System.out.println("В банке не открыто ни одного счёта");
        }
        return sumBalance;
    }

    public void addAccount(Account account){
        accounts.put(account.getAccNumber(), account);
    }

    public int accTotal(){
        int total = 0;
        total += accounts.size() - 1;
        return total;
    }
}
