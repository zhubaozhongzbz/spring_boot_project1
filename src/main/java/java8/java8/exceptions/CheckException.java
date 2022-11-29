package java8.java8.exceptions;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class CheckException {
    private int id;
    public CheckException(int id) {
        this.id=id;
    }
    class MyException extends Exception{
        public MyException(String message) {
            super(message);
        }
    }


    static CheckException noCheck(CheckException ce){
        return ce;
    }
    static  CheckException  withCheck(CheckException ce)throws MyException{

        return ce;
    }

static void  stream(){
    IntStream.range(0,10).mapToObj(CheckException::new
    ).map(CheckException::noCheck
    ).map(ce-> {
        try {
            return ce.withCheck(ce);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    });
    CompletableFuture<CheckException> cf=CompletableFuture.completedFuture(new CheckException(1))
            .thenApplyAsync(CheckException::noCheck);





}

    public static void main(String[] args) {
        stream();
    }


}
