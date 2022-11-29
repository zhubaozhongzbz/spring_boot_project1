package java8.concurrent.completableFutures.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureCreate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.completedFuture(Integer.valueOf(22));
      //  completableFuture.join();
        //completableFuture.get();
        CompletableFuture.supplyAsync(()->{
            System.out.println("a");
            return 11;
        }).whenCompleteAsync((t,u)->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t = " + t);
            System.out.println("t = " + u);
        }).exceptionally(
                throwable -> {System.out.println("throwable = " + throwable.getMessage());return 12;}
        ).get();
    }
}
