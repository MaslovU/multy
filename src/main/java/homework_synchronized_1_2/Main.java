package homework_synchronized_1_2;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lokker = new ReentrantLock();
        Seller seller = new Seller(lokker, lokker.newCondition());
        Customer customer = new Customer(seller);
        Lada lada = new Lada(seller);

        new Thread(null, customer, "Petr").start();
        new Thread(null, customer, "Ivan").start();
        new Thread(null, customer, "Vova").start();
        new Thread(null, seller::sellLada, "Ron").start();
        new Thread(null, seller::sellLada, "Elena").start();
        new Thread(null, seller::sellLada, "Maska").start();
        new Thread(null, seller::sellLada, "Wolmart").start();
        new Thread(null, seller::sellLada, "Lola").start();
        new Thread(null, seller::sellLada, "Punsh").start();
        new Thread(null, seller::sellLada, "Alla").start();

        new Thread(null, lada, "Lada").start();

    }
}
