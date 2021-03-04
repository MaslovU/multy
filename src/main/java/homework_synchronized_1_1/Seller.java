package homework_synchronized_1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Seller {
    List<Lada> ladas = new ArrayList<>();
    Random random = new Random();

    public synchronized void makeLada() {
        try {
            System.out.println("\nLada give birth to new car!");
            ladas.add(new Lada());
            Thread.sleep(random.nextInt(5) * 700);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sellLada() throws InterruptedException {
        Thread.sleep(1000);
        try {
            while (ladas.size() == 0) {
                System.out.println(Thread.currentThread().getName() + " are lucky! We have no Lada now!");
                wait(1500);
            }
            System.out.println(Thread.currentThread().getName() + " buy new Lada!\n");
//            Thread.sleep(2500);
            ladas.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}