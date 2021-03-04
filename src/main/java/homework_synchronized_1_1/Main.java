package homework_synchronized_1_1;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Seller seller = new Seller();
        Customer customer = new Customer(seller);
        Lada lada = new Lada(seller);

        Thread petr = new Thread(null, customer, "Petr");
        petr.setDaemon(true);
        petr.start();
        Thread ivan = new Thread(null, customer, "Ivan");
        ivan.setDaemon(true);
        ivan.start();
        Thread vova = new Thread(null, customer, "Vova");
        vova.setDaemon(true);
        vova.start();
        Thread ron = new Thread(null, customer, "Ron");
        ron.setDaemon(true);
        ron.start();
        Thread elena = new Thread(null, customer, "Elena");
        elena.setDaemon(true);
        elena.start();
        Thread maska = new Thread(null, customer, "Maska");
        maska.setDaemon(true);
        maska.start();
        Thread wolmart = new Thread(null, customer, "Wolmart");
        wolmart.setDaemon(true);
        wolmart.start();
        Thread lola = new Thread(null, customer, "Lola");
        lola.setDaemon(true);
        lola.start();
        Thread punsh = new Thread(null, customer, "Punsh");
        punsh.setDaemon(true);
        punsh.start();
        Thread alla = new Thread(null, customer, "Alla");
        alla.setDaemon(true);
        alla.start();

        Thread sellerLada = new Thread(null, lada, "Lada");
        sellerLada.start();
    }
}