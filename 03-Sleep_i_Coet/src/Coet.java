import java.util.Scanner;

public class Coet {
    private Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void arranca() {
        for (Motor motor : motors) motor.start();
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
            int potencia = scanner.nextInt();
            coet.passaAPotencia(potencia);
            if (potencia == 0) {
                break;
            }
        }
        scanner.close();
    }
}
