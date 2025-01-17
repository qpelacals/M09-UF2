public class Motor extends Thread {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private int id;

    public Motor(int id) {
        this.id = id;
    }

    //S'ha de fer que la potencia límit sigui 10 i que i que sino es queixi
    public void setPotencia(int p) {
            this.potenciaObjectiu = p;
    }

    @Override
    public void run() {
        boolean primeraRonda = true;

        // Espera activa inicial hasta que potenciaObjectiu > 0
        while (potenciaObjectiu == 0) {
            try {
                Thread.sleep(100); // Pausa breve para evitar consumir demasiados recursos
            } catch (InterruptedException e) {
                System.err.println("Motor " + id + " interromput durant la inicialització!");
                return;
            }
        }

        try {
            while (true) {
                while (potenciaActual != potenciaObjectiu) {
                    // Dormimos el hilo entre 0 y 2 segundos
                    Thread.sleep((int) (Math.random() * 2000));

                    try {
                        // Actualizamos la potenciaActual
                        if (potenciaActual < potenciaObjectiu) {
                            potenciaActual++;
                        } else if (potenciaActual > potenciaObjectiu) {
                            potenciaActual--;
                        }

                        if (potenciaActual < potenciaObjectiu)
                            System.out.printf("Motor %s: Incre. Objectiu %d, Actual %d%n",
                                id, potenciaObjectiu, potenciaActual);
                        if (potenciaActual > potenciaObjectiu)
                            System.out.printf("Motor %s: Decre. Objectiu %d, Actual %d%n",
                                    id, potenciaObjectiu, potenciaActual);
                        if (potenciaActual == potenciaObjectiu)
                            System.out.printf("Motor %s: FerRes. Objectiu %d, Actual %d%n",
                                id, potenciaObjectiu, potenciaActual);
                    } catch (Exception e) {
                        System.out.println("El fil ha estat interromput.");
                    }
                }

                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("El fil ha estat interromput.");
                }

                if (potenciaActual == 0) {
                    return;
                }
            }
        } catch (InterruptedException e) {
            System.err.println("Motor " + id + " interromput!");
        }
    }


}
