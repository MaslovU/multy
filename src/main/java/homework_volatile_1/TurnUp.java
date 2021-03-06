package homework_volatile_1;

public class TurnUp implements Runnable{
    Box box;
    private final int ITER_VALUE = 5;
    private final int ITER_TIME = 2000;

    public TurnUp(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < ITER_VALUE; i++) {
            try {
                Thread.sleep(ITER_TIME);
            } catch (InterruptedException e) {
                System.out.println("Something is broken. Check it");
            }
            box.User();
        }
    }
}
