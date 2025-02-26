class Forquilla {
    private int id;
    private int propietari;
    public static final int LLIURE = -1;

    public Forquilla(int id) {
        this.id = id;
        this.propietari = LLIURE;
    }

    public synchronized void agafar(int filosofId) throws InterruptedException {
        /*while (propietari != LLIURE) {
            wait();
        }*/
        propietari = filosofId;
    }

    public synchronized void deixar() {
        propietari = LLIURE;
        notifyAll();
    }

    public int getId() {
        return id;
    }

    public int getPropietari() {return propietari;}
}