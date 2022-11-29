package java8.studyStream.CreateStream;

import java.util.stream.Stream;

public class Test_iterate {
    int x=1;
    Stream<Integer> fi(){
        return Stream.iterate(0,a->{
            int resulte=a+x;
            x=a;
            return x+resulte;
        });

    }

    public static void main(String[] args) {
        new Test_iterate().fi().limit(10).forEach(System.out::println);
    }




}
