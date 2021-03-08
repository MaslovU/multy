package homework_compare_maps_2;

public class ThreadRead implements Runnable{
    private final ConcurrentHashMapExample concurrentHashMapExample;

    public ThreadRead(ConcurrentHashMapExample concurrentHashMapExample) {
        this.concurrentHashMapExample = concurrentHashMapExample;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            concurrentHashMapExample.readConcurrentHashMap();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
