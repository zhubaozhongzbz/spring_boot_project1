package java8.studyStream.CreateStream;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator1 {
   Random random= new Random(47);
    char[] letters="asdfghjkmnbbbvcx".toCharArray();

    String get(){
        return ""+letters[random.nextInt(letters.length)];
    }

    public static void main(String[] args) {
        String collect = Stream.generate(new Generator1()::get).skip(2)
                .parallel()
                .peek(a->{
                    System.out.println(Thread.currentThread().getName());
                })
                .limit(9).collect(Collectors.joining());
        System.out.println(collect);
    }
}
