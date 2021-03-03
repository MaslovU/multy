package homework_synchronized_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller {
    Lock locker;
    Condition condition;
    private static int amount = 0;

    public Seller(Lock locker, Condition condition) {
        this.locker = locker;
        this.condition = condition;
    }

    public void makeLada() {
//        locker.lock();
        try {
            int cycleForMakeNewLada = 3000;
            Thread.sleep(cycleForMakeNewLada);
            System.out.println("Lada give birth to new car!");
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
                System.out.println(Thread.currentThread().getName() + " are lucky! We have no Lada now!\n");
                condition.await();
            }
            amount--;
            System.out.println(Thread.currentThread().getName() + " buy new Lada!\n");
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}
