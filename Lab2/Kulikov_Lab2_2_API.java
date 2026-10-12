import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("Введите количество строк: ");
        int n = sc.nextInt();
        System.out.print("Введите количество столбцов: ");
        int m = sc.nextInt();

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = rnd.nextInt(9) - 3;
            }
        }

        System.out.println("\nИсходная матрица:");
        printMatrix(a);

        a = Arrays.stream(a)
                .map(row -> {
                    int[] temp = new int[row.length];
                    int k = 0;
                    for (int v : row) {
                        if (v != 0) temp[k++] = v;
                    }
                    for (int v : row) {
                        if (v == 0) temp[k++] = 0;
                    }
                    return temp;
                })
                .toArray(int[][]::new);

        System.out.println("\nМатрица после переноса нулей в конец строк:");
        printMatrix(a);

        final int cols = m;
        boolean[] deleteCol = new boolean[cols];
        int[] count = {0};
        for (int j = 0; j < cols; j++) {
            final int col = j;
            boolean allZero = Arrays.stream(a)
                    .allMatch(row -> row[col] == 0);
            if (allZero) {
                deleteCol[j] = true;
            } else {
                count[0]++;
            }
        }
        int newM = count[0];

        int[][] b = Arrays.stream(a)
                .map(row -> {
                    int[] temp = new int[newM];
                    int k = 0;
                    for (int j = 0; j < cols; j++) {
                        if (!deleteCol[j]) {
                            temp[k++] = row[j];
                        }
                    }
                    return temp;
                })
                .toArray(int[][]::new);

        System.out.println("\nМатрица без нулевых столбцов:");
        printMatrix(b);
        sc.close();
    }

    static void printMatrix(int[][] a) {
        Arrays.stream(a).forEach(row -> {
            Arrays.stream(row).forEach(v -> System.out.printf("%5d", v));
            System.out.println();
        });
    }
}