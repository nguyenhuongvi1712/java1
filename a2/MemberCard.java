package a2;

public class MemberCard extends Student {
    private int id;
    private int bookId;
    private int ngaymuon;
    private int ngaytra;

    public MemberCard (int id,int bookId,int ngaymuon,int ngaytra,String name,int age,String group){
        super(name,age,group);
        this.id = id;
        this.bookId = bookId;
        this.ngaymuon = ngaymuon;
        this.ngaytra = ngaytra;
    }
    public MemberCard(){}
    public void setId(int id){
        this.id = id;
    }
    public void setBookId(int bookId){
        this.bookId = bookId;
    }
    public void setNgaymuon(int ngaymuon){
        this.ngaymuon = ngaymuon;
    }
    public void setNgaytra(int ngaytra){
        this.ngaytra = ngaytra;
    }
    public int getId(){
        return id;
    }
    public int getBookId(){
        return bookId;
    }
    public int getNgaymuon(){
        return ngaymuon;
    }
    public int getNgaytra(){
        return ngaytra;
    }
    public void print(){
        System.out.print(
                "Mã phiếu mượn : " + id +
                        "| Mã sách : " + bookId +
                        "| Ngày mượn : " + ngaymuon +
                        "| Ngày trả : " + ngaytra +" |"

        );
        super.printStudent();
    }
}

