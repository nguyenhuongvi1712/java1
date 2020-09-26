package a3;


import java.util.Scanner;

public class Vip_account extends Account {
    private int level;
    public Vip_account(long accountId, String accountName, double bankBalance, int level){
        super(accountId,accountName,bankBalance);
        this.level = level;
    }
    public Vip_account(){}
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        if(level != 1 && level !=2 && level !=3)
            System.out.println("Nhập lại");
        else
            this.level = level;
    }
    @Override
    public void print(){
        System.out.println(
                "Account {" +
                        "Account ID: " + accountId + "/" +
                        "Account Name: " + accountName + "/" +
                        "Bank Balance: " + bankBalance + "$ " + "/" +
                        "Level: " + level +
                        "}"
        );
    }
    public double withdraw(double withdraw_mn,float INTERREST) {
        double cost = 5;
        double i;
        i = super.getBankBalance() - withdraw_mn - cost;
        if(i<0){
           i = i*(1+INTERREST);
        }
        return i;
    }
    public double daohan(float INTERREST) {
        return super.getBankBalance() * (1 + INTERREST* getLevel());
    }
}
