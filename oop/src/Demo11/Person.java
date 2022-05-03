package Demo11;

public class Person {
    public static String name = "static Person";
    public int age = 10_0000_0000;
    public static void test(){
        System.out.println(name);
    }

    public void test1(){
        System.out.println(this.age);
    }
}
