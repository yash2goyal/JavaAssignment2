package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private long AccountNo;
    private long amount;
    private Object lock;

    public Account(long AccountNo, long amount)
    {
        this.AccountNo = AccountNo;
        this.amount  = amount;
        lock  = new Object();
    }

    public long getAccountNo() {
        return AccountNo;
    }

    public long getAmount() {
        return amount;
    }

    public Object getLock() {
        return lock;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
