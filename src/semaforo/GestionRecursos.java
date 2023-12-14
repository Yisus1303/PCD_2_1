package semaforo;

import java.util.concurrent.Semaphore;

class GestionRecursos {
    private Semaphore semaforo;
    private int recursosDisponibles;

    public GestionRecursos(int k) {
        semaforo = new Semaphore(1); // Semáforo binario
        recursosDisponibles = k; // Inicializar con la cantidad total de recursos disponibles (k)
    }

    public void reserva(int necesidad) {
        try {
            semaforo.acquire(); // Esperar hasta que el recurso esté disponible
            if (necesidad <= recursosDisponibles) {
                recursosDisponibles -= necesidad;
                System.out.println("Se reservaron " + necesidad + " unidades de recurso");
            } else {
                System.out.println("No hay suficientes recursos disponibles");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaforo.release(); // Liberar el recurso
        }
    }

    public void libera(int libera) {
        try {
            semaforo.acquire(); // Esperar hasta que el recurso esté disponible para liberarlo
            recursosDisponibles += libera;
            System.out.println("Se liberaron " + libera + " unidades de recurso");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaforo.release(); // Liberar el recurso
        }
    }
}