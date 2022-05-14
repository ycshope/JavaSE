package Demo10.Test01;

import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone1 = new Phone();

        new Thread(()->{
            phone.sendSms();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        new Thread(()->{
//            phone.call();
//        }).start();

//        new Thread(()->{
//            phone.hello();
//        }).start();
        new Thread(()->{
            phone1.call();
        }).start();

    }
}
//对象方法
//synchronized锁的是对象,这里锁的是phone
class Phone{
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("发短信");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("你好");
    }

}