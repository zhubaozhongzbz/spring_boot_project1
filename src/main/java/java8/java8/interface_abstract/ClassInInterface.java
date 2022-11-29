package java8.java8.interface_abstract;
//接口中的成员变量是 public static  final
//接口中方法是public  abstract
//接口中的内部类是public  static 的；因为可以被继承；
//抽象类不可以实例化，可以匿名实例

  abstract  class Test2{
      int i=0;
      public Test2() {
          System.out.println("抽象类构造方法"+(++i));
      }
  }
public interface ClassInInterface {


    void howdy();

    class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }


    }
    static  Test  get(){
        return  new Test();
    }


    class Test1 extends  Test {

        public static void main(String[] args) {
            ClassInInterface test=ClassInInterface.get();
            ClassInInterface test1= new Test();
            System.out.println(test==test1);
            Test2 test2=new Test2(){
                int a =1;

            };
        }
    }

}