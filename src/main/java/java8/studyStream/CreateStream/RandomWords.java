package java8.studyStream.CreateStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//Stream.generate() 的用法，它可以把任意 Supplier<T> 用于生成 T 类型的流
// File 类将 Cheese.dat 文件的所有行读取到 List<String> 中
public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);
    RandomWords(String fname) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fname));
        // 略过第一行
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+"))
                words.add(word.toLowerCase());
        }
    }
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }
    @Override
    public String toString() {
        return words.stream()
                .collect(Collectors.joining(" "));
    }
    public static void main(String[] args) throws Exception {
        System.out.println(
                //Stream.generate返回:一个新的无限顺序流
                Stream.generate(new RandomWords("D:\\maven_workspace" +
                                "\\java8\\zbz.mvn.java8\\src\\main\\java\\com" +
                                "\\zbz\\studyStream\\CreateStream\\Cheese.dat"))
                        .limit(10)
        //collect() 操作，它根据参数来结合所有的流元素。
        // 当你用 Collectors.joining()作为 collect() 的参数时，
        // 将得到一个String 类型的结果，该结果是流中的所有元素被joining()的参数隔开。
        // 还有很多不同的 Collectors 用于产生不同的结果。
                        .collect(Collectors.joining(" ")));
    }


}
