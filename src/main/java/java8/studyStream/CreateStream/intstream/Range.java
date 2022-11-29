package java8.studyStream.CreateStream.intstream;


import static java.util.stream.IntStream.range;
import static java.util.stream.LongStream.rangeClosed;
//import static 从JDK1.5开始(导入后可直接调用相应的静态方法或者属性)

public class Range {
    public static void main(String[] args) {
        int  result =0;
        for (int i = 10; i <20 ; i++) {
            result+=i;
        }
        System.out.println(result);


        result=0;
        for (int i:range(10,20).toArray()
             ) {
            result+=i;
        }
        System.out.println("result = " + result);

        System.out.println(range(10,20).sum());


        range(0,3).forEach(a-> System.out.println(a));
        int n=100;
        boolean b=rangeClosed(2, n)
                .noneMatch(i -> n% i == 0);
        System.out.println(b);
        System.out.println(Math.sqrt(n));
    }
}
