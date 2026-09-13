// Для каждого числа из заданной последовательности натуральных чисел найти
// произведение цифр, находящихся на нечётных позициях (нумерация позиций идёт слева
// направо).

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько чисел в последовательности: ");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.print("Введите число: ");
            int n = scanner.nextInt();
            String s = String.valueOf(n);
            int product = 1;
            for (int position = 0; position < s.length(); position++) {
                if (position % 2 == 0) {
                    int digit = Character.getNumericValue(s.charAt(position));
                    product = product * digit;
                }
            }
            System.out.println("Произведение цифр на нечётных позициях: " + product);
        }
    }
}