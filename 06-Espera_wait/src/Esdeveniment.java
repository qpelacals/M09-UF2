public class Esdeveniment {
    private String nom;
    private boolean actiu;

    public Esdeveniment(String nom) {
        this.nom = nom;
        this.actiu = false;
    }

    public synchronized void iniciar() {
        if (!actiu) {
            this.actiu = true;
            notifyAll(); // Notifica tots els assistents que l'esdeveniment ha començat
        }
    }

    public synchronized void finalitzar() {
        if (actiu) {
            this.actiu = false;
            notifyAll(); // Notifica tots els assistents que l'esdeveniment ha acabat
        }
    }

    public boolean isActiu() {
        return actiu;
    }
}