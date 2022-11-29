package java8.java8.arrys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//        asList(): 获取任何序列或数组，并将其转换为一个 列表集合 （集合章节介绍了此方法）。
//
//        copyOf()：以新的长度创建现有数组的新副本。
//
//        copyOfRange()：创建现有数组的一部分的新副本。
//
//        equals()：比较两个数组是否相等。
//
//        deepEquals()：多维数组的相等性比较。
//
//        stream()：生成数组元素的流。
//
//        hashCode()：生成数组的哈希值(您将在附录中了解这意味着什么:理解equals()和hashCode())。
//
//        deepHashCode(): 多维数组的哈希值。
//
//        sort()：排序数组
//
//        parallelSort()：对数组进行并行排序，以提高速度。
//
//        binarySearch()：在已排序的数组中查找元素。
//
//        parallelPrefix()：使用提供的函数并行累积(以获得速度)。基本上，就是数组的reduce()。
//
//        spliterator()：从数组中产生一个Spliterator;这是本书没有涉及到的流的高级部分。
//
//        toString()：为数组生成一个字符串表示。你在整个章节中经常看到这种用法。
//
//        deepToString()：为多维数组生成一个字符串。你在整个章节中经常看到这种用法。对于所有基本类型和对象，所有这些方法都是重载的
public class ArrayMonth {
    public static void main(String[] args) {
        String[] arry=new String[10];
        Arrays.fill(arry,"hello");
        Arrays.fill(arry,4,10,"word");
     //   System.out.println("Arrays.toString(arry) = " + Arrays.toString(arry));

        //Arrays.setAll()
        Arrays.setAll(arry,str->new String("aaa"));
     //   System.out.println("Arrays.toString(arry) = " + Arrays.toString(arry));
        
        //toArray
        AtomicInteger i= new AtomicInteger();
        Integer[] integers =  Stream.generate(() -> i.getAndIncrement())
                .limit(10)
                .toArray(Integer[]::new);
     //   System.out.println("integers = " +Arrays.toString(integers) );

        int[] ints = IntStream.iterate(0, (int a) -> a + 2).limit(10).toArray();
        Arrays.binarySearch(ints,3);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
         Arrays.parallelPrefix(ints,Integer::sum);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        IntStream.iterate(0, (int a) -> a + 2).limit(10).reduce(Integer::sum);
        List list=new ArrayList<>();
        Arrays.sort(ints);

    }
}
