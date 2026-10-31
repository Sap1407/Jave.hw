import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = top; i <= bottom; i++) {
                System.out.print(a[i][left] + " ");
            }
            left++;

            for (int i = left; i <= right; i++) {
                System.out.print(a[bottom][i] + " ");
            }
            bottom--;

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(a[i][right] + " ");
                }
                right--;
            }

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(a[top][i] + " ");
                }
                top++;
            }
        }

        scanner.close();
    }
}