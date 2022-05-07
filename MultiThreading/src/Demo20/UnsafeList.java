package Demo20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//线程不安全集合
//测试JUC安全类型的集合,但还是有问题
public class UnsafeList {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
        //JUC安全类
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

        for (int i = 0; i < 10000; i++) {
            new Thread(()-> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
