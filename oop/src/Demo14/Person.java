package Demo14;
//被static修饰的类无法被继承
public class Person {
    {
        System.out.println("匿名代码块");
    }

    //只执行一次
    static {
        System.out.println("静态代码块");
    }

    public Person() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        Person person1 = new Person();//静态->匿名->构造
        System.out.println("=============");
        Person person2 = new Person();//匿名->构造

    }
}
