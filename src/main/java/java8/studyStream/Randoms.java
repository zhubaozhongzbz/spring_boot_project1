package java8.studyStream;

import java.util.Random;

public class Randoms {
    public static void main(String[] args) {
        new Random(47).ints(5,30).distinct().limit(4).forEach(System.out::println);



    }



}
