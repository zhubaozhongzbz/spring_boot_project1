package java8.java8.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Test {
    public static void main(String[] args) throws IOException {
        Files.copy(Paths.get("Test.java"),Paths.get("c.java"),REPLACE_EXISTING);
        try (
                Stream<String> stringStream = Files.lines(Paths.get("abc.java"))

        )
        {


        }




    }
}
