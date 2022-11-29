package java8.java8.class_initialization;

class A{
    String say(){
        System.out.println("a :say");
        return "say";
    };
    void  get(){
        System.out.println("a:get");
    }
}
class B extends A {
    @Override
    String say() {
        System.out.println("b:say");
        return "b";
    }

    void set(){

    }
}
public class Testupanddown {
    public static void main(String[] args) {
//        A a=new B();
//        a.say();
//        A a=new A();
//        B b= (B) a;
//        b.say();

    }

}
