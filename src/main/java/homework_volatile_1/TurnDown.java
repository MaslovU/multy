package homework_volatile_1;

public class TurnDown implements Runnable{
    Box box;

    public TurnDown(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            box.BoxUser();
        }
    }
}
