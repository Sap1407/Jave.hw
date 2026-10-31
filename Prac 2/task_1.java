import java.util.Scanner;


public class task_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double y = sum(n);

        System.out.println(y);
        scanner.close();
    }

    public static double sum(int n) {
        double y = 0;

        for (int i = 2; i <= n; i++) {
            double denom = (double) i * i - 1;
            y = y + 1.0 / denom;
        }

        return y;
    }
}
