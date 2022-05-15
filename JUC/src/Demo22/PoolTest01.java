package Demo22;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolTest01 {
    public static void main(String[] args) {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor(); //单个线程
        ExecutorService fixThreadPool = Executors.newFixedThreadPool(10); //固定线程池
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool(); //可伸缩线程池
        ExecutorService threadPool = cacheThreadPool;

        try {
            for (int i = 0; i < 100; i++) {
                //使用了线程池之后,使用线程池来创建线程,重写Runnable
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //线程池使用完要关闭
            threadPool.shutdown();
        }
    }
}
