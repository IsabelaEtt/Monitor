package monitor;

// @author Isabela Canelas Ett - RA00303107

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Monitor {
    public static void main(String[] args) {
        int poolSize = 120;
        Counter counter = new Counter();
        
        ScheduledExecutorService ste = Executors.newScheduledThreadPool(poolSize);

        for (int i=1; i <= poolSize; i++) {
            ste.schedule(new WorkerThread("Worker Thread " + i, i, counter), 1, TimeUnit.MILLISECONDS);
            ste.schedule(new ReaderThread("Reader Thread " + i, counter), 1, TimeUnit.MILLISECONDS);
        }

        ste.shutdown();
    }
}
