package java8.java8.final_test;
//空白 final 指的是没有初始化值的 final 属性。编译器确保空白 final 在使用前必须被初始化。这样既能使一个类的每个对象的 final 属性值不同，也能保持它的不变性。
//你必须在定义时或在每个构造器中执行 final 变量的赋值操作。这保证了 final 属性在使用前已经被初始化过。
class Poppet {
    private int i;

    Poppet(int ii) {
        i = ii;
    }
}

public class BlankFinal {
    private final int i = 0; // Initialized final
    private final int j; // Blank final
    private final Poppet p; // Blank final reference
    // Blank finals MUST be initialized in constructor
    public BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet(1); // Init blank final reference
    }

    public BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Poppet(x); // Init blank final reference
    }
//    public void  say(){
//        j=1;
//    }
    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
