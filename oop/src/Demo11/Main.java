package Demo11;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.test(); //static Student

        Person person = new Student();
        person.test(); //static Person

        System.out.println("==============");

        Student student01 = new Student();
        student01.test1(); //10

        Person person01 = new Student();
        person01.test1(); //10
    }
}
