import java.util.Random;

public class Filosof extends Thread {
    private final int id;
    private Forquilla forquillaEsquerra, forquillaDreta;
    private int gana;
    private final Random random = new Random();

    public Filosof(int id) {
        this.id = id;
        this.gana = 0;
    }

    public void setForquilles(Forquilla esquerra, Forquilla dreta) {
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                if (agafarForquilles()) {
                    menjar();
                    deixarForquilles();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean agafarForquilles() throws InterruptedException {
        while (true) {
            synchronized (forquillaEsquerra) {
                if (forquillaEsquerra.getPropietari() == Forquilla.LLIURE) {
                    forquillaEsquerra.agafar(id);
                    System.out.println("Filòsof " + id + " ha agafat la forquilla esquerra.");

                    synchronized (forquillaDreta) {
                        if (forquillaDreta.getPropietari() == Forquilla.LLIURE) {
                            forquillaDreta.agafar(id);
                            System.out.println("Filòsof " + id + " ha agafat la forquilla dreta.");
                            return true;
                        }
                    }
                    // No ha pogut agafar la forquilla dreta, deixa la esquerra
                    forquillaEsquerra.deixar();
                    System.out.println("Filòsof " + id + " ha deixat la forquilla esquerra.");
                }
            }
            gana++;
            System.out.println("Gana del filòsof " + id + ": " + gana);
            Thread.sleep(500 + random.nextInt(500)); // Espera entre 0.5s i 1s abans de tornar-ho a intentar
        }
    }

    private void deixarForquilles() {
        synchronized (forquillaEsquerra) {
            forquillaEsquerra.deixar();
            forquillaEsquerra.notifyAll();
        }
        synchronized (forquillaDreta) {
            forquillaDreta.deixar();
            forquillaDreta.notifyAll();
        }
        System.out.println("Filòsof " + id + " ha deixat les forquilles.");
    }

    private void menjar() throws InterruptedException {
        System.out.println("Filòsof " + id + " està menjant.");
        Thread.sleep(1200 + random.nextInt(800)); // Entre 1.2s i 2s
        gana = 0;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof " + id + " està pensant.");
        Thread.sleep(900 + random.nextInt(1100)); // Entre 0.9s i 2s
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public int getGana() {
        return gana;
    }
}