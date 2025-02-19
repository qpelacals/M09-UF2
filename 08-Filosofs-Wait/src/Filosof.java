import java.util.Random;

class Filosof extends Thread {
    public Forquilla forquillaDreta;
    public Forquilla forquillaEsquerra;
    public int gana;

    public Filosof(String nom) {
        super(nom);
        gana = 0;
    }

    public void menjar() {
        while (true) {
            boolean menjat = false;

            // Agafem la forquilla esquerra si està lliure
            if (!forquillaEsquerra.isEnUs()) {
                forquillaEsquerra.setEnUs(true);
                System.out.printf("%s agafa la forquilla esquerra(%d)%n", getName(), forquillaEsquerra.getId());

                // Ara intentem agafar la dreta
                if (!forquillaDreta.isEnUs()) {
                    forquillaDreta.setEnUs(true);
                    System.out.printf("%s agafa la forquilla dreta(%d)%n", getName(), forquillaDreta.getId());

                    // Ara menjem
                    System.out.println(getName() + " menja");
                    gana = 0;

                    Random rnd = new Random();
                    int temps = 1200 + rnd.nextInt(800); // Entre 1.2s i 2s
                    try {
                        sleep(temps);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Deixem les forquilles després de menjar
                    forquillaDreta.setEnUs(false);
                    forquillaEsquerra.setEnUs(false);

                    // Confirmació de que ha acabat
                    System.out.println(getName() + " ha acabat de menjar");
                    menjat = true;
                } else {
                    // No pot menjar, alliberem la forquilla esquerra i esperem
                    System.out.printf("%s deixa l'esquerra(%d) i espera (dreta ocupada)%n", getName(), forquillaEsquerra.getId());
                    forquillaEsquerra.setEnUs(false);
                }
            }

            // Si no ha menjat, augmentem la gana i esperem
            if (!menjat) {
                gana++;
                System.out.printf("%s gana=%d%n", getName(), gana);

                // Espera entre 0,7s i 1,2s per fer-lo diferent
                Random rnd = new Random();
                int espera = 700 + rnd.nextInt(500);
                try {
                    sleep(espera);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }

    public void pensar() {
        Random rnd = new Random();
        int temps = 900 + rnd.nextInt(1100); // Entre 0.9s i 2s
        try {
            sleep(temps);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " pensa");
    }

    @Override
    public void run() {
        while (true) {
            menjar();
            pensar();
        }
    }
}