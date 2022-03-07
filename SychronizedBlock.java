package MultiThreading;

import kotlin.jvm.Synchronized;



public class SychronizedBlock {

    private int a = 10;
    void increment()
    {
        this.a++;
    }

    void decrement()
    {
        this.a--;
    }

    public static void main(String[] args) throws InterruptedException {
        SychronizedBlock s = new SychronizedBlock();
        Object lock = new Object();

        Thread t1 = new Thread(() ->{
           for(int i=0;i<20000;i++)
           {
               synchronized (lock)
               {
                    s.increment();
               }
           }

        });
        Thread t2 = new Thread(() ->{
            for(int i=0;i<20000;i++)
            {
                synchronized (lock)
                {
                    s.decrement();
                }
            }

        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Thread.sleep(1000);
        System.out.println(s.a);
    }
}
