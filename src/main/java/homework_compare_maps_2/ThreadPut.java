package homework_compare_maps_2;

import java.util.Random;

public class ThreadPut implements Runnable {
    private final ConcurrentHashMapExample concurrentHashMapExample;
    private final Random random = new Random();

    public ThreadPut(ConcurrentHashMapExample concurrentHashMapExample) {
        this.concurrentHashMapExample = concurrentHashMapExample;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int newKey = ConcurrentHashMapExample.sizeMyArray++;
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                concurrentHashMapExample.changeConcurrentHashMap(newKey);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
