package Demo11;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//java.util.ConcurrentModificationException 并发修改异常
public class ListTest {
    public static void main(String[] args) {
        //并发下ArrayList不安全,没有加锁
        //ArrayList<Object> list = new ArrayList<>();

        /*
         * Solution:
         * 1.向量     Vector<Object> list = new Vector<>(); 用synchronized实现
         * 2.工具类     List<Object> list = Collections.synchronizedList(new ArrayList<>());
         * 3.JUC    CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>(); 底层用锁解决,效率最高
         * COW用的是读写分离,读的时候固定,写的时候拷贝
         * */
//        Vector<Object> list = new Vector<>();
//        List<Object> list = Collections.synchronizedList(new ArrayList<>());

        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }).start();
        }
    }
}
