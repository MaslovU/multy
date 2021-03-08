package homework_synchronized_map;

import java.util.Random;

public class ChangeMap implements Runnable {
    private final SynchronizedMapExample synchronizedMapExample;
    private final Random random = new Random();

    public ChangeMap(SynchronizedMapExample synchronizedMapExample) {
        this.synchronizedMapExample = synchronizedMapExample;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronizedMapExample.changeHashMap();
        }
    }
}
