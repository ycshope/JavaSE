import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayDemo02 {
    public static void main(String[] args) {
        int[] a = {3,4,1,2,5,8,7};

        System.out.println(Arrays.toString(a));

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        //填充
        Arrays.fill(a,2,4,0);
        System.out.println(Arrays.toString(a));

    }
}
