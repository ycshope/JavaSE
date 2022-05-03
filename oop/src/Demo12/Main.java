package Demo12;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Person person = new Student();

        //子类重写父类的方法,执行子类的方法
        student.run(); //Student.run
        person.run(); //Student.run

        //对象能执行哪种方法,主要看对象左边的类型,和右边的类型无关
        //也可以理解为new是生成了对象,右边是作为类型解释,

        student.eat();
        //person.eat(); 父类没有子类的方法,无法调用
        ((Student) person).eat(); //除非强制转换
    }
}
