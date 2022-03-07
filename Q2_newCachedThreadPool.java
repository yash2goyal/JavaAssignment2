package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class Q2_newCachedThreadPool {

    public static void main(String[] args) throws InterruptedException{

        // List<LinkedBlockingQueue<Long>> linkedBlockingQueueList = splitListtoBlockingQueues();
        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;

        System.out.println("Largest executions: "
                + pool.getLargestPoolSize());
        System.out.println("Maximum allowed threads: "
                + pool.getMaximumPoolSize());
        System.out.println("Current threads in pool: "
                + pool.getPoolSize());
        System.out.println("Currently executing threads: "
                + pool.getActiveCount());
        System.out.println("Total number of threads(ever scheduled): "
                + pool.getTaskCount());

        for(int i=0;i<50;i++)
        {
            executor.submit(new Thread());
        }

        System.out.println("Core threads: " + pool.getCorePoolSize());
        System.out.println("Largest executions: "
                + pool.getLargestPoolSize());
        System.out.println("Maximum allowed threads: "
                + pool.getMaximumPoolSize());
        System.out.println("Current threads in pool: "
                + pool.getPoolSize());
        System.out.println("Currently executing threads: "
                + pool.getActiveCount());
        System.out.println("Total number of threads(ever scheduled): "
                + pool.getTaskCount());
        executor.shutdown();
    }
}
