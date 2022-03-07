package MultiThreading;

import org.jetbrains.annotations.NotNull;

public class DeadLockProblem {

    public static void main(String[] args) throws InterruptedException {

        DeadLockProblem d = new DeadLockProblem();

        Account a1 = new Account(123456, 10000);
        Account a2 = new Account(2785921, 10000);

        Thread t1 = new Thread(() -> {
           for(int i=0;i<500;i++)
           {
               d.transfer(a1, a2, 100);
           }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0;i<500;i++)
            {
                d.transfer(a2, a1, 100);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }

    void transfer(@NotNull Account a1, Account a2, int amount)
    {
        synchronized (a1.getLock())
        {
            synchronized (a2.getLock())
            {
                System.out.println("transfered "+amount+" from "+a1.getAccountNo()+" to "+a2.getAccountNo());
                a1.setAmount(a1.getAmount() - amount);
                a2.setAmount(a2.getAmount() + amount);
            }
        }
    }
}
