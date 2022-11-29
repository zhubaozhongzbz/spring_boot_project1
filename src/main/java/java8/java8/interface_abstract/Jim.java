package java8.java8.interface_abstract;

// 方法有相同的方法名但是签名不同——方法签名包括方法名和参数类型，编译器也是用它来区分方法
//返回类型不是方法签名的一部分，因此不能用来区分方法。为了解决这个问题，需要覆写冲突的方法
//当然，你可以重定义 jim() 方法，但是也能像上例中那样使用 super 关键字选择基类实现中的一种;
interface Jim1 {
    default void jim() {
        System.out.println("Jim1::jim");
    }
}

interface Jim2 {
    default void jim() {
        System.out.println("Jim2::jim");
    }
}

public class Jim implements Jim1, Jim2 {
   //这个方法必须有否则会报错
    @Override
    public void jim() {
        Jim2.super.jim();
    }

    public static void main(String[] args) {
        new Jim().jim();
    }
}
