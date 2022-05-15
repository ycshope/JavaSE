package Demo17;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    public static void main(String[] args) {
        //线程数量:停车位..限流
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();    //获得车位
                    System.out.println(Thread.currentThread().getName() + "枪到车位");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "离开车位");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();    //释放车位
                }
            }, String.valueOf(i)).start();
        }
    }
}
