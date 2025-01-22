import java.util.Random;

public class Treballador extends Thread {
    private final float nouAnualBrut;
    private final int edatIniciTreball;
    private final int edatFiTreball;
    private int edatActual;
    private float cobrat;
    private final Random rnd;

    public Treballador(String nom, float nouAnualBrut, int edatIniciTreball, int edatFiTreball) {
        super(nom);
        this.nouAnualBrut = nouAnualBrut;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.edatActual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    public void cobra() {
        cobrat += (nouAnualBrut / 12.0f); // Salario mensual
    }

    public void pagaImpostos() {
        float imp = (nouAnualBrut / 12.0f) * 0.24f;
        cobrat -= imp; // 24% de impuestos
    }

    @Override
    public void run() {
        for (int edat = edatIniciTreball; edat <= edatFiTreball; edat++) {
            edatActual = edat;
            for (int i = 0; i < 12; i++) {
                try {
                    cobra();
                    sleep(10);
                    pagaImpostos();
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edatActual;
    }
}
