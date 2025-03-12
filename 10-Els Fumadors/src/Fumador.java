import java.util.Random;

class Fumador extends Thread {
    private final Estanc estanc;
    private final int id;
    private int fumades = 0;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
    }

    public void run() {
        try {
            while (fumades < 3) {
                System.out.println("Fumador " + id + " comprant Tabac");
                Tabac tabac = estanc.venTabac();

                System.out.println("Fumador " + id + " comprant Paper");
                Paper paper = estanc.venPaper();

                System.out.println("Fumador " + id + " comprant Llumí");
                Llumi llumi = estanc.venLlumi();

                fuma();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void fuma() throws InterruptedException {
        System.out.println("Fumador " + id + " fumant");
        Thread.sleep(500 + new Random().nextInt(500));
        fumades++;
        System.out.println("Fumador " + id + " ha fumat " + fumades + " vegades");
    }
}
