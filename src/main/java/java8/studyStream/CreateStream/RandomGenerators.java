package java8.studyStream.CreateStream;

import java.util.Random;
import java.util.stream.Stream;
//随机数流
public class RandomGenerators {
    //。类型参数 T 可以是任何类型，所以这个方法对 Integer、Long 和 Double 类型都生效。
    // 但是 Random 类只能生成基本类型 int， long， double 的流。
    // 幸运的是， boxed() 流操作将会自动地把基本类型包装成为对应的装箱类型，从而使得 show() 能够接受流。
    public static <T> void show(Stream<T> stream) {
        stream
                .limit(4)
                .forEach(System.out::println);
        System.out.println("++++++++");
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        show(rand.ints().boxed());
        show(rand.longs().boxed());
        show(rand.doubles().boxed());
        // 控制上限和下限：左开右闭
        show(rand.ints(10, 20).boxed());
        show(rand.longs(50, 100).boxed());
        show(rand.doubles(20, 30).boxed());
        // 控制流数量的大小：
        show(rand.ints(2).boxed());
        show(rand.longs(2).boxed());
        show(rand.doubles(2).boxed());
        // 控制流的大小和界限
        show(rand.ints(3, 3, 9).boxed());
        show(rand.longs(3, 12, 22).boxed());
        show(rand.doubles(3, 11.5, 12.3).boxed());
    }



}
