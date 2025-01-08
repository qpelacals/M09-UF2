public class Principal {
    public static void main(String[] args) {
        // Creem les instàncies dels fils amb noms "Juan" i "Pepe"
        Fil filJuan = new Fil("Juan");
        Fil filPepe = new Fil("Pepe");

        // Iniciem els fils i alternem la seva execució
        for (int i = 1; i <= 9; i++) {
            try {
                // Executem una iteració de "Juan"
                int finalI = i;
                Thread threadJuan = new Thread(() -> filJuan.runIteration(finalI));
                threadJuan.start();
                threadJuan.join(); // Esperem que "Juan" acabi la seva iteració

                // Executem una iteració de "Pepe"
                Thread threadPepe = new Thread(() -> filPepe.runIteration(finalI));
                threadPepe.start();
                threadPepe.join(); // Esperem que "Pepe" acabi la seva iteració
            } catch (InterruptedException e) {
                System.out.println("Fil principal interromput.");
            }
        }

        // Finalitzem els fils
        System.out.println("Termina el fil Juan");
        System.out.println("Termina el fil Pepe");
    }
}