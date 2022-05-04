package Demo20;

import java.util.ArrayList;
import java.util.List;

//线程不安全集合
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i <= 10000; i++) {
            new Thread(()-> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
