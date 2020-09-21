package com.company;

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
        System.out.println("Lựa chọn loại tài khoản : \n1.Tài khoản thường\n2.Tài khoản VIP");
        int i = sc.nextInt();
        if(i==1){
            Account account = new Account();
            accounts.add(account);
            nhapTK(sc, account,i);
        }
        else if(i==2){
            Vip_account account = new Vip_account();
            accounts.add(account);
            nhapTK(sc, account,i);
        }
    }

    public void printListAccount() {
        this.accounts.forEach(o -> o.print());
    }

    public Account searchById(long Id) {
//        for (Account account : accounts) {
//            if (account.getAccountId() == Id) {
//                return account;
//            }
//        }
//        return null;
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


    public double widthdraw(Scanner sc, Account account) {
        double cost = 10;
        double widthdraw_mn;
        if(account instanceof Vip_account){
            System.out.println("Nhập số tiền cần rút : ");
            widthdraw_mn = sc.nextDouble();
            account.setBankBalance(account.getBankBalance() - widthdraw_mn - (cost*0.5));
            if(account.getBankBalance()<0){
               account.setBankBalance(account.getBankBalance()*(1+INTERREST));
            }
        }
        else {
            do {
                System.out.println("Nhập số tiền cần rút : ");
                widthdraw_mn = sc.nextDouble();
                if (widthdraw_mn > account.getBankBalance() - cost) {
                    System.out.println("Số tiền rút vượt quá số dư trong tài khoản. Mời nhập lại:");
                }
            } while (widthdraw_mn > account.getBankBalance() - cost);
            account.setBankBalance(account.getBankBalance() - widthdraw_mn - cost);
        }
        System.out.println("Rút tiền thành công. Số tiền hiện tại trong tài khoản là : " + account.getBankBalance());
        return widthdraw_mn;
    }

    public double daohan(Account account) {
        if(account instanceof Vip_account){
            account.setBankBalance(account.getBankBalance() * (1 + INTERREST* ((Vip_account) account).getLevel()));
        }
        else
            account.setBankBalance(account.getBankBalance() * (1 + INTERREST));
        System.out.println("Đáo hạn thành công. Số tiền hiện tại trong tài khoản là : " + account.getBankBalance());
        return account.getBankBalance();
    }
    public void delAccount(Account account){
        accounts.remove(account);
    }
}