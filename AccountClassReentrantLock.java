package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class AccountClassReentrantLock {

    private long AccountNo;
    private long amount;
    private ReentrantLock lock;

    public AccountClassReentrantLock(long AccountNo, long amount)
    {
        this.AccountNo = AccountNo;
        this.amount  = amount;
        lock  = new ReentrantLock();
    }

    public long getAccountNo() {
        return AccountNo;
    }

    public long getAmount() {
        return amount;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
