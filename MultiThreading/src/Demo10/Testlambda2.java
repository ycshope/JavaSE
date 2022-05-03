package Demo10;

public class Testlambda2 {
    public static void main(String[] args) {

        //注意:只有一个参数时才合适
        ILove love = (String name,int years)->{
            System.out.println("i love "+name + " " + years + " years");
        };
        love.love("shuner",520);

        //lambda简化:去掉参数类型
        love = (name, years) -> {
            System.out.println("i love "+name + " " + years + " years");
        };
        love.love("kali",250);

    }
}

interface ILove{
    void love(String name,int years);
}