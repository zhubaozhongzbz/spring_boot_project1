package java8.studyStream.CreateStream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws Exception {
        Files.lines(Paths.get(filePath))
                .skip(1) // 略过开头的注释行
                .forEach(line -> {
                    for (String w : line.split("[ .?,]+"))
                        builder.add(w);
                });
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws Exception {
//        new FileToWordsBuilder("Cheese.dat")
//                .stream()
//                .limit(7)
//                .map(w -> w + " ")
//                .forEach(System.out::print);
        Stream.iterate(2, i -> i + 1).limit(10).forEach(System.out::println);
        System.out.println(Math.sqrt(3));
    }
}
