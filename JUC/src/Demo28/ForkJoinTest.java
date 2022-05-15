package Demo28;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 普通程序员
        //test1(); sum=499999999500000000	 时间: 5199

        // ForkJoin
        //test2(); sum=499475711998114869	 时间: 2763

        // 并行流
       //test3(); sum=500000000500000000	 时间: 125

    }

    // 普通程序员
    public static void test1() {
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long i = 0L; i < 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "\t 时间: " + (end - start));
    }

    // ForkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> sumit = forkJoinPool.submit(task); //提交任务(异步)
        Long sum = sumit.get(); //获取结果

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "\t 时间: " + (end - start));
    }

    // 并行流 (]
    public static void test3(){
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "\t 时间: " + (end - start));
    }
}

class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    // 临界值
    private Long tmp = 1000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    //计算方法
    @Override
    protected Long compute() {
        // 问题较小时线性计算
        if ((end - start) < tmp) {
            Long sum = 0L;
            for (Long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }
        // 问题较大时forkjoin
        else {
            long mid = (start + end) / 2; //中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, mid);
            task1.fork(); //拆分任务,任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(mid + 1, end);
            task2.fork(); //拆分任务,任务压入线程队列

            //计算任务
            return task1.join() + task2.join();
        }
    }
}