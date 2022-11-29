package java8.concurrent.executorservice.callable;

import java.util.concurrent.Callable;
//call() 完全独立于所有其他 CountingTasks 生成其结果，这意味着没有可变的共享状态
public class CountingTask implements Callable<Integer> {
    final int id;
    public CountingTask(int id) { this.id = id; }
    @Override
    public Integer call() {
        Integer val = 0;
        for(int i = 0; i < 100; i++)
            val++;
        System.out.println(id + " " +
                Thread.currentThread().getName() + " " + val);
        return val;
    }
}
