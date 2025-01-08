public class DormAleatori extends Thread {
    private long tempsInicial;

    public DormAleatori(String nom) {
        super(nom);
        this.tempsInicial = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int interval = (int) (Math.random() * 1000); // Interval aleatori entre 0 i 1000 ms
            System.out.printf("%s(%d) a dormir %d ms, total %d ms%n",
                    getName(), i, interval, (System.currentTimeMillis() - tempsInicial));
            try {
                Thread.sleep(interval); // Dormir l'interval aleatori
            } catch (InterruptedException e) {
                System.err.println(getName() + " interromput!");
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main -----------");
    }
}