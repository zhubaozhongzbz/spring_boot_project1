package java8.concurrent.executorservice.callable;

import java.util.stream.IntStream;
//[1] 当你的任务在尚未完成的 Future 上调用 get() 时，调用会阻塞（等待）直到结果可用。
//但这意味着，在 CachedThreadPool3.java 中，Future 似乎是多余的，因为 invokeAll() 甚至在所有任务完成之前都不会返回。但是，这里的 Future 并不用于延迟结果，而是用于捕获任何可能发生的异常。
//
//还要注意在 CachedThreadPool3.java.get() 中抛出异常，因此 extractResult() 在 Stream 中执行此提取。
//
//因为当你调用 get() 时，Future 会阻塞，所以它只能解决等待任务完成才暴露问题。最终，Futures 被认为是一种无效的解决方案，现在不鼓励，我们推荐 Java 8 的 CompletableFuture ，这将在本章后面探讨。当然，你仍会在遗留库中遇到 Futures。
//
//我们可以使用并行 Stream 以更简单，更优雅的方式解决这个问题:
public class CountingStream {
    public static void main(String[] args) {
        System.out.println(
                IntStream.range(0, 10)
                        .parallel()
                        .mapToObj(CountingTask::new)
                        .map(ct -> ct.call())
                        .reduce(0, Integer::sum));
    }
}
