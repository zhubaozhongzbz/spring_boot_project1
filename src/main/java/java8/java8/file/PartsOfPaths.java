package java8.java8.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PartsOfPaths {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));
        File file = new File("abc.java");
       if(!file.exists()) {
           file.createNewFile();
       };
        Path p = Paths.get("abc.java").toAbsolutePath();
        System.out.println("文件是否存在："+ Files.exists(p));
        System.out.println("打印path："+p);
        for(int i = 0; i < p.getNameCount(); i++)
            System.out.println(p.getName(i));
        System.out.println("ends with '.java': " +
                p.endsWith(".java"));
        for(Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
            if (p.endsWith(pp)) {
                System.out.println("文件结尾p.endsWith "+pp);
            }
            System.out.println("文件结尾p.endsWith:abc? "+p.endsWith("abc"));
        }
        System.out.println("Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));
    }
}