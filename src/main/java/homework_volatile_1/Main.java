package homework_volatile_1;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        TurnUp turnUp = new TurnUp(box);
        TurnDown turnDown = new TurnDown(box);

        Thread customer = new Thread(null, turnUp, "customer");
        customer.start();

        Thread boxThread = new Thread(null, turnDown, "boxThread");
        boxThread.setDaemon(true);
        boxThread.start();
    }
}
