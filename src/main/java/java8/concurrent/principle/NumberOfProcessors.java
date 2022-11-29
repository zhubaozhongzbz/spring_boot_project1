package java8.concurrent.principle;

public class NumberOfProcessors {
    public static void main(String[] args) {

        int i = new Integer (1);
        System.out.println(
                Runtime.getRuntime().availableProcessors());
    }
}
