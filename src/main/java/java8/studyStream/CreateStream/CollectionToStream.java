package java8.studyStream.CreateStream;

import java.util.*;
//集合流
public class CollectionToStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,1,44,5,66,22,3);
        //mapToInt() 方法将一个对象流（object stream）转换成为包含整型数字的 IntStream。同样，针对 Float 和 Double 也有类似名字的操作
        list.stream().mapToInt(a->a.intValue()).sum();
        //中间操作 map() 会获取流中的所有元素，并且对流中元素应用操作从而产生新的元素，并将其传递到后续的流中。
        // 通常 map() 会获取对象并产生新的对象，
        Set<String> w = new HashSet<>(Arrays.asList("It's a wonderful day for pie!".split(" ")));
        w.stream().map(x -> x + " ").forEach(System.out::print);

        //首先调用 entrySet() 产生一个对象流，每个对象都包含一个 key 键以及与其相关联的 value 值。
        // 然后分别调用 getKey() 和 getValue() 获取值。
        Map<String, Double> m = new HashMap<>();
        m.put("pi", 3.14159);
        m.put("e", 2.718);
        m.put("phi", 1.618);
        m.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);
    }
}
