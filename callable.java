package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class callable {

    public static void main(String[] args) throws InterruptedException{

        ExecutorService ex = Executors.newFixedThreadPool(1);
        ex.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Calling Method with callable anonymous class call");
                Thread.sleep(1000);
                return 5;
            }
        });

        ex.submit(() -> {
            System.out.println("Calling Method with lambda call");
            Thread.sleep(1000);
            return 5;
        });
    }
}
