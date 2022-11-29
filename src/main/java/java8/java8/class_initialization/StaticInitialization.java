package java8.java8.class_initialization;

class Bowl {
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }
    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }
}
class Table {
    static Bowl bowl1 = new Bowl(1);
    Table() {
        System.out.println("Table()");
        bowl2.f1(1);
    }
    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }
    static Bowl bowl2 = new Bowl(2);
}
class Cupboard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }
    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}
public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("main creating new Cupboard()");
        new Cupboard();
        System.out.println("main creating new Cupboard()");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}


//静态初始化只有在必要时刻才会进行。如果不创建 Table 对象，也不引用 Table.bowl1 或 Table.bowl2，那么静态的 Bowl 类对象 bowl1 和 bowl2 永远不会被创建。只有在第一个 Table
// 对象被创建（或被访问）时，它们才会被初始化。此后，静态对象不会再次被初始化。
//初始化的顺序先是静态对象（如果它们之前没有被初始化的话），然后是非静态对象，从输出中可以看出。要执行 main() 方法，必须加载 StaticInitialization 类，它的静态属性 table 和 cupboard
// 随后被初始化，这会导致它们对应的类也被加载，而由于它们都包含静态的 Bowl 对象，所以 Bowl 类也会被加载。
// 因此，在这个特殊的程序中，所有的类都会在 main() 方法之前被加载。实际情况通常并非如此，因为在典型的程序中，不会像本例中所示的那样，将所有事物通过 static 联系起来。