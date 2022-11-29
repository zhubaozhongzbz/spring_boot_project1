package java8.concurrent.executorservice.atomic;


import java8.concurrent.executorservice.Nap;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//我使用 peek() 将 QuittableTasks 传递给 ExecutorService ，然后将这些任务收集到 List.main() 中，只要任何任务仍在运行，就会阻止程序退出。
// 即使为每个任务按顺序调用 quit() 方法，任务也不会按照它们创建的顺序关闭。独立运行的任务不会确定性地响应信号
public class QuittingTasks {
    public static final int COUNT = 150;
    public static void main(String[] args) {
        ExecutorService es =
                Executors.newCachedThreadPool();
        List<QuittableTask> tasks =
                IntStream.range(1, COUNT)
                        .mapToObj(QuittableTask::new)
                        .peek(qt -> es.execute(qt))
                        .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        es.shutdown();
    }
}
//我使用 peek() 将 QuittableTasks 传递给 ExecutorService ，然后将这些任务收集到 List.main() 中，只要任何任务仍在运行，就会阻止程序退出。
// 即使为每个任务按顺序调用 quit() 方法，任务也不会按照它们创建的顺序关闭。独立运行的任务不会确定性地响应信号。