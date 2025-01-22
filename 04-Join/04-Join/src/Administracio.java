import java.util.ArrayList;
import java.util.List;

public class Administracio {
    private static final int NUM_POBLACIO_ACTIVA = 50;
    private final List<Treballador> poblacioActiva;

    public Administracio() {
        poblacioActiva = new ArrayList<>();
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            Treballador treballador = new Treballador(
                    "Ciutadà-" + i,
                    25000.0f,
                    20,
                    65
            );
            poblacioActiva.add(treballador);
        }
    }

    public void iniciarSimulacio() {
        for (Treballador treballador : poblacioActiva) {
            treballador.start();
        }
        for (Treballador treballador : poblacioActiva) {
            try {
                treballador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mostrarEstadistiques();
    }

    private void mostrarEstadistiques() {
        for (Treballador treballador : poblacioActiva) {
            System.out.printf("%s -> edat: %d / total: %.2f%n",
                    treballador.getName(),
                    treballador.getEdat(),
                    treballador.getCobrat()
            );
        }
    }

    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        administracio.iniciarSimulacio();
    }
}
