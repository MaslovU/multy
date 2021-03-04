package homework_synchronized_1_1;

public class Customer extends Thread {
    Seller seller;
    final int MAX_WANT_LADA = 15;

    public Customer(Seller seller) {
        this.seller = seller;
    }

    @Override
    public void run() {
            for (int i = 0; i < MAX_WANT_LADA; i++) {
                try {
                    seller.sellLada();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}