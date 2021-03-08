package homework_synchronized_map;

public class ReadMap implements Runnable {
    private final SynchronizedMapExample synchronizedMapExample;

    public ReadMap(SynchronizedMapExample synchronizedMapExample) {
        this.synchronizedMapExample = synchronizedMapExample;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            synchronizedMapExample.readHashMap();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
