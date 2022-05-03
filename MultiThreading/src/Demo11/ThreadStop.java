package Demo11;

public class ThreadStop implements Runnable{
    //flag 为false时停止
    private boolean flag = true;

    @Override
    public void run() {
        while (flag){
            System.out.println("子线程running....");
        }
    }

    public void stop(){
        this.flag = false;
        System.out.println("子线程停止!!!!!!!!!!!");
    }

    public static void main(String[] args) {

        ThreadStop threadStop = new ThreadStop();
        new Thread(threadStop).start();

        for(int i=0; i<1000; i++){
            if ( i==500 ) {
                threadStop.stop();
                break;
            }
            System.out.println("main ..." + i);

        }
    }
}
