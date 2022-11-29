package java8.concurrent.parallel;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionIntoStream {
    public static void main(String[] args) {
        AtomicInteger i= new AtomicInteger();
        List<String> strings = Stream.generate(( )-> i.incrementAndGet())
                .map(String::valueOf)
                .limit(10)
                .collect(Collectors.toList());
        strings.forEach(System.out::println);
        // Convert to a Stream for many more options:
        String result = strings.stream()
                .map(String::toUpperCase)
              //  .map(s -> s.substring(2))
                .reduce(":", (s1, s2) -> s1 + s2);
        System.out.println(result);
    }
}