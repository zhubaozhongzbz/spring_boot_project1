package java8.java8.file.read_write;

import java.nio.file.Files;
import java.nio.file.Paths;
//如果文件大小有问题怎么办？ 比如说：
// 文件太大，如果你一次性读完整个文件，你可能会耗尽内存。
//您只需要在文件的中途工作以获得所需的结果，因此读取整个文件会浪费时间。
public class ReadLineStream {
    public static void main(String[] args) throws Exception {
        Files.lines(Paths.get("PathInfo.java"))
                .skip(13)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
