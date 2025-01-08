public class Fil implements Runnable {
    private String nom;

    public Fil(String nom) {
        this.nom = nom;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 9; i++) {
                // Mostrem el nom del fil i el número de l'iteració
                System.out.println(nom + " " + i);

                // Fem que el fil dormi una estona per simular intercalació
                Thread.sleep((int) (Math.random() * 500)); // Temps aleatori entre 0 i 500 ms
            }
        } catch (InterruptedException e) {
            System.out.println("El fil " + nom + " ha estat interromput.");
        }

        // Missatge al final del fil
        System.out.println("Termina el fil " + nom);
    }

    public void runIteration(int i) {
        System.out.println(nom + " " + i);
    }
}
