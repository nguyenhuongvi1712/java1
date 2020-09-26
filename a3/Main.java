package a3;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int b, n;
        long s;
        Scanner scanner = new Scanner(System.in);
        Account m;
        ManagerAccount managerAccount = ManagerAccount.getInstance();
        managerAccount.setAccounts(new ArrayList<>());
        do {
            System.out.println("Menu");
            System.out.println("1.Nhập thông tin tài khoản ngân hàng\n"
                    + "2.In danh sách thông tin của các tài khoản\n" + "3.Nạp tiền\n" + "4.Rút tiền\n"
                    + "5.Đáo hạn\n" + "6.Thêm tài khoản\n" +"7.Xóa tài khoản\n" + "8.Thoát");
            b = scanner.nextInt();
            switch (b) {
                case 1:
                    System.out.println("Nhập số lượng tài khoản bạn muốn nhập: ");
                    n = scanner.nextInt();
                    managerAccount.addAccount(scanner, n);
                    break;
                case 2:
                    managerAccount.printListAccount();
                    break;
                case 3:
                    System.out.println("Nhập số tài khoản khách hàng cần nạp tiền: ");
                    s = scanner.nextLong();
                    m = managerAccount.searchById(s);
                    if (m == null) {
                        System.out.println("Không tìm thấy ID.");
                    } else {
                        managerAccount.deposit(scanner, m);
                    }
                    break;
                case 4:
                    System.out.println("Nhập số tài khoản khách hàng cần rút tiền: ");
                    s = scanner.nextLong();
                    m = managerAccount.searchById(s);
                    if (m == null) {
                        System.out.println("Không tìm thấy ID.");
                    } else
                        managerAccount.Widthdraw(scanner, m);
                    break;
                case 5:
                    System.out.println("Nhập số tài khoản khách hàng cần đáo hạn ");
                    s = scanner.nextLong();
                    m = managerAccount.searchById(s);
                    if (m == null) {
                        System.out.println("Không tìm thấy ID.");
                    } else
                        managerAccount.Daohan(m);

                    break;
                case 6:
                    managerAccount.addAccount(scanner);
                    break;
                case 7:
                    System.out.println("Nhập số tài khoản khách hàng cần xóa :");
                    s = scanner.nextLong();
                    m = managerAccount.searchById(s);
                    if (m == null){
                        System.out.println("Không tìm thấy ID.");
                    }
                    else
                        managerAccount.delAccount(m);
                    break;
                case 8:
                    System.out.println("Bye!!");
                    break;
                default:
                    System.out.println("Sai cú pháp.Mời nhập lại");
            }
        } while (b != 8);
    }
}