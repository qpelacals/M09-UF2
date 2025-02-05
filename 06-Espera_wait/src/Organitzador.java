public class Organitzador {
    private Esdeveniment esdeveniment;

    public Organitzador(Esdeveniment esdeveniment) {
        this.esdeveniment = esdeveniment;
    }

    public void iniciarEsdeveniment() {
        System.out.println("Organitzador: Iniciant l'esdeveniment...");
        esdeveniment.iniciar();
    }
}