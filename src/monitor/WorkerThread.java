package monitor;

// @author Isabela Canelas Ett - RA00303107

public class WorkerThread implements Runnable{
    private String name;
    private int value;
    private Counter counter;
    
    public WorkerThread(String name, int value, Counter counter) {
        this.name = name;
        this.value = value;
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.increment(this.value);
    }
}
