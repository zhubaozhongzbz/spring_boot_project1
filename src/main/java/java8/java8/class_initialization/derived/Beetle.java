package java8.java8.class_initialization.derived;

class Insect {
    private int i = 9;
    protected int j;
    private int n = printInit("Beetle.n.initialized");
    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 = printInit("static Insect.x1 initialized");
    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
    void say() {
        System.out.println("父類");

    }
}
public class Beetle extends Insect {
    private int k = printInit("Beetle.k.initialized");
    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }
    void say() {
        System.out.println("子類");
        j = 39;
    }
    private static int x2 = printInit("static Beetle.x2 initialized");
    public static void main(String[] args) {
//        System.out.println("Beetle constructor");
//        Beetle b = new Beetle();
        Insect s=new Insect();
        s.say();
    }
}
//先初始化父类的静态代码后子类静态。然后 初始化父类 成员变量和构造方法，然后子类的成员和构造方法。