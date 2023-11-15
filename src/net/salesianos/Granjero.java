package net.salesianos;

import java.util.Random;

class Granjero implements Runnable {
    private final String nombre;
    private final Huerto huerto;
    private final int cantidadVerduras;

    public Granjero(String nombre, Huerto huerto, int cantidadVerduras) {
        this.nombre = nombre;
        this.huerto = huerto;
        this.cantidadVerduras = cantidadVerduras;
    }

    @Override
    public void run() {
        for (int i = 0; i < cantidadVerduras; i++) {
            try {
                String verdura = getRandomVegetable();
                huerto.plantarVerdura(nombre, verdura);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getRandomVegetable() {
        String[] verduras = {"lechuga", "papa", "apio", "espárragos", "rábano",
                "brócoli", "alcachofa", "tomate", "pepino", "berenjena", "zanahoria"};

        return verduras[new Random().nextInt(verduras.length)];
    }
}

