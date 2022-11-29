package java8.mode;

import java.util.concurrent.*;

//适配器模式
public class Adapter<T> implements Future<T>,Runnable {
    private Callable  callable;
    private  T   result;
    public Adapter(Callable  callable) {
        this.callable=callable;
    }

    @Override
    public void run() {
        try {
            synchronized (this){
                result= (T) callable.call();
                this.notifyAll();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        if(result==null){
            synchronized (this){
                this.wait();
            }
        }
        return result;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public T  get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
