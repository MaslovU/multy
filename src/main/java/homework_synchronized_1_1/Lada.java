package homework_synchronized_1_1;

public class Lada implements Runnable {
    Seller seller = new Seller();
    final int MAX_AMOUNT_LADA = 10;
    final int CYCLE_FOR_MAKE_NEW_LADA = 500;

    public Lada(Seller seller) {
        this.seller = seller;
    }

    public Lada() {
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_AMOUNT_LADA; i++) {
            seller.makeLada();
            try {
                Thread.sleep(CYCLE_FOR_MAKE_NEW_LADA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Shop is closed, sorry!");
    }
}