package homework_synchronized_1;

public class Lada implements Runnable {
    Seller seller;

    public Lada(Seller seller) {
        this.seller = seller;
    }

    @Override
    public void run() {
        int MAX_AMOUNT_LADA = 10;
        for (int i = 0; i < MAX_AMOUNT_LADA; i++) {
            seller.makeLada();
        }
    }
}
