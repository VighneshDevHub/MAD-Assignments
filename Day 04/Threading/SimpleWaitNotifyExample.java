package Day04;
class SharedResource {
    public synchronized void doWait() {
        try {
            System.out.println("Thread is waiting...");
            wait(); // Wait for a signal
            System.out.println("Thread is resumed!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public synchronized void doNotify() {
        System.out.println("Thread is notifying...");
        notify();
    }
}

public class SimpleWaitNotifyExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            sharedResource.doWait();
        });

        Thread thread2 = new Thread(() -> {
            sharedResource.doNotify();
        });

        thread1.start();
        thread2.start();
    }
}
