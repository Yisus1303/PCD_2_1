package semaforo;

public class Main {
    public static void main(String[] args) {
        // Supongamos que inicialmente hay 5 unidades de recurso disponibles
        int k = 5;
        GestionRecursos gestorRecursos = new GestionRecursos(k);

        // Procesos que reservan y liberan recursos
        new Thread(() -> gestorRecursos.reserva(2)).start(); // Proceso reserva 2 unidades
        new Thread(() -> gestorRecursos.reserva(3)).start(); // Proceso reserva 3 unidades
        new Thread(() -> gestorRecursos.libera(4)).start();  // Proceso libera 4 unidades
    }
}
