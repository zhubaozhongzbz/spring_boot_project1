package java8.concurrent.callable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        FutureTask<String> futureTask = new FutureTask(new Callable01());//适配器类
//
//        new Thread(futureTask,"a").start();
//        new Thread(futureTask,"b").start();//这个不会执行
//        String o = futureTask.get();//会阻塞
//        System.out.println("o = " + o);
//        System.out.println("aaaaaa");
//        CompletableFuture cf = new CompletableFuture();
//        CompletableFuture<String> stringCompletableFuture = cf.supplyAsync(() -> "completableFuture").whenComplete((a, b) -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("a = " + a);
//            System.out.println("b = " + b);
//        });
//        System.out.println("aaaaaaaaaa");
//        String o = stringCompletableFuture.join();
//        System.out.println("cf = " +  o);
//
//        System.out.println("bbbbbbbbbbb");

        ArrayBlockingQueue<Integer> integers = new ArrayBlockingQueue<>(3);
        integers.put(1);

    }



}
class  Callable01 implements Callable<String>{


    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return "qqqqq";
    }
}