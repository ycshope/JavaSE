package Demo10.Test01;

import java.util.concurrent.TimeUnit;

public class Test02 {
    public static void main(String[] args) {
        Phone1 phone = new Phone1();
        Phone1 phone1 = new Phone1();
        new Thread(()->{
            phone.sendSms();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(()->{
            phone1.call();
        }).start();
    }
}

//类(静态)方法,锁的是类
class Phone1{
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("发短信");
    }
    public static synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("你好");
    }

}
