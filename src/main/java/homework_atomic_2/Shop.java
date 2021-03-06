package homework_atomic_2;

public class Shop extends Thread {
    private Report report;
    private int value;

    public Shop(Report report, int value) {
        this.report = report;
        this.value = value;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        report.addSumArray(value);
    }
}
