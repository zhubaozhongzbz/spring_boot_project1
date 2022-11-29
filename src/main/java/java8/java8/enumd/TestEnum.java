package java8.java8.enumd;

public class TestEnum {
    enum  shoud {WE,ME,HE,HER};

    public static void main(String[] args) {
        //返回enum的成员的数组；
        shoud[] values = shoud.values();
        shoud value = values[0];
        //valueOF 不包含会返回异常
        try {
            shoud me = shoud.valueOf("Me");
        } catch (IllegalArgumentException e) {

            throw new RuntimeException(e);
        }finally {
            System.out.println("finally");
        }
        //枚举的下标0
        int ordinal = shoud.ME.ordinal();
        System.out.println(ordinal);
        //
        String name = shoud.ME.name();
        System.out.println("ME.name："+name);
        //
        System.out.println(shoud.ME.hashCode());
        System.out.println(shoud.ME.getDeclaringClass());
        System.out.println(shoud.ME.getClass());
        // return this==other
        System.out.println(shoud.ME.equals(shoud.HE));
    }
}
