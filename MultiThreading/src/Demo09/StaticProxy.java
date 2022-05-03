package Demo09;
//静态代理模式总结:
//真实对象和代理对象都要实现同一个接口
//代理对象要代理实现真实角色
//好处:
    //代理对象可以做很多真实角色做不了的事情
    //真实对象专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        new WeddingCompany(you).HarryMarry();
    }
}

interface Marry{
    void HarryMarry();
}

//真实角色,你去结婚
class You implements Marry{

    @Override
    public void HarryMarry() {
        System.out.println("我要结婚了");
    }
}

//代理角色,帮你完成婚礼
class WeddingCompany implements Marry{

    //定义一个接口
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HarryMarry() {
        before();
        this.target.HarryMarry();
        after();
    }

    private void after() {
        System.out.println("结婚后,收尾款");
    }

    private void before() {
        System.out.println("结婚前,布置婚礼现场");
    }
}