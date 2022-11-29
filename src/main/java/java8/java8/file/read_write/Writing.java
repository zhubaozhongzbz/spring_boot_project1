package java8.java8.file.read_write;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Writing {
    //Files.write() 被重载以写入 byte 数组或任何 Iterable 对象（它也有 Charset 选项）：
    //我们使用 Random 来创建一个随机的 byte 数组; 你可以看到生成的文件大小是 1000。
    //
    //一个 List 被写入文件，任何 Iterable 对象也可以这么做。
    static Random rand = new Random(47);
    static final int SIZE = 1000;
    public static void main(String[] args) throws Exception {
        // Write bytes to a file:
        byte[] bytes = new byte[SIZE];
        rand.nextBytes(bytes);
        Files.write(Paths.get("bytes.dat"), bytes);
        System.out.println("bytes.dat: " + Files.size(Paths.get("bytes.dat")));
        // Write an iterable to a file:
        List<String> lines = Files.readAllLines(
                Paths.get("../streams/Cheese.dat"));
        Files.write(Paths.get("Cheese.txt"), lines);
        System.out.println("Cheese.txt: " + Files.size(Paths.get("Cheese.txt")));
    }
}