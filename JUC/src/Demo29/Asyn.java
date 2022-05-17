package Demo29;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用: CompletableFuture
 * 异步执行
 * 成功回调
 * 失败回调
 */
public class Asyn {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //发起异步请求 ajax
        // 空返回值用 CompletableFuture.runAsync
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "ajax success..");
                //int i = 200;
                int i = 200/0; //制造异常
                return i;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("code ending...");

        // 空返回值用 completableFuture.get()
        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>"+t);    //正常的返回结果
            System.out.println("u=>"+u);    //异常的返回结果
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 500;
        }).get());  //获取阻塞执行结果
    }
}
