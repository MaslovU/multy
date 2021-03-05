package homework_restaurant_2_3;

public class Kitchener implements Runnable{
    Restaurant restaurant;

    public Kitchener(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Kitchener() {
    }

    @Override
    public void run() {
        System.out.println("Повар на работе!");
        restaurant.actionKitchener();
    }
}
