package MultiThreading;

public class SynchronizedMethod {

    private int a = 10;
    synchronized void increment()
    {
        this.a++;
    }
    synchronized void decrement()
    {
        this.a--;
    }
    public static void main(String[] args) throws InterruptedException{

        SynchronizedMethod s = new SynchronizedMethod();

        Thread t1 = new Thread(() -> {
            for(int i=0;i<20000;i++)
                s.increment();
        });
        Thread t2 = new Thread(() -> {
            for(int i=0;i<20000;i++)
                s.decrement();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Thread.sleep(10000);
        System.out.println(s.a);
    }
}
