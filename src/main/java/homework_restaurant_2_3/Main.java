package homework_restaurant_2_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock locker = new ReentrantLock();
        Restaurant restaurant = new Restaurant(locker, locker.newCondition());
        Waiter waiter = new Waiter(restaurant);
        Guest guest = new Guest(restaurant);
        Kitchener kitchener = new Kitchener(restaurant);

//        new Thread(null, kitchener, "Cook").start();
//
//        Thread tanya = new Thread(null, waiter, "Tanya");
//        tanya.setPriority(10);
//        tanya.start();
//        Thread nastya = new Thread(null, waiter, "Nastya");
//        nastya.setPriority(10);
//        nastya.start();
        Thread yulya = new Thread(null, waiter, "Yulya");
        yulya.setPriority(10);
        yulya.start();

        new Thread(null, guest, "Doctor").start();
        new Thread(null, guest, "Lawyer").start();
        new Thread(null, guest, "Programmer").start();
        new Thread(null, guest, "Senator").start();
        new Thread(null, guest, "Teacher").start();
    }
}
