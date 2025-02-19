import java.util.ArrayList;
import java.util.List;

public class Taula {
    private List<Filosof> comensals;
    private List<Forquilla> forquilles;

    public Taula(int comensals) {
        this.comensals = new ArrayList<>();
        this.forquilles = new ArrayList<>();

        // Creem les forquilles primer
        for (int i = 0; i < comensals; i++) {
            this.forquilles.add(new Forquilla(i));
        }

        // Ara afegim els filòsofs
        for (int i = 0; i < comensals; i++) {
            Filosof f = new Filosof("Filosof " + i);
            f.forquillaEsquerra = this.forquilles.get(i);
            f.forquillaDreta = this.forquilles.get((i + 1) % comensals);
            this.comensals.add(f);
        }
    }

    public void showTaula() {
        for (int i = 0; i < comensals.size(); i++) {
            System.out.println(comensals.get(i).getName() + " - esq: " + comensals.get(i).forquillaEsquerra.getId()
                    + " dret: " + comensals.get(i).forquillaDreta.getId());
        }
    }

    public void cridarATaula() {
        for (int i = 0; i < comensals.size(); i++) {
            comensals.get(i).start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}