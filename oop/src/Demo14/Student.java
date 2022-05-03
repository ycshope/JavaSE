package Demo14;

public class Student {
    private static int age = 10; //静态(类)变量
    private double score = 100; //非静态(对象)变量

    public static void main(String[] args) {

        Student s1 = new Student();
        System.out.println(Student.age); //类变量可以直接访问
//        System.out.println(Student.score);  score是对象变量,运行时才能确定,无法访问
        System.out.println(s1.age);
        System.out.println(s1.score);
    }
}
