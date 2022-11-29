package java8.concurrent.executorservice.atomic;



import java8.concurrent.executorservice.Nap;

import java.util.concurrent.atomic.AtomicBoolean;
//Java 5 引入了 Atomic 类，它提供了一组可以使用的类型，而不必担心并发问题。
// 我们将添加 AtomicBoolean 标志，告诉任务清理自己并退出。
public class QuittableTask implements Runnable {
    final int id;
    public QuittableTask(int id) {
        this.id = id;
    }
    private AtomicBoolean running =
            new AtomicBoolean(true);
    public void quit() {
        running.set(false);
    }
    @Override
    public void run() {
        while(running.get())         // [1]
            new Nap(0.1);
        System.out.print(id + " ");  // [2]
    }
}
