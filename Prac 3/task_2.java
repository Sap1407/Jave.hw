import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        int n = parts.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] % 2 == arr[i - 1] % 2) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(0);
    }
}