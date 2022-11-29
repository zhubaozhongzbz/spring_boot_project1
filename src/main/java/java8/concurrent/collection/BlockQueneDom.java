package java8.concurrent.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueneDom {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        addAndRemove(queue);//超出数量抛异常
        offerAndPOLL(queue);//queue.poll() = null  queue.offer("bb") = false
        putAndTake(queue);//阻塞
        queue.element();//抛异常
        queue.peek();//返回null
    }

    static  void  addAndRemove( BlockingQueue<String> queue){
        //超过三个exception  返回true
        System.out.println("queue.add(aa) = " + queue.add("aa"));
        queue.add("cc");
        queue.add("vv");//返回true
    //    queue.add("bb");//超过三个exception
        System.out.println("queue.remove() = " + queue.remove());//返回移除的值
        queue.remove();
        queue.remove();
    }
    static  void  offerAndPOLL( BlockingQueue<String> queue){
        //有返回值  无异常queue.poll() = null  queue.offer("bb") = false
        System.out.println("queue.offer(aa) = " + queue.offer("aa"));
        queue.offer("cc");
        queue.offer("vv");//返回true
        System.out.println("queue.offer(\"bb\") = " + queue.offer("bb"));//超过三个exception
        //queue.offer("bb") = false
        System.out.println("queue.poll() = " + queue.poll());//返回移除的值
        queue.poll();
        queue.poll();
        //queue.poll() = null
        System.out.println("queue.poll() = " + queue.poll());
    }

    static  void  putAndTake( BlockingQueue<String> queue) throws InterruptedException {
        //阻塞
        queue.put("aa");
        queue.put("cc");
        queue.put("vv");//返回true
        queue.put("bb");//超过三个exception
        //queue.offer("bb") = false
        System.out.println("queue.take() = " + queue.take());//返回移除的值
        queue.take();
        queue.take();
        System.out.println("queue.take() = " + queue.take());
    }
}
