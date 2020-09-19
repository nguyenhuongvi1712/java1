package a2;
import java.util.Scanner;
public class Main {
    static int a;
    static MemberCard mb = new MemberCard();
    static public MemberCard tao(){
        MemberCard memberCard = new MemberCard();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã thẻ mượn: ");
        memberCard.setId(sc.nextInt());
        System.out.println("Nhập mã sách : ");
        memberCard.setBookId(sc.nextInt());
        System.out.println("Nhập ngày mượn : ");
        memberCard.setNgaymuon(sc.nextInt());
        System.out.println("Nhập ngày trả : ");
        memberCard.setNgaytra(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhập thông tin sinh viên mượn sách : ");
        System.out.println("Nhập tên sinh viên : ");
        memberCard.setName(sc.nextLine());
        System.out.println("Nhập tuổi sinh viên : ");
        memberCard.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhập lớp sinh viên ");
        memberCard.setGroup(sc.nextLine());
        return memberCard;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ManagerMemberCard managerMemberCard = new ManagerMemberCard();
        int b;
        do{
            System.out.println("Menu");
            System.out.println("1.Nhập thông tin thẻ mượn\n"
                    + "2.In danh sách thông tin thẻ mượn\n" + "3.Thêm thông tin thẻ mượn\n" + "4.Xóa thông tin thẻ mượn\n"
                    + "5.Thoát");
            a = sc.nextInt();
            switch (a){
                case 1:
                    System.out.println("Nhập số lượng thẻ mượn");
                    b = sc.nextInt();
                    for(int i=0;i<b;i++){
                        System.out.println("Nhập số lượng thẻ mượn thứ : "+i+1);
                        mb = tao();
                        managerMemberCard.add(mb);
                    }
                    break;
                case 2:
                    System.out.println("Danh sách thông tin thẻ mượn");
                    managerMemberCard.printList();
                    break;
                case 3:
                    mb = tao();
                    managerMemberCard.add(mb);
                    break;
                case 4:
                    System.out.println("Nhập mã thẻ mượn : ");
                    b = sc.nextInt();
                    boolean rm = managerMemberCard.del(b);
                    if(rm)
                        System.out.println("Xóa thành công");
                    else
                        System.out.println("Không tìm thấy mã thẻ có id : " + b);
                    break;
                case 5:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Sai cú pháp. Nhập lại ");
                    break;

            }
        }while(a!=5);
    }
}
