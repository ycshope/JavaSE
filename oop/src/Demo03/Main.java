package Demo03;

public class Main {
    public static void main(String[] args) {
        int x=3;
        changeInt(x); //值传递
        System.out.println(x); //3

        Student student = new Student();
        System.out.println(student.name);//null

        //对象是引用传递
        changeStu(student); //引用传递
        System.out.println(student.name); //stu

    }
    public static void changeInt(int x){
        x=10;
    }

    public static  void changeStu(Student student){
        student.name = "stu";
    }
}

