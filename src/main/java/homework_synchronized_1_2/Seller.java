package homework_synchronized_1_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller {
    Lock locker;
    Condition condition;
    private static int amount = 0;
    final int CYCLE_FOR_MAKE_NEW_LADA = 3000;

    public Seller(Lock locker, Condition condition) {
        this.locker = locker;
        this.condition = condition;
    }

    public void makeLada() {
        try {
            Thread.sleep(CYCLE_FOR_MAKE_NEW_LADA);
            System.out.println("\nLada give birth to new car!");
            amount++;
            System.out.println("Amount is: " + amount);
            if (locker.tryLock()) {
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            locker.unlock();
        }
    }

    public void sellLada() {
        locker.lock();
        try {
            while (amount == 0) {
                System.out.println(Thread.currentThread().getName() + " are lucky! We have no Lada now!");
                condition.await();
            }
            amount--;
            System.out.println(Thread.currentThread().getName() + " buy new Lada!\n");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}
