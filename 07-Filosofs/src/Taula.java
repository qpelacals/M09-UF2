import java.util.ArrayList;
import java.util.List;

public class Taula {
    private List<Filòsof> filòsofs;
    private List<Forquilla> forquilles;

    public Taula(int numFilòsofs) {
        filòsofs = new ArrayList<>();
        forquilles = new ArrayList<>();

        for (int i = 0; i < numFilòsofs; i++) {
            forquilles.add(new Forquilla(i));
        }

        for (int i = 0; i < numFilòsofs; i++) {
            Filòsof filòsof = new Filòsof("fil" + i, forquilles.get(i), forquilles.get((i + 1) % numFilòsofs));
            filòsofs.add(filòsof);
        }
    }

    public void showTaula() {
        for (Filòsof filòsof : filòsofs) {
            System.out.println("Comensal:" + filòsof.getNom() + " esq:" + filòsof.getForquillaEsquerra().getNumero() +
                    " dret:" + filòsof.getForquillaDreta().getNumero());
        }
    }

    public void cridaraTaula() {
        for (Filòsof filòsof : filòsofs) {
            new Thread(filòsof).start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridaraTaula();
    }
}