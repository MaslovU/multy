package homework_volatile_1;

public class Box {
    private volatile boolean condition = false;

    public void User() {
        if (!condition) {
            System.out.println("Starting work for the box");
            condition = true;
        }
    }

    public void BoxUser() {
        while (condition) {
            System.out.println("Finishing work for the box");
            condition = false;
        }

    }
}
