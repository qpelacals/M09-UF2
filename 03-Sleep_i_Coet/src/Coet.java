import java.util.Scanner;

public class Coet {
    private Motor[] motors = new Motor[4];
    private Thread[] fils = new Thread[4];

    public Coet() {
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor("Motor " + i);
            fils[i] = new Thread(motors[i]);
        }
    }

    public void arranca() {
        for (Thread fil : fils) {
            fil.start();
        }
    }

    public void passaAPotencia(int p) {
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Introdueix la potència objectiu (0 per parar): ");
            int potencia = scanner.nextInt();
            coet.passaAPotencia(potencia);
            if (potencia == 0) {
                break;
            }
        }
        scanner.close();
    }
}
