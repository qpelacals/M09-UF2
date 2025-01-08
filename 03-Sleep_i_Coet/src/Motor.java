public class Motor implements Runnable {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private String nom;

    public Motor(String nom) {
        this.nom = nom;
    }

    public synchronized void setPotencia(int p) {
        this.potenciaObjectiu = p;
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
                        nom, potenciaObjectiu, potenciaActual);
                Thread.sleep((int) (Math.random() * 2000)); // Dorm entre 0 i 2 segons
            }
        } catch (InterruptedException e) {
            System.err.println("Motor " + nom + " interromput!");
        }
    }
}
