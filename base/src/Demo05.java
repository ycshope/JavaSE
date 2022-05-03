public class Demo05 {
    public static void main(String[] arg){
        //byte,short,char -> int -> long -> float -> double

        //运算时,不同类型的数据先转换为同一类型(低精度到高精度),然后进行计算
        int a = 128;
        byte b = (byte) a;
        System.out.println(b); //byte类型溢出 -128

        //自动转换类型:高精度向低精度转换转换
        System.out.println("=====================");
        System.out.println((int)23.7); //23
        System.out.println((int)-45.89f); //-45

        //强制转换类型  char + int = int
        System.out.println("=====================");
        char c = 'a';
        int d = c + 1;
        System.out.println(d); //98
        System.out.println((char)d); //b
    }
}
