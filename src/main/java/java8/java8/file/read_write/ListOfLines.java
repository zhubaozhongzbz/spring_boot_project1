package java8.java8.file.read_write;

import java.nio.file.Files;
import java.nio.file.Paths;
//Files.readAllLines() 一次读取整个文件（因此，“小”文件很有必要），产生一个List
//readAllLines() 有一个重载版本，包含一个 Charset 参数来存储文件的 Unicode 编码
public class ListOfLines {
    public static void main(String[] args) throws Exception {
        Files.readAllLines(
                        Paths.get("abc.java" ))
                .stream()
                .filter(line -> !line.startsWith("//"))
                .map(line ->
                        line.substring(0, line.length()/2))
                .forEach(System.out::println);
    }
}