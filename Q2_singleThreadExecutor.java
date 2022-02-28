package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q2_singleThreadExecutor {

    public static void main(String[] args) throws InterruptedException{

        ExecutorService ex = Executors.newSingleThreadExecutor();

        Runnable runnable = () -> {
            for(int i=0;i<50;i++)
             System.out.println(":: " + Thread.currentThread().getName());

        };
        ex.submit(runnable);
        ex.shutdown();

    }
}
