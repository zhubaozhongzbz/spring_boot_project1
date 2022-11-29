package java8.concurrent.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDom01 {
    public static void main(String[] args) {
        Test test=new Test();
        Lock lock=new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                test.sayc1();
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                test.sayc2();
            }).start();
        }


    }
}

class  Test{
    AtomicInteger  aint=new AtomicInteger();
    int i=0;
   private Lock lock=new ReentrantLock();
   Integer flag=1;
   Condition c1=lock.newCondition();
   Condition c2=lock.newCondition();

   void   sayc1(){
       lock.lock();
       try {
       while(flag!=1)
           c1.await();
           i++;
           System.out.println("sayc1: " + i);
           flag=2;
           c2.signal();
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       } finally {
           lock.unlock();
       }
   }

    void   sayc2(){
        lock.lock();
        try {
            while(flag!=2)
                c2.await();
            i--;
            System.out.println("sayc2: "+i);
            flag=1;
            c1.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }


}


