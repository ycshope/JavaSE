package Demo15;

import java.util.Scanner;

public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()-> {
            for( int i=0; i<5 ; i++ ){

                // RUNNABLE
                try {
                    Thread.sleep(1000); //TIMED_WAITING
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("线程结束.....");
        });

        //观察状态1
        Thread.State state = thread.getState();
        System.out.println(state); //NEW

        //观察启动后
        thread.start(); //启动线程
        while ( state != Thread.State.TERMINATED){ //只要线程不中止一直输出状态
            Thread.sleep(100);
            state=thread.getState();//更新线程状态
            System.out.println(state); //输出状态

        }
        //TERMINATED

        //NEW->RUNNABLE->WAITING->TIMED_WAITING->BLOCKED->TERMINATED
    }
}
