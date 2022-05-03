package Demo01;

public class Main {
    public static void main(String[] args) {
        //静态方法可以直接调用
        Person.say();

        //非静态方法需要实例化
        Person person=new Person();
        person.read();
    }
}
