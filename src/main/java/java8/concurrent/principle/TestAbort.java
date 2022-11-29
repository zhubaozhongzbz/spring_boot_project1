package java8.concurrent.principle;


import java8.concurrent.executorservice.Nap;

//如果你注释掉 Nap 创建实列那行，程序执行会立即退出，表明 TimedAbort 没有维持程序打开。
public class TestAbort {
    public static void main(String[] args) {
        new TimedAbort(1);
        System.out.println("Napping for 4");
        new Nap(4);
    }

}
