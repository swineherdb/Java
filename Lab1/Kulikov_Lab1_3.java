// Найти и вывести из заданной последовательности натуральных чисел, все
// совершенные числа в записи которых есть цифры 3 или 1. Совершенным называется
// число, равное сумме всех своих делителей, не равных самому числу, например, 6 = 1 + 2
// + 3 или 28 = 1 + 2 + 4 + 7 + 14.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько чисел в последовательности: ");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.print("Введите число: ");
            int n = scanner.nextInt();
            int sum = 0;
            for (int divisor = 1; divisor < n; divisor++) {
                if (n % divisor == 0) {
                    sum = sum + divisor;
                }
            }
            if (sum == n) {
                String s = String.valueOf(n);
                boolean hasDigit = false;
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (c == '3' || c == '1') {
                        hasDigit = true;
                    }
                }
                if (hasDigit) {
                    System.out.println(n);
                }
            }
        }
    }
}