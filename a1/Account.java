package a1;
import java.util.Scanner;

public class Account {
    private long accountId;
    private String accountName;
    private double bankBalance;
    public Account(long accountId,String accountName,double bankBalance){
        this.accountId = accountId;
        this.accountName = accountName;
        this.bankBalance = bankBalance;
    }
    public Account(){}
    public void setAccountId(long accountId){
        this.accountId = accountId;
    }
    public void setAccountName(String accountName){
        this.accountName = accountName;
    }
    public void setBankBalance(double bankBalance){
        this.bankBalance = bankBalance;
    }
    public long getAccountId(){
        return accountId;
    }
    public String getAccountName(){
        return accountName;
    }
    public double getBankBalance(){
        return bankBalance;
    }

    public void print(){
        System.out.println(
                "Account {" +
                        "Account ID: " + accountId + "/" +
                        "Account Name: " + accountName + "/" +
                        "Bank Balance: " + bankBalance + "$" + "/" +
                        "}"
        );

    }
    final float INTERREST = (float) 0.035;
    Scanner sc = new Scanner(System.in);
    public double deposit(){
        double deposit_mn ;
        do{
            System.out.println("Nhập số tiền cần nạp : ");
            deposit_mn = sc.nextDouble();
            if(deposit_mn < 0 ){
                System.out.println("Số tiền nạp > 0. Mời nhập lại");
            }
        }while(deposit_mn < 0);
        bankBalance = bankBalance + deposit_mn;
        System.out.println("Nạp tiền thành công. Số tiền hiện tại trong tài khoản là : " + bankBalance);
        return deposit_mn;
    }
    public double widthdraw(){
        double cost = 10;
        double widthdraw_mn;
        do{
            System.out.println("Nhập số tiền cần rút : ");
            widthdraw_mn = sc.nextDouble();
            if(widthdraw_mn > bankBalance - cost){
                System.out.println("Số tiền rút vượt quá số dư trong tài khoản. Mời nhập lại:");
            }
        }while(widthdraw_mn > bankBalance - cost);
        bankBalance = bankBalance - widthdraw_mn - cost;
        System.out.println("Rút tiền thành công. Số tiền hiện tại trong tài khoản là : " + bankBalance);
        return widthdraw_mn;
    }
    public double daohan(){
        bankBalance = bankBalance + bankBalance * INTERREST;
        System.out.println("Đáo hạn thành công. Số tiền hiện tại trong tài khoản là : " + bankBalance);
        return bankBalance;
    }
}
