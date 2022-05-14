package Demo10.Test01;

import java.util.concurrent.TimeUnit;
//1.一个类方法一个对象方法,一个对象谁先执行?
//2.一个类方法一个对象方法,两个对象谁先执行?
public class Test03 {
    public static void main(String[] args) {
        Phone3 phone = new Phone3();
//        Phone3 phone1 = new Phone3();
        new Thread(()->{
            phone.sendSms();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(()->{
            phone.call();
        }).start();
    }
}
class Phone3{
    //类方法
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("发短信");
    }
    //对象方法
    public synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("你好");
    }

}