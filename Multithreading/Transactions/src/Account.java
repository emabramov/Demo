public class Account {

    private long money;
    private String accNumber;

    private boolean isBlocked;

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlock(boolean blocked) {
        isBlocked = blocked;
    }

    public Account(String accNumber, Long money){
        this.accNumber = accNumber;
        this.money = money;
        this.isBlocked = false;
    }

}
