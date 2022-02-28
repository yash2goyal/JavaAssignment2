package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q2_newFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 50 ; i++)
        {
            executorService.submit(() -> {
                System.out.println("Doing through executor");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }


}
