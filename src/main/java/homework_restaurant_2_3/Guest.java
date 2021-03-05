package homework_restaurant_2_3;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import static jdk.nashorn.internal.objects.NativeMath.random;

public class Guest implements Runnable{
    Random random  = new Random();
    Restaurant restaurant;
    Lock locker;
    Condition condition;
    private int amount;

    public Guest(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Guest() {
    }

    @Override
    public void run() {
        amount++;
        try {
            Thread.sleep((random.nextInt(10) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " в ресторане");
        try {
            restaurant.actionGuests();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getAmount() {
        return amount;
    }

    public void selectDish() {
        try {
            System.out.println("Гость выбирает блюдо");
            Thread.sleep(1000);
            callWaiter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void callWaiter() throws InterruptedException {
        condition.signalAll();
    }

    public void gotDish() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " приступил к еде");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " уходит из ресторана");
    }
}
