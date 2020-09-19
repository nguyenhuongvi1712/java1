package a1;
import java.util.Scanner;

public class ManagerAccount {

    static Scanner sc = new Scanner(System.in);

    private Account accounts[] ;
    private int cnt;

    public int getCnt(){
        return cnt;
    }
    public ManagerAccount(int cnt){
        this.cnt = cnt;
        accounts = new Account[1000];
        for (int i = 0;i<cnt;i++){
            accounts[i] = new Account();
            nhapTK(accounts[i]);
        }
    }
    public ManagerAccount(){}
    public void addAccount(){
        accounts[cnt++] = new Account();
        nhapTK(accounts[cnt-1]);
    }
    public void printListAccount(){
        for (int i =0;i<cnt;i++){
            accounts[i].print();
        }
    }
    public Account searchById(long Id){
        for (int i =0;i<cnt;i++){
            if(accounts[i].getAccountId()==Id){
                return accounts[i];
            }
        }
        return null;
    }
    static void nhapTK(Account tk){
        System.out.println("Nhập số tài khoản: ");
        tk.setAccountId(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhập tên tài khoản: ");
        tk.setAccountName(sc.nextLine());
        tk.setBankBalance(50);
    }



}
