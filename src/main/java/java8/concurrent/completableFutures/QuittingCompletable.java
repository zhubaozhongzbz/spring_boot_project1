package java8.concurrent.completableFutures;
import java8.concurrent.executorservice.Nap;
import java8.concurrent.executorservice.atomic.QuittableTask;
import java8.concurrent.executorservice.atomic.QuittingTasks;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class QuittingCompletable {
    public static void main(String[] args) {
        List<QuittableTask> tasks =
                IntStream.range(1, QuittingTasks.COUNT)
                        .mapToObj(QuittableTask::new)
                        .collect(Collectors.toList());
        List<CompletableFuture<Void>> cfutures =
                tasks.stream()
                        .map(CompletableFuture::runAsync)
                        .peek((a)->System.out.println(a.isCancelled()))
                        .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        cfutures.forEach(CompletableFuture::join);
    }
}