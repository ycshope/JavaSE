package Demo02;

import java.util.ArrayList;
import java.util.List;

public class Test01 extends Object {

    //@Override 重写的注解
    @Override
    public String toString(){
        return super.toString();
    }

    //@Deprecated 废弃的方法,但是依旧可以使用
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }

    @SuppressWarnings("all")
    public void test02(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
