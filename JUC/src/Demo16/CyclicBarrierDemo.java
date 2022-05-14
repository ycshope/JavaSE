package Demo16;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        /**
         * 7龙珠召唤神龙
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("出来吧，神龙，实现我的愿望");
        });

        for (int i = 1; i <= 7; i++) {
            final int tmp = i;

            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集"+tmp+"个龙珠");
                try {
                    Thread.sleep(2000);
                    cyclicBarrier.await(); //等待,并且 +1
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        System.out.println("比克大魔王来也");
    }
}
