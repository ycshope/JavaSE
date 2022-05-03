public class Demo07 {
    //类变量 static
    static double salary = 2500;

    //常量:修饰符,不存阿紫啊先后顺序
    static final double PI = 3.14;

    //属性:变量  默认值为空
    String name;
    int age;

    public static void main(String[] args) {
        //局部变量:必须声明和初始化
        int i = 10;
        System.out.println(i); //10

        //变量类型
        Demo07 demo07 = new Demo07();
        System.out.println(demo07.age); //0
        System.out.println(demo07.name); //null

        //类变量
        System.out.println(salary); //2500
    }

    //其他方法
    public void add(){

    }
}
