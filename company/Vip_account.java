package com.company;

public class Vip_account extends Account{
    private int level;
    public Vip_account(long accountId,String accountName,double bankBalance,int level){
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

}
