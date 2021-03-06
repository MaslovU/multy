package homework_atomic_2;

import java.util.Random;

public class Main {
    private static final int NUMBER_OF_RESTAURSNTS = 3;

    public static void main(String[] args) throws InterruptedException {
        Report report = new Report();
        Random random = new Random();

        int value;
        long res;

        for (int i = 0; i < NUMBER_OF_RESTAURSNTS; i++) {
            value = random.nextInt(100);
            new Shop(report, value).start();
        }

        Thread.sleep(2000);
        res = report.getAllRes();
        System.out.println(res);
    }
}
