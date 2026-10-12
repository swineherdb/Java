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

        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            int k = 0;
            for (int j = 0; j < m; j++) {
                if (a[i][j] != 0) {
                    temp[k] = a[i][j];
                    k++;
                }
            }
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    temp[k] = 0;
                    k++;
                }
            }
            a[i] = temp;
        }

        System.out.println("\nМатрица после переноса нулей в конец строк:");
        printMatrix(a);

        boolean[] deleteCol = new boolean[m];
        int newM = 0;
        for (int j = 0; j < m; j++) {
            boolean allZero = true;
            for (int i = 0; i < n; i++) {
                if (a[i][j] != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                deleteCol[j] = true;
            } else {
                newM++;
            }
        }

        int[][] b = new int[n][newM];
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = 0; j < m; j++) {
                if (!deleteCol[j]) {
                    b[i][k] = a[i][j];
                    k++;
                }
            }
        }

        System.out.println("\nМатрица без нулевых столбцов:");
        printMatrix(b);
        sc.close();
    }

    static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%5d", a[i][j]);
            }
            System.out.println();
        }
    }
}