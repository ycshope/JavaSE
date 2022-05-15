package Demo21;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

//队列大小只有1,取出后才能写入
public class SyncQueueTest {
    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        //入队
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " put 1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() + " put 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName() + " put 3");
                synchronousQueue.put("3");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "T1").start();
        //出队
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "=>" + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "=>" + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "=>" + synchronousQueue.take());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "T1").start();
    }
}
