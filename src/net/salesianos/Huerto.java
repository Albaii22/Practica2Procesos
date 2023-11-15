package net.salesianos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Huerto {
    private final int capacidadAlmacen;
    private final List<String> almacen;

    public Huerto(int capacidadAlmacen) {
        this.capacidadAlmacen = capacidadAlmacen;
        this.almacen = new ArrayList<>();
    }

    public synchronized void plantarVerdura(String granjero, String verdura) throws InterruptedException {
        while (almacen.size() >= capacidadAlmacen) {
            wait();
        }

        Thread.sleep(new Random().nextInt(1000));

        almacen.add(granjero + ": " + verdura);
        System.out.println(granjero + " ha plantado " + verdura);

        notifyAll();
    }

    public synchronized String comerVerdura(String cliente) throws InterruptedException {
        while (almacen.isEmpty()) {
            wait();
        }

        String verdura = almacen.remove(0);
        System.out.println(cliente + " ha consumido " + verdura);

        notifyAll();

        return verdura;
    }
}
