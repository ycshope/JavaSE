package Demo23;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//i<5(core+blocking)都是2个线程,i>5之才开启拓展线程

/**
 * i>8(max+blocking)后有可能会抛出异常
 * new ThreadPoolExecutor.AbortPolicy() 银行满了,还有人进来,不处理并抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy() 哪里来的去哪(这里是main执行)
 * new ThreadPoolExecutor.DiscardPolicy() 队列满了,不处理任务,不抛出异常
 * new ThreadPoolExecutor.DiscardOldestPolicy() 队列满了,尝试处理任务,不抛出异常
 */
public class PoolTest02 {
    public static void main(String[] args) {

        // 获取CPU的核数量
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 自定义线程池,ThreadPoolExecutor
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        try {
            //5之前都是2个线程,5之后才开启拓展线程
            for (int i = 0; i < 9; i++) {
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
