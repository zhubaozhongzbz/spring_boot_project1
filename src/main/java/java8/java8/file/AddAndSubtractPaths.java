package java8.java8.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
//Paths的增减修改
//我们必须能通过对 Path 对象增加或者删除一部分来构造一个新的 Path 对象。我们使用 relativize() 移除 Path 的根路径，使用 resolve() 添加 Path 的尾路径(不一定是“可发现”的名称)。
//
//对于下面代码中的示例，我使用 relativize() 方法从所有的输出中移除根路径，部分原因是为了示范，部分原因是为了简化输出结果，这说明你可以使用该方法将绝对路径转为相对路径。 这个版本的代码中包含 id，以便于跟踪输出结果
public class AddAndSubtractPaths {
    static Path base = Paths.get("..", "..", "..").toAbsolutePath().normalize();
    static void show(int id, Path result) {
        if(result.isAbsolute())
            System.out.println("(" + id + ")r " + base.relativize(result));
        else
            System.out.println("(" + id + ") " + result);
        try {
            System.out.println("RealPath: " + result.toRealPath());
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(base);
        Path p = Paths.get("abc.java").toAbsolutePath();
        show(1, p);
        Path convoluted = p.getParent().getParent()
                .resolve("strings").resolve("..")
                .resolve(p.getParent().getFileName());
        show(2, convoluted);
        show(3, convoluted.normalize());
        Path p2 = Paths.get("..", "..");
        show(4, p2);
        show(5, p2.normalize());
        show(6, p2.toAbsolutePath().normalize());
        Path p3 = Paths.get(".").toAbsolutePath();
        Path p4 = p3.resolve(p2);
        show(7, p4);
        show(8, p4.normalize());
        Path p5 = Paths.get("").toAbsolutePath();
        show(9, p5);
        show(10, p5.resolveSibling("strings"));
        show(11, Paths.get("nonexistent"));
    }
}
