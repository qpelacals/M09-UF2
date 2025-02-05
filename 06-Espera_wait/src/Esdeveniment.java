import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Esdeveniment {
    private final List<Assistent> assistents;
    private final int capacitatMaxima;
    private int placesDisponibles;

    public Esdeveniment(int capacitatMaxima) {
        this.capacitatMaxima = capacitatMaxima;
        this.placesDisponibles = capacitatMaxima;
        this.assistents = new ArrayList<>();
    }

    public synchronized void ferReserva(Assistent assistent) {
        while (placesDisponibles == 0) {
            try {
                //System.out.println(assistent.getNom() + " espera per una plaça.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (!assistents.contains(assistent)) {
            assistents.add(assistent);
            placesDisponibles--;
            System.out.println(assistent.getNom() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
        }
    }

    public synchronized void cancelaReserva(Assistent assistent) {
        if (assistents.remove(assistent)) {
            placesDisponibles++;
            System.out.println(assistent.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
            notifyAll();
        } else {
            System.out.println(assistent.getNom() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + placesDisponibles);
        }
    }
}