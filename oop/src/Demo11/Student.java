package Demo11;

public class Student extends Person{
//    public String name = "Student";
    public static String name = "static Student";
    public int age = 10;
    public static void test(){
        System.out.println(name);
//        System.out.println(this.name);
//        static(类)在编译时就已经确定,this(对象)在运行时才确定,所以没法通过编译
    }
    //重写
    public void test1(){
        System.out.println(this.age);
    }


}
