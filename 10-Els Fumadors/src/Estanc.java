import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Estanc {
    private final List<Tabac> tabac = new ArrayList<>();
    private final List<Paper> paper = new ArrayList<>();
    private final List<Llumi> llumi = new ArrayList<>();
    private boolean obert = true;
    private final Random random = new Random();

    public synchronized void nouSubministrament() {
        while (obert) {
            try {
                Thread.sleep(500 + random.nextInt(1000));
                int tipus = random.nextInt(3);
                switch (tipus) {
                    case 0 -> addTabac();
                    case 1 -> addPaper();
                    case 2 -> addLlumi();
                }
                notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void addTabac() {
        tabac.add(new Tabac());
        System.out.println("Afegint tabac");
    }

    public synchronized void addPaper() {
        paper.add(new Paper());
        System.out.println("Afegint Paper");
    }

    public synchronized void addLlumi() {
        llumi.add(new Llumi());
        System.out.println("Afegint Llumí");
    }

    public synchronized Tabac venTabac() throws InterruptedException {
        while (tabac.isEmpty()) wait();
        return tabac.remove(0);
    }

    public synchronized Paper venPaper() throws InterruptedException {
        while (paper.isEmpty()) wait();
        return paper.remove(0);
    }

    public synchronized Llumi venLlumi() throws InterruptedException {
        while (llumi.isEmpty()) wait();
        return llumi.remove(0);
    }

    public synchronized void tancarEstanc() {
        obert = false;
        notifyAll();
    }
}