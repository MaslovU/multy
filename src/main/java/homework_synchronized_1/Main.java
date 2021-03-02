package homework_synchronized_1;

public class Main {
    public static void main(String[] args) {
        Seller seller = new Seller();
        Customer customer = new Customer(seller);
        Lada lada = new Lada(seller);

        new Thread(null, customer, "Petr").start();
        new Thread(null, customer, "Ivan").start();
        new Thread(null, customer, "Vova").start();
        new Thread(null, customer, "Ron").start();
        new Thread(null, customer, "Elena").start();
        new Thread(null, customer, "Maska").start();
        new Thread(null, customer, "Wolmart").start();
        new Thread(null, customer, "Lola").start();
        new Thread(null, customer, "Punsh").start();
        new Thread(null, customer, "Alla").start();

        Thread sellerLada = new Thread(null, lada, "Lada");
        sellerLada.start();
    }
}
