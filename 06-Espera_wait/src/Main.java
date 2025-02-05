public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Creació de l'esdeveniment
        Esdeveniment esdeveniment = new Esdeveniment("Festa");

        // Creació de l'organitzador
        Organitzador organitzador = new Organitzador(esdeveniment);

        // Creació d'assistents
        Assistent a1 = new Assistent("Pere", esdeveniment);
        Assistent a2 = new Assistent("Marta", esdeveniment);
        Assistent a3 = new Assistent("Josep", esdeveniment);

        // Iniciar els assistents en nous threads
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a2);
        Thread t3 = new Thread(a3);
        t1.start();
        t2.start();
        t3.start();

        // Esperar 5 segons abans d'iniciar l'esdeveniment
        Thread.sleep(5000);

        // Iniciar l'esdeveniment
        organitzador.iniciarEsdeveniment();

        // Finalització de l'exemple
        System.out.println("Process finalitzat");
    }
}