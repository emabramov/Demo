import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
    private static Bank bank = new Bank();
    private static Random random = new Random();
    public static void main(String[] args) throws InterruptedException {

        for(int i = 0; i < 1000; i++){
            String accNumber;
            Long num = Math.round(1000000000 * Math.random());
            accNumber = num.toString();
            Account account = new Account(accNumber, num);
            bank.addAccount(account);
        }



//        System.out.println("Сумма на счету под номером " + bank.getAccNumber().get(2) + " составляет " +
//                            bank.getBalance(bank.getAccNumber().get(2)));

        for(int i = 0; i < 500; i++){
            System.out.println("Общая сумма в банке: " + bank.getSumAllAccounts() + " рублей");
            bank.transfer(bank.getAccNumber().get((int)Math.round(bank.accTotal()*Math.random())), bank.getAccNumber().get((int)Math.round(bank.accTotal()*Math.random())), Math.round(55000*Math.random()));
            System.out.println("Общая сумма в банке: " + bank.getSumAllAccounts() + " рублей");
        }

    }
}
