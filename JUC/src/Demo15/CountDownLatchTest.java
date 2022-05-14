package Demo15;

import java.util.concurrent.CountDownLatch;

//计数器,下标为0时候才会结束;
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        //必要任务需要执行时才使用
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(()-> {
                System.out.println(Thread.currentThread().getName() + " Leaved");
                countDownLatch.countDown(); //计数器减少
            },String.valueOf(i)).start();
        }

        countDownLatch.await(); //等待计数器归零才向下执行

        System.out.println("Close Door");
    }
}
