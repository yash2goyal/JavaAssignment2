package MultiThreading;

import java.util.concurrent.locks.*;
public class DeadLockSolution {

    public static void main(String[] args) {
        DeadLockSolution d = new DeadLockSolution();
        AccountClassReentrantLock a1 = new AccountClassReentrantLock(123456, 10000);
        AccountClassReentrantLock a2 = new AccountClassReentrantLock(2785921, 10000);

        Thread t1 = new Thread(() -> {
            for(int i=0;i<500;i++)
            {
                d.transfer(a1, a2, 100);
            }

        });
        Thread t2 = new Thread(() -> {
            for(int i=0;i<500;i++)
            {
                d.transfer(a1, a2, 100);
            }

        });
    }
    void transfer(AccountClassReentrantLock a1, AccountClassReentrantLock a2, int amount)
    {
        synchronized (a1.getLock())
        {
            synchronized (a2.getLock())
            {
                System.out.println("transfered "+a1.getAmount()+" from "+a1.getAccountNo()+" to "+a2.getAccountNo());
                a1.setAmount(a1.getAmount() - amount);
                a2.setAmount(a2.getAmount() + amount);
            }
        }
    }
    private void lock(Account a1, Account a2)
    {
        //Boolean fromAccountLocked = a1.getLock().tryLock();
    }
}
