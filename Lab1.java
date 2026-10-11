import java.util.Random;
import java.util.Scanner;

public class Lab1 {

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
                a[i][j] = rnd.nextInt(20) - 5;
            }
        }

        System.out.println("\nИсходная матрица:");
        printMatrix(a);
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = maxLength(a[i]);
        }

        System.out.println("\nДлины последовательностей:");
        for (int i = 0; i < n; i++) {
            System.out.print(len[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (len[j] > len[j + 1]) {
                    int[] temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    int t = len[j];
                    len[j] = len[j + 1];
                    len[j + 1] = t;
                }
            }
        }

        System.out.println("\nМатрица после сортировки строк:");
        printMatrix(a);
        int[][] zub = new int[n][];
        for (int i = 0; i < n; i++) {
            zub[i] = longest(a[i]);
        }

        System.out.println("\nЗубчатый массив:");
        for (int i = 0; i < n; i++) {
            System.out.print("Строка " + i + ": ");
            for (int j = 0; j < zub[i].length; j++) {
                System.out.print(zub[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    static int maxLength(int[] row) {
        int max = 1;
        int cur = 1;
        for (int i = 1; i < row.length; i++) {
            if (row[i] > row[i - 1]) {
                cur++;
                if (cur > max) max = cur;
            } else {
                cur = 1;
            }
        }
        return max;
    }

    static int[] longest(int[] row) {
        int bestStart = 0, bestLen = 1;
        int curStart = 0, curLen = 1;

        for (int i = 1; i < row.length; i++) {
            if (row[i] > row[i - 1]) {
                curLen++;
            } else {
                if (curLen > bestLen) {
                    bestLen = curLen;
                    bestStart = curStart;
                }
                curStart = i;
                curLen = 1;
            }
        }
        if (curLen > bestLen) {
            bestLen = curLen;
            bestStart = curStart;
        }

        int[] res = new int[bestLen];
        for (int i = 0; i < bestLen; i++) {
            res[i] = row[bestStart + i];
        }
        return res;
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