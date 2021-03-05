package homework_synchronized_1_2;

public class Lada implements Runnable {
    Seller seller;
    private final int MAX_AMOUNT_LADA = 10;

    public Lada(Seller seller) {
        this.seller = seller;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_AMOUNT_LADA; i++) {
            seller.makeLada();
        }
    }
}
