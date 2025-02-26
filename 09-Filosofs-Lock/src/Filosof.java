import java.util.Random;

public class Filosof implements Runnable {
    private int num;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int iniciGana;
    private int fiGana;
    private int gana;
    private Random random = new Random();

    public Filosof(int num, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.num = num;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
    }

    public int getNum() {
        return num;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    private void agafarForquilles() {
        forquillaEsquerra.agafar();
        forquillaDreta.agafar();
    }

    private void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
    }

    private void menjar() {
        agafarForquilles();
        fiGana = (int) System.currentTimeMillis() / 1000;
        gana = fiGana - iniciGana;
        System.out.println("Fil" + num + " menja amb gana " + gana);
        try {
            Thread.sleep(random.nextInt(1000) + 1000); // Menja entre 1s i 2s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resetGana();
        deixarForquilles();
    }

    private void pensar() {
        iniciGana = (int) System.currentTimeMillis() / 1000;
        try {
            Thread.sleep(random.nextInt(1000) + 1000); // Pensa entre 1s i 2s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void resetGana() {
        iniciGana = 0;
        gana = 0;
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            menjar();
        }
    }
}