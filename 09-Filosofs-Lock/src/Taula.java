public class Taula {
    private Filosof[] comensals;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        comensals = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilosofs; i++) {
            comensals[i] = new Filosof(i, forquilles[i], forquilles[(i + 1) % numFilosofs]);
        }
    }

    public void showTaula() {
        for (Filosof filosof : comensals) {
            System.out.println("Comensal:Fil" + filosof.getNum() + " esq:" + filosof.getForquillaEsquerra().getNum() + " dret:" + filosof.getForquillaDreta().getNum());
        }
    }

    public void cridaraTaula() {
        for (Filosof filosof : comensals) {
            new Thread(filosof).start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridaraTaula();
    }
}