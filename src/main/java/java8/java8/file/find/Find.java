package java8.java8.file.find;



import java8.java8.file.watch.Directories;

import java.nio.file.*;

public class Find {
    public static void main(String[] args) throws Exception {
        Path test = Paths.get("test");
        Directories.refreshTestDir();
        Directories.populateTestDir();
        // Creating a *directory*, not a file:
        Files.createDirectory(test.resolve("dir.tmp"));
        PathMatcher matcher = FileSystems.getDefault()
                .getPathMatcher("glob:**/*.{tmp,txt}");
        Files.walk(test)
                .filter(matcher::matches)
                .forEach(System.out::println);
        System.out.println("***************");
        PathMatcher matcher2 = FileSystems.getDefault()
                .getPathMatcher("glob:*.tmp");
        Files.walk(test)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
        System.out.println("***************");
        Files.walk(test) // Only look for files
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
    }
}
//在 matcher 中，glob 表达式开头的 **/ 表示“当前目录及所有子目录”，
// 这在当你不仅仅要匹配当前目录下特定结尾的 Path 时非常有用。
// 单 * 表示“任何东西”，然后是一个点，然后大括号表示一系列的可能性—-我们正在寻找以
// .tmp 或 .txt 结尾的东西。您可以在 getPathMatcher() 文档中找到更多详细信息。