import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private int num;
    private Lock bloqueig;

    public Forquilla(int num) {
        this.num = num;
        this.bloqueig = new ReentrantLock();
    }

    public int getNum() {
        return num;
    }

    public void agafar() {
        bloqueig.lock();
    }

    public void deixar() {
        bloqueig.unlock();
    }
}