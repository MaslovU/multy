package homework_restaurant_2_3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Restaurant {
    Lock locker;
    Condition condition;

    Guest guest = new Guest();
    Waiter waiter = new Waiter();
    Kitchener kitchener = new Kitchener();

    public Restaurant(Lock locker, Condition condition) {
        this.locker = locker;
        this.condition = condition;
    }

    public void actionWaiters() {
        locker.lock();
    }

    public void actionGuests() throws InterruptedException {
        locker.lock();
        try {
            guest.selectDish();
            guest.callWaiter();
            guest.gotDish();
        } finally {
            locker.unlock();
        }

    }

    public void actionKitchener() {

    }
}
