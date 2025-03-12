class Barber implements Runnable {
    private String name;
    private Barberia barberia;

    public Barber(String name, Barberia barberia) {
        this.name = name;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            Client client = barberia.seguentClient();
            if (client == null) {
                System.out.println("Ningú en espera");
                System.out.println("Barber " + name + " dormint");
                synchronized (barberia.condBarber) {
                    try {
                        barberia.condBarber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Li toca al client " + client.getNom());
                client.tallarseElCabell();
            }
        }
    }
}