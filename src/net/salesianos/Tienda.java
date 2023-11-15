package net.salesianos;

public class Tienda {
    public static void main(String[] args) {
        Huerto huerto = new Huerto(5);

        Thread granjero = new Thread(new Granjero("Paco", huerto, 5));
        Thread cliente = new Thread(new Cliente("Jose", huerto, 5));

        granjero.start();
        cliente.start();
    }
}
