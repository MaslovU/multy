package homework_synchronized_1_1;

public class Customer implements Runnable {
    Seller seller;


    public Customer(Seller seller) {
        this.seller = seller;
    }

    @Override
    public void run() {
        seller.sellLada();
    }
}