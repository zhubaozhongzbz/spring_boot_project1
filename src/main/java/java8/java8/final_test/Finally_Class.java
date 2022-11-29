package java8.java8.final_test;
//当说一个类是 final （final 关键字在类定义之前），就意味着它不能被继承。之所以这么做，是因为类的设计就是永远不需要改动，或者是出于安全考虑不希望它有子类。
//final 类的属性可以根据个人选择是或不是 final。这同样适用于不管类是否是 final 的内部 final 属性。然而，由于 final 类禁止继承，类中所有的方法都被隐式地指定为
// final，所以没有办法覆写它们。你可以在 final 类中的方法加上 final 修饰符，但不会增加任何意义
// reuse/Jurassic.java
// Making an entire class final
class SmallBrain {}

final class Dinosaur {
   //private  构造方法不能new；
    private  Dinosaur() {
    }
    static Dinosaur say(){
        return new Dinosaur();
   }
    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();

    void f() {}
}

//- class Further extends Dinosaur {}
// error: Cannot extend final class 'Dinosaur'
public class Finally_Class {
    public static void main(String[] args) {
        Dinosaur n = Dinosaur.say();
        n.f();
        n.i = 40;
        n.j++;
    }
}