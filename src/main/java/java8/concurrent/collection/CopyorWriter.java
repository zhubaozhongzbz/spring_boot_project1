package java8.concurrent.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyorWriter {
    public static void main(String[] args) {
        //同步集合
       // List<String> list=new ArrayList<>();//ConcurrentModificationException
       // List<String> list= Collections.synchronizedList(new ArrayList<>());
        new HashSet<>(); //底层是map
        new HashMap<>();//初始值16   负载因子是0.75
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();

        }
        System.out.println(list);
        
        
        
        
        

    }
}
