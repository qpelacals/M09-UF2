public class Assistent implements Runnable {
    private String nom;
    private Esdeveniment esdeveniment;

    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        try {
            System.out.println(nom + ": Esperant que comenci l'esdeveniment...");
            participarEsdeveniment();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private synchronized void participarEsdeveniment() throws InterruptedException {
        while (!esdeveniment.isActiu()) {
            wait(); // Espera fins que l'esdeveniment comenci
        }
        System.out.println(nom + ": L'esdeveniment ha començat! Participància...");
    }
}