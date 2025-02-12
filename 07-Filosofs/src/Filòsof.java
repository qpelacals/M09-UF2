import java.util.Random;

public class Filòsof implements Runnable {
    private String nom;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;
    private Random random;

    public Filòsof(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.nom = nom;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.gana = 0;
        this.random = new Random();
    }

    public String getNom() {
        return nom;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    private void menjar() throws InterruptedException {
        synchronized (forquillaEsquerra) {
            System.out.println("Filòsof: " + nom + " agafa la forquilla esquerra " + forquillaEsquerra.getNumero());
            synchronized (forquillaDreta) {
                System.out.println("Filòsof: " + nom + " agafa la forquilla dreta " + forquillaDreta.getNumero());
                System.out.println("Filòsof: " + nom + " menja");
                int tempsMenjant = random.nextInt(1000) + 1000; // Entre 1s i 2s
                Thread.sleep(tempsMenjant);
                gana = 0;
                System.out.println("Filòsof: " + nom + " ha acabat de menjar");
            }
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof: " + nom + " pensant");
        int tempsPensant = random.nextInt(1000) + 1000; // Entre 1s i 2s
        Thread.sleep(tempsPensant);
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                while (true) {
                    if (forquillaEsquerra.isEnUs() || forquillaDreta.isEnUs()) {
                        gana++;
                        System.out.println("Filòsof: " + nom + " deixa l'esquerra(" + forquillaEsquerra.getNumero() +
                                ") i espera (dreta ocupada)");
                        System.out.println("Filòsof: " + nom + " gana=" + gana);
                        int tempsEspera = random.nextInt(500) + 500; // Entre 0,5s i 1s
                        Thread.sleep(tempsEspera);
                    } else {
                        break;
                    }
                }
                menjar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Filòsof: " + nom + " interromput");
        }
    }
}