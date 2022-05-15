package Demo27;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

class User {
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return this.name;
    }
}

/**
 * 题目要求:只能用一行代码实现如下操作
 * 筛选：
 * 1.ID必须是偶数
 * 2.年龄必须大于23岁
 * 3.用户名转换大写
 * 4.用户名倒序
 * 5.输出第一个用户
 */
public class StreamTest {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 22);
        User u3 = new User(3, "c", 23);
        User u4 = new User(4, "d", 24);
        User u5 = new User(6, "e", 25);
        //集合就是存储
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        //计算交给Stream流
        //lambda表达式,链式编程,函数式接口,Stream流式计算
        // filter 断定型接口
        list.stream()
                .filter(user -> { return user.getId() % 2 == 0;})
                .filter(user -> { return user.getAge() > 23; })
                .map(user -> { return user.getName().toUpperCase();})
                .sorted((user1,user2) -> { return user2.compareTo(user1);} )
                .limit(1)
                .forEach(System.out::println);
    }

}
