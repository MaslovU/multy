package homework_synchronized_1_1;

public class Lada implements Runnable {
    Seller seller = new Seller();

    public Lada(Seller seller) {
        this.seller = seller;
    }

    public Lada() {
    }

    @Override
    public void run() {
        int MAX_AMOUNT_LADA = 10;
        for (int i = 0; i < MAX_AMOUNT_LADA; i++) {
            try {
                int cycleForMakeNewLada = 1000;
                Thread.sleep(cycleForMakeNewLada);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seller.makeLada();
        }
    }
}