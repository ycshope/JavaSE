public class Demo03 {
    public static void main(String[] arg){
        //float和double计算会有偏差,遵顼舍人误差,接近但是不等于
        //最好不要使用浮点数进行比较

        float f = 0.1f;
        double d = 1.0/10;

        System.out.println(f==d); //false

        float f1 = 12313212313123132123f;
        float f2 = f1 + 1;
        System.out.println(f2==f1); //true

        System.out.println("=========================");
        char c1 = 'a';
        char c2 = '中';
        System.out.println(c1); //a
        System.out.println((int)c1); //97
        System.out.println(c2); //中
        System.out.println((int)c2); //20013

        //所有的字符本质还是数字
        //以上均翻译成了Unicode字符

        char c3= '\u0061';
        System.out.println(c3); //a

        System.out.println("=========================");
        String sa = new String("hello world");
        String sb = new String("hello world");
        System.out.println(sa==sb); //false

        String sc = "hello world";
        String sd = "hello world";
        System.out.println(sc==sd); //true
        //对象 从内存角度分析

    }
}
