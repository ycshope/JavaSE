package Demo10;

public class Testlambda1 {
    //4.静态内部类,将实现函数放到类中进行简化+
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like lambda2!");
        }
    }

    public static void main(String[] args) {
        //2.实现类
        ILike like = new Like();
        like.lambda();

        //3.静态类实现
        like = new Like2();
        like.lambda();

        //4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like lambda3!");
            }
        }

        like = new Like3();
        like.lambda();

        // 5.匿名内部类,没有类的名称,必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4!");
            }
        };

        like.lambda();

        //6.lambda简化,可以理解为自动匹配类型,要求是只有一个实现方法
        like = ()->{
            System.out.println("i like lambda5!");
        };
        like.lambda();
    }
}

//1.定义一个函数式接口
interface ILike{
    void lambda();
}

//2.实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda!");
    }
}