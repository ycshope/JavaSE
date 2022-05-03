public class Demo06 {
    public static void main(String[] arg){
        //操作比较大的数时候注意溢出问题
        //JDK7特性,数字之间可以用_分割
        int money = 10_0000_0000;
        int years = 20;
        int total = money*years; //-1474836480,计算时溢出
        System.out.println(total);

        long total2 = money*years; //-1474836480,默认是int,转换之前就已经计算完成
        System.out.println(total2);

        long total3 =  money*((long)years); //其中一个先转换成Long,另一个类型自动转换
        System.out.println(total3);

    }
}
