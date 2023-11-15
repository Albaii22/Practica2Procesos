package net.salesianos;

public class Tienda {
    public static void main(String[] args) {
        Huerto huerto = new Huerto(5);

        Thread granjeroPaco = new Thread(new Granjero("Paco", huerto, 5));
        granjeroPaco.setPriority(Thread.MAX_PRIORITY);

        Thread granjeroJose = new Thread(new Granjero("Jose", huerto, 5));
        granjeroJose.setPriority(Thread.MAX_PRIORITY);

        Thread cliente = new Thread(new Cliente("Adhernea", huerto, 5));

        granjeroPaco.start();
        granjeroJose.start();
        cliente.start();
    }
}
