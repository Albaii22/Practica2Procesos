package net.salesianos;

class Cliente implements Runnable {
    private final String nombre;
    private final Huerto huerto;
    private final int cantidadVerduras;

    public Cliente(String nombre, Huerto huerto, int cantidadVerduras, int tiempo) {
        this.nombre = nombre;
        this.huerto = huerto;
        this.cantidadVerduras = cantidadVerduras;
    }

    @Override
    public void run() {
        for (int i = 0; i < cantidadVerduras; i++) {
            try {
                huerto.comerVerdura(nombre);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
