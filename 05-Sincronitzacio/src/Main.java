// Singleton para el compte compartido por todos los socios
class Compte {
    private static Compte instancia;
    private float saldo = 0;

    private Compte() {}

    public static Compte getInstance() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void ingressar(float quantitat) {
        saldo += quantitat;
    }

    public void retirar(float quantitat) {
        saldo -= quantitat;
    }
}

// Classe que representa un soci
class Soci extends Thread {
    private Compte compte;
    private static final float APORTACIO = 10f;
    private static final int ESPERA_MAX = 100;
    private static final int MAX_ANYS = 10;
    private java.util.Random rand = new java.util.Random();

    public Soci(Compte compte) {
        this.compte = compte;
    }

    @Override
    public void run() {
        for (int any = 0; any < MAX_ANYS; any++) {
            for (int mes = 0; mes < 12; mes++) {
                if (mes % 2 == 0) {
                    compte.ingressar(APORTACIO);
                } else {
                    compte.retirar(APORTACIO);
                }
                try {
                    Thread.sleep(rand.nextInt(ESPERA_MAX));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

// Classe principal que gestiona l'associació
class Associacio {
    private static final int NUM_SOCIS = 1000;
    private Soci[] socis;

    public Associacio() {
        socis = new Soci[NUM_SOCIS];
        Compte compte = Compte.getInstance();

        for (int i = 0; i < NUM_SOCIS; i++) {
            socis[i] = new Soci(compte);
        }
    }

    public void iniciaCompteTempsSocis() {
        for (Soci soci : socis) {
            soci.start();
        }
        for (Soci soci : socis) {
            try {
                soci.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes() {
        System.out.printf("Saldo: %.2f\n", Compte.getInstance().getSaldo());
    }
}

// Main per executar el programa
public class Main {
    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.mostraBalancComptes();
    }
}
