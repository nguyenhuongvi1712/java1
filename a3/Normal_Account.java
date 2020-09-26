package a3;

public class Normal_Account extends Account{
    public Normal_Account(long accountId, String accountName, double bankBalance){
        super(accountId,accountName,bankBalance);
    }
    public Normal_Account(){
        super();
    }
    public double withdraw(double withdraw_mn,float INTERREST) {
        double cost = 10;
        if (withdraw_mn > getBankBalance() - cost) {
            System.out.println("Số tiền rút vượt quá số dư trong tài khoản. Mời nhập lại:");
            return getBankBalance();
        }
        return getBankBalance() - withdraw_mn - cost;
    }

    public double daohan(float INTERREST) {
        return  getBankBalance() * (1 + INTERREST);
    }

}
