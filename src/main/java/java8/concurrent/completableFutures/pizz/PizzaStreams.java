package java8.concurrent.completableFutures.pizz;



import java8.concurrent.parallel.Timer;

import java.util.stream.IntStream;

public class PizzaStreams{
    static final int QUANTITY = 8;
    public static void main(String[] args){
        Timer timer = new Timer();
        IntStream.range(0, QUANTITY)
                .mapToObj(Pizza::new)
                .parallel();//[1];
     //           .forEach(za -> { while(!za.complete()) za.next(); });
        System.out.println(timer.duration());

        Long a=new Long(12l);
        Long b=new Long (12l);
        System.out.println(a==b);
        Long c=120l;
        Long d=120l;
        System.out.println(c==d);



    }
}
