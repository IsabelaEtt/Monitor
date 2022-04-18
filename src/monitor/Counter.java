package monitor;

// @author Isabela Canelas Ett - RA00303107

public class Counter {
    private int count = 0;
    private boolean available = true;
    
    public synchronized void increment (int increment) {
        while (this.available == false) {
            try { wait();
            } catch (InterruptedException e) {}
        }
        
        this.available = false;
        
        this.count += increment;
        
        this.available = true;
        notify();
    }
    
    public synchronized int getCount () {
        while (this.count == 0) {
            try { wait();
            } catch (InterruptedException e) {}
        }
        
        int value = this.count;
        this.count = 0;
        notify();
          
        return value;
    }
}
