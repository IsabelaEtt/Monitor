package monitor;

// @author Isabela Canelas Ett - RA00303107

public class ReaderThread implements Runnable {
    private String name;
    private Counter counter;
    
    public ReaderThread(String name, Counter counter) {
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.name + ", value = " + counter.getCount());
    }
}
