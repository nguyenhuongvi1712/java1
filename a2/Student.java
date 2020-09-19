package a2;

public class Student {
    private String name;
    private int age;
    private String group;

    public Student(String name,int age,String group){
        this.name = name;
        this.group = group;
        this.age = age;
    }
    public Student(){}
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGroup(String group){
        this.group = group;
    }
    public String getName(){
        return name;
    }
    public String getGroup(){
        return group;
    }
    public int getAge(){
        return age;
    }
    public void printStudent(){
        System.out.println(
                "Tên : " + name + "|Tuổi : " + age + "|Lớp : " + group
        );
    }

}
