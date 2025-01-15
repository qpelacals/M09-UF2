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
        try {
            while (potenciaActual != potenciaObjectiu) {
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    System.out.printf("Motor %s: Incre. Objectiu %d, Actual %d%n",
                            id, potenciaObjectiu, potenciaActual);
                } else if (potenciaActual > potenciaObjectiu){
                    potenciaActual--;
                    System.out.printf("Motor %s: Decre. Objectiu %d, Actual %d%n",
                            id, potenciaObjectiu, potenciaActual);
                } else {
                    System.out.printf("Motor %s: FerRes. Objectiu %d, Actual %d%n",
                            id, potenciaObjectiu, potenciaActual);
                }
                System.out.printf("Motor %s: Objectiu %d, Actual %d%n",
                        id, potenciaObjectiu, potenciaActual);
                Thread.sleep((int) (Math.random() * 2000)); // Dorm entre 0 i 2 segons
            }
        } catch (Exception e) {
            System.err.println("Motor " + id + " interromput!");
        }
    }
}
