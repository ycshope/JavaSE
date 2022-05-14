package Demo13;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
    public static void main(String[] args) {
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        //工作中不用HashMap,大型项目中都是用到多线程
        //默认参数是什么new HashMap<>(16,0.75)
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
