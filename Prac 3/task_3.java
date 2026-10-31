import java.util.Scanner;
import java.util.Arrays;

public class task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(parts[n + 1 + i]);
        }

        swap(a, b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        scanner.close();
    }

    public static void swap(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            a[i] = b[i];
            b[i] = temp;
        }
    }
}