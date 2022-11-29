package java8.studyStream.CreateStream;

import java.util.Arrays;
import java.util.stream.Stream;
/*
对数组创建流
forEachOrdered()和forEach()方法的区别在于forEachOrdered()将始终按照流(stream)中元素的遇到顺序执行给定的操作，而forEach()方法是不确定的。
在并行流(parallel stream)中，forEach()方法可能不一定遵循顺序，而forEachOrdered()将始终遵循顺序。
在序列流(sequential stream)中，两种方法都遵循顺序。
如果我们希望在每种情况下，不管流(stream)是连续的还是并行的，都要按照遵循顺序执行操作，那么我们应该使用forEachOrdered()方法。
如果流(stream)是连续的，我们可以使用任何方法来维护顺序。
但是如果流(stream)也可以并行，那么我们应该使用forEachOrdered()方法来维护顺序。
 */
//数组流
public class StreamOf {
    public static void main(String[] args) {
        String [] str=new String[]{"11","222","cc","aa"};
        Stream.of(str).forEachOrdered(System.out::println);
        Stream.of(3.14159, 2.718, 1.618).forEach(System.out::println);
        Stream.of("It's ", "a ", "wonderful ", "day ", "for ", "pie!").forEach(System.out::print);


        //Stream.of   源码就是调用下面的
        Arrays.stream(str).forEach(System.out::println);
    }

}
