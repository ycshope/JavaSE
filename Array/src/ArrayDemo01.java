public class ArrayDemo01 {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        //数组遍历
        for(int x:a){
            System.out.println(x);
        }


        int[][] biArr=new int[10][10] ;
        biArr[1][3]=1;
        biArr[2][4]=2;
        //二维数组遍历
        for(int []row:biArr){
            for(int col:row){
                System.out.print(col+"\t");
            }
            System.out.println();

        }
    }
}
