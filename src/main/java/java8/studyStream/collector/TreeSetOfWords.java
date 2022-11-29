package java8.studyStream.collector;
//collect(Collector)：使用 Collector 收集流元素到结果集合中。
//collect(Supplier, BiConsumer, BiConsumer)：同上，
// 第一个参数 Supplier 创建了一个新的结果集合，
// 第二个参数 BiConsumer 将下一个元素收集到结果集合中，
// 第三个参数 BiConsumer 用于将两个结果集合合并起来。
//可通过查看 java.util.stream.Collectors 的 API 文档了解

//假设我们现在为了保证元素有序，将元素存储在 TreeSet 中。
// Collectors 里面没有特定的 toTreeSet()，但是我们可以通过将集合的构造函数引用传递给
// Collectors.toCollection()，从而构建任何类型的集合。
// 下面我们来将一个文件中的单词收集到 TreeSet 集合中

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeSetOfWords {
    public static void main(String[] args) throws IOException {
       //生成数组；
        Stream<String> lines = Files.lines(Paths.get("abc.java"))
        .peek(System.out::println)
        .flatMap(s -> Arrays.stream(s.split("[\\W]+"))).distinct()
        .peek(System.out::println)
        .map(String::trim)
                .filter(s -> s.matches("\\w+"))
 //       .filter(s ->! s.matches(""))
        .limit(20);
//        lines.forEach(s->{
//            if (s == null||s=="") {
//                System.out.println("s.equals() = " + s.equals(""));
//            }
//        });
        //转换成数组
//       Object[] collect = lines.toArray();
//        for (int i = 0; i < collect.length; i++) {
//            System.out.println("collect[i] = " + collect[i]);
//        }
        //传入构造器
//       TreeSet<String> collect = lines.collect(Collectors.toCollection(TreeSet::new));
 //       lines.collect(Collectors.joining());
//        System.out.println("treeset = " + collect);

//       List<String> collect1 = lines.collect(Collectors.toList());
//
//       // lines.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        System.out.println("collect1.toString() = " + collect1.toString());
//        System.out.println("".matches("\\W+"));
     //  Map<String, Integer> collect = lines.collect(Collectors.toMap(s -> s, s -> s.length()));
    //   System.out.println("collect = " + collect.toString());


       // Long collect = lines.collect(Collectors.counting());
        Map<Integer, List<String>> collect =
                lines.collect(Collectors.groupingBy(s -> {
                    if(s.length() <= 2){return 3;}
                    else return 5;




                }));
        System.out.println("collect = " + collect);
    }



}
