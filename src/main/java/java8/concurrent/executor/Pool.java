package java8.concurrent.executor;


import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Pool {
  public static  ThreadPoolExecutor executor = new ThreadPoolExecutor(2,//线程核心数，一直开着的；
            6,//最大核心数，队列满了，打开。空闲数6-2=4
            2,//空闲线程保持等待时间，时间到了就消亡
            TimeUnit.SECONDS,//保持等待时间单位
            new LinkedBlockingQueue<>(3),//堵塞队列
            Executors.defaultThreadFactory(),//线程工厂
            new ThreadPoolExecutor.CallerRunsPolicy()//拒绝策略，阻塞队列和最大核心数都达到最大值就使用
    );

    public static void main(String[] args) {
        System.out.println("Runtime.getRuntime().freeMemory() = " + Runtime.getRuntime().freeMemory());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        ExecutorService cachedThreadPool= Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,//线程核心数，一直开着的；
                6,//最大核心数，队列满了，打开。空闲数6-2=4
                2,//空闲线程保持等待时间，时间到了就消亡
                TimeUnit.SECONDS,//保持等待时间单位
                new LinkedBlockingQueue<>(3),//堵塞队列
                Executors.defaultThreadFactory(),//线程工厂
                new ThreadPoolExecutor.CallerRunsPolicy()//拒绝策略，阻塞队列和最大核心数都达到最大值就使用
        );
        /**CallerRunsPolicy
         *
         */
        System.out.println(IntStream.range(0, 10).mapToObj(Run::new).peek(threadPoolExecutor::submit).count());
        IntStream.range(0,150).parallel().mapToObj(Run::new).forEachOrdered(i->i.run());

        threadPoolExecutor.shutdown();
    }

       private static  class  Run implements Runnable{
            private   int id;
           public Run(int id) {
               this.id=id;
           }

           @Override
            public void run() {
                System.out.println(id+"  Thread.currentThread().getName() = "+id + Thread.currentThread().getName());
            }
        }

}
