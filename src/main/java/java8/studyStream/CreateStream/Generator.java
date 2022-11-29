package java8.studyStream.CreateStream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator implements Supplier<String> {
   Random r= new Random(47);
   String letter="abcdefghidklmnopqrstuvwxyz";
   char [] letters=letter.toCharArray();
    int i=0;
    @Override
    public String get() {


        return  ""+letters[i++];
        // return ""+letters[r.nextInt(letters.length)];
    }

    public static void main(String[] args) {
      String word=  Stream.generate(new Generator()).limit(10).collect(Collectors.joining());
        System.out.println(word);
    }
}
