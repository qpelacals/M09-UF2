public class Motor implements Runnable {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private int id;

    public Motor(int id) {
        this.id = id;
    }

    //S'ha de fer que la potencia límit sigui 10 i que i que sino es queixi
    public synchronized void setPotencia(int p) {
        if (p <= 10) {
            this.potenciaObjectiu = p;
            run();
        } else {
            System.out.println("La potència límit és 10");
        }
    }

    @Override
    public void run() {
        try {
            while (potenciaActual != potenciaObjectiu) {
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                } else {
                    potenciaActual--;
                }
                System.out.printf("Motor %s: Objectiu %d, Actual %d%n",
                        id, potenciaObjectiu, potenciaActual);
                Thread.sleep((int) (Math.random() * 2000)); // Dorm entre 0 i 2 segons
            }
        } catch (InterruptedException e) {
            System.err.println("Motor " + id + " interromput!");
        }
    }

    public void start() {
        run();
    }
}
