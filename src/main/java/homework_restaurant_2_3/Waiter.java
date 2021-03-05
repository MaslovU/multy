package homework_restaurant_2_3;

public class Waiter implements Runnable{
    Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Waiter() {
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " на работе!");
        restaurant.actionWaiters();
    }

    public void getOrder() {

    }

    public void bringDish() {

    }
}
