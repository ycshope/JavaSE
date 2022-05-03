package Demo10;

public class Student extends Person{
    private String name = "Student";

    public void test(String name){
        System.out.println(name);
        System.out.println(this.name); //Student
        //访问父类的属性
        System.out.println(super.name); //Person
    }

    public void print(){
        System.out.println(this.name);
    }

    public void test01(){
        print(); // Student NOTE:没有重写那么输出Person
        this.print(); // Student  NOTE:没有重写那么输出Person
        super.print(); // Person
    }
}
