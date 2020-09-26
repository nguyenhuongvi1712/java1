package a3;

public  abstract  class Account implements IAccount {

    //// vi account là một model nên là không nên để những funtion tương tác dữ liệu (tương tác chính với account) ở trong này .

    protected long accountId;
    protected String accountName;
    protected double bankBalance;


    public Account(long accountId, String accountName, double bankBalance){
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
}