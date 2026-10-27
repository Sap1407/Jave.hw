import java.util.Scanner;


public class PowerSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        int n = scanner.nextInt();

        System.out.println(sum(a, n));
        scanner.close();
    }

    public static double sum(double a, int n) {
        double y = 0;
        double power = 1;

        for (int i = 1; i <= n; i++) {
            power = power * a;
            y = y + power;
        }

        return y;
    }
}
