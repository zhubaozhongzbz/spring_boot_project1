package java8.concurrent.executorservice.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
//现在我们每次都得到一致的结果，尽管 InterferingTask 缺乏线程安全性。
// 这是 SingleThreadExecutor 的主要好处 - 因为它一次运行一个任务，这些任务不会相互干扰，因此强加了线程安全性。
// 这种现象称为线程封闭，因为在单线程上运行任务限制了它们的影响。线程封闭限制了加速，但可以节省很多困难的调试和重写。
public class SingleThreadExecutor3 {
    public static void main(String[] args)throws InterruptedException {
        ExecutorService exec
                = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10)
                .mapToObj(InterferingTask::new)
                .forEach(exec::execute);
        exec.shutdown();
    }
}