package net.salesianos;

public class Tienda {
    public static void main(String[] args) {
        Huerto huerto = new Huerto(5);

        Thread granjeroPaco = new Thread(new Granjero("Paco", huerto, 10));
        Thread granjeroRamon = new Thread(new Granjero("Ramón", huerto, 10));

        Thread clienteFaustino = new Thread(new Cliente("Faustino", huerto, 5));
        Thread clienteGentleman = new Thread(new Cliente("Mr.Gentleman", huerto, 10));
        Thread clienteLoquendo = new Thread(new Cliente("Loquendo", huerto, 5));

        granjeroPaco.start();
        granjeroRamon.start();
        clienteFaustino.start();
        clienteGentleman.start();
        clienteLoquendo.start();
    }
}
