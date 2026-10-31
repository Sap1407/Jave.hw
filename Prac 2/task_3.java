import java.util.Scanner;


public class task_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (hasOddDigit(n)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        scanner.close();
    }

    public static boolean hasOddDigit(int n) {
        while (n > 0) {
            int digit = n % 10;

            if (digit % 2 != 0) {
                return true;
            }

            n = n / 10;
        }

        return false;
    }
}
