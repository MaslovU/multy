package homework_synchronized_1;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    List<Lada> ladas = new ArrayList<>();
    private static int amount = 0;

    public synchronized void makeLada() {
        try {
            while (amount > 10) {
                wait();
            }
            int cycleForMakeNewLada = 500;
            Thread.sleep(cycleForMakeNewLada);
            System.out.println("\nLada give birth to new car!");
            ladas.add(new Lada());
            amount++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sellLada() {
        try {
            while (ladas.size() == 0) {
                System.out.println(Thread.currentThread().getName() + " are lucky! We have no Lada now!");
                int cycle = 1000;
                Thread.sleep(cycle);
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " buy new Lada!\n");
        ladas.remove(0);
        notify();
    }
}
