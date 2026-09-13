// Каждое натуральное число n из заданной последовательности чисел разложить на простые множители.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько чисел в последовательности: ");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.print("Введите число: ");
            int n = scanner.nextInt();
            System.out.print(n + " = ");
            int divisor = 2;
            boolean first = true;
            while (n > 1) {
                if (n % divisor == 0) {
                    if (!first) {
                        System.out.print(" * ");
                    }
                    System.out.print(divisor);
                    first = false;
                    n = n / divisor;
                } else {
                    divisor = divisor + 1;
                }
            }
            System.out.println();
        }
    }
}