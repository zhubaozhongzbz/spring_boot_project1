package java8.concurrent.executorservice.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
//输出不是我们所期望的，并且从一次运行到下一次运行会有所不同。
// 问题是所有的任务都试图写入 val 的单个实例，并且他们正在踩着彼此的脚趾。我们称这样的类是线程不安全的
public class CachedThreadPool2 {
    public static void main(String[] args) {
        ExecutorService exec
                = Executors.newCachedThreadPool();
        IntStream.range(0, 10)
                .mapToObj(InterferingTask::new)
                .forEach(exec::execute);
        exec.shutdown();
    }
}