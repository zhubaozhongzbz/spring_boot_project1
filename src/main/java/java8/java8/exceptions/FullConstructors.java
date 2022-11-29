package java8.java8.exceptions;
//自己建立的异常，捕获后可以正常运行；
//系统产生的异常不能运行；
class MyException extends Exception{
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

public class FullConstructors {
    static  void  f() throws MyException,ArithmeticException {
        System.out.println("f()");
      //  int o=1/0;
          throw new MyException("这是F（）抛出的异常");
    }

    public static void main(String[] args)  {

        try {
           f();
            System.out.println(1111);
        } catch (Exception e) {
          // throw new RuntimeException(e);
          System.out.println("捕获到异常"+e.getMessage());
         //   e.printStackTrace(System.out);
        }

        System.out.println(222);
    }
}
