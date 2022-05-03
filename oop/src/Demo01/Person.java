package Demo01;

public class Person {
    //和类一起加载
    public static void say(){
        System.out.println("I am public static Person.say");
//        read(); 由于未实例化,所以不能调用
    }

    //实例化时分类
    public void read(){
        System.out.println("I am public Person.read");
    }
}
