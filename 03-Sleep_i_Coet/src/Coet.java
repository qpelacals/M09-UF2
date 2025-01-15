import java.util.Scanner;

public class Coet {
    private Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p) {
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public void passaaPotencias(int p) {
        if (p <= 10 && p >= 0) {
            for (Motor motor : motors) {
                motor.setPotencia(p);
            }
        } else {
            System.out.println("La potència límit és 10");
        }
    }

    public void startAll() {
        for (Motor motor : motors) {
            motor.start();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();

        Scanner scanner = new Scanner(System.in);
        int potencia = scanner.nextInt();
        coet.passaaPotencias(potencia);
        coet.startAll();

        while (potencia != 0) {
            potencia = scanner.nextInt();
            coet.passaaPotencias(potencia);
        }
        scanner.close();
    }
}
