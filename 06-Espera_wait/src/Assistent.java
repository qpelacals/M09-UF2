import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Assistent extends Thread {
    private final String nom;
    private final Esdeveniment esdeveniment;
    private final Random random = new Random();

    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(1001)); // Espera entre 0 i 1 segon
                if (random.nextBoolean()) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}