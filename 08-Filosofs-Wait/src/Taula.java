import java.util.ArrayList;
import java.util.List;

public class Taula {
    private List<Filosof> filosofs;
    private List<Forquilla> forquilles;

    public Taula(int numFilosofs) {
        filosofs = new ArrayList<>();
        forquilles = new ArrayList<>();

        // Crear forquilles
        for (int i = 0; i < numFilosofs; i++) {
            forquilles.add(new Forquilla(i));
        }

        // Crear filòsofs i assignar forquilles
        for (int i = 0; i < numFilosofs; i++) {
            Filosof filosof = new Filosof(i);
            Forquilla esquerra = forquilles.get(i);
            Forquilla dreta = forquilles.get((i + 1) % numFilosofs);
            filosof.setForquilles(esquerra, dreta);
            filosofs.add(filosof);
        }
    }

    public void showTaula() {
        System.out.println("\nEstat de la taula:");
        for (Filosof filosof : filosofs) {
            System.out.println("Filòsof " + filosof.getId() + " té les forquilles " +
                    filosof.getForquillaEsquerra().getId() + " i " + filosof.getForquillaDreta().getId());
        }
    }

    public void cridarATaula() {
        for (Filosof filosof : filosofs) {
            filosof.start();
        }
    }

    public static void main(String[] args) {
        int numFilosofs = 5;
        Taula taula = new Taula(numFilosofs);
        taula.showTaula();
        taula.cridarATaula();
    }
}
