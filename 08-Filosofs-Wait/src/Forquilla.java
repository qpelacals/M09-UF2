class Forquilla {
    private int id;
    private boolean enUs;

    public Forquilla(int id) {
        this.id = id;
        enUs = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnUs() {
        return enUs;
    }

    public void setEnUs(boolean enUs) {
        this.enUs = enUs;
    }
}