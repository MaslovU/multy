package homework_synchronized_1_1;

public class Lada implements Runnable {
    Seller seller = new Seller();
    final int MAX_AMOUNT_LADA = 10;
    final int cycleForMakeNewLada = 1000;

    public Lada(Seller seller) {
        this.seller = seller;
    }

    public Lada() {
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_AMOUNT_LADA; i++) {
            try {
                Thread.sleep(cycleForMakeNewLada);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seller.makeLada();
        }
    }
}