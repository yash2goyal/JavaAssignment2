package MultiThreading;

public class ThreadCreation {

    public static void main(String[] args) {

        new Demo().start();

        new Thread(new Demo2()).start();
    }
}


