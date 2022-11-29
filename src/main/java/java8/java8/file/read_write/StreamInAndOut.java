package java8.java8.file.read_write;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//Files.lines() 对于把文件处理行的传入流时非常有用，但是如果你想在 Stream 中读取，处理或写入怎么办
//因为我们在同一个块中执行所有操作，所以这两个文件都可以在相同的 try-with-resources 语句中打开。
// PrintWriter 是一个旧式的 java.io 类，允许你“打印”到一个文件，所以它是这个应用的理想选择。
// 如果你看一下 StreamInAndOut.txt，你会发现它里面的内容确实是大写的
public class StreamInAndOut {
    public static void main(String[] args) throws IOException {




        try(
                Stream<String> input =
                        Files.lines(Paths.get("StreamInAndOut.java"));
                PrintWriter output =
                        new PrintWriter("StreamInAndOut.txt")
        ) {
            input.map(String::toUpperCase)
                    .forEachOrdered(output::println);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
