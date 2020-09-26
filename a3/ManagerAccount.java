package a3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerAccount {

    public final float INTERREST = (float) 0.035;
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }


    private static ManagerAccount instance;

    public static ManagerAccount getInstance() {
        if (instance == null) {
            instance = new ManagerAccount();
        }
        return instance;
    }


    private ManagerAccount() {
        accounts = new ArrayList();
    }

    public void addAccount(Scanner sc, int number) {
        for (int i = 0; i < number; i++) {
            addAccount(sc);
        }
    }

    public void addAccount(Scanner sc) {
        int i;
        do {
            System.out.println("Lựa chọn loại tài khoản : \n1.Tài khoản thường\n2.Tài khoản VIP");
            i = sc.nextInt();
            if (i == 1) {
                Account account = new Normal_Account();
                accounts.add(account);
                nhapTK(sc, account, i);
            } else if (i == 2) {
                Vip_account account = new Vip_account();
                accounts.add(account);
                nhapTK(sc, account, i);
            }
            else
                System.out.println("Nhập sai");
        }while (i != 2 && i != 1);
    }

    public void printListAccount() {
        this.accounts.forEach(o -> o.print());
    }

    public Account searchById(long Id) {
        Account ac = this.accounts.stream().filter(account -> account.getAccountId()==Id).findFirst().orElse(null);
        return ac;
    }

    static void nhapTK(Scanner sc, Account tk,int i) {
        int id;
        System.out.println("Nhập số tài khoản: ");
        tk.setAccountId(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhập tên tài khoản: ");
        tk.setAccountName(sc.nextLine());
        if(i==2){
            System.out.println("Nhập level tài khoản Vip (1 -> 3)");
            do {
                id = sc.nextInt();
                ((Vip_account) tk).setLevel(id);
            }while(id !=1 && id !=2 && id !=3);
            tk.setBankBalance(((Vip_account)tk).getLevel()*100);
        }
        else
            tk.setBankBalance(50);
    }


    public double deposit(Scanner sc, Account account) {
        double deposit_mn;
        do {
            System.out.println("Nhập số tiền cần nạp : ");
            deposit_mn = sc.nextDouble();
            if (deposit_mn < 0) {
                System.out.println("Số tiền nạp > 0. Mời nhập lại");
            }
        } while (deposit_mn < 0);
        account.setBankBalance(account.getBankBalance() + deposit_mn);
        System.out.println("Nạp tiền thành công. Số tiền hiện tại trong tài khoản là : " + account.getBankBalance());
        return deposit_mn;
    }


    public double Widthdraw(Scanner sc, Account account) {
        double cost = 10;
        double widthdraw_mn;
        System.out.println("Nhập số tiền cần rút : ");
        widthdraw_mn = sc.nextDouble();
        account.setBankBalance(account.withdraw(widthdraw_mn,INTERREST));
        System.out.println(" Số tiền hiện tại trong tài khoản là : " + account.getBankBalance());
        return widthdraw_mn;
    }

    public double Daohan(Account account) {
        account.setBankBalance(account.daohan(INTERREST));
        System.out.println("Đáo hạn thành công. Số tiền hiện tại trong tài khoản là : " + account.getBankBalance());
        return account.getBankBalance();
    }
    public void delAccount(Account account){
        accounts.remove(account);
    }
}