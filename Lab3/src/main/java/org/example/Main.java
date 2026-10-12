package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество дробей k: ");
        int k = sc.nextInt();

        Fraction[] arr = new Fraction[k];

        for (int i = 0; i < k; i++) {
            System.out.println("Дробь №" + (i + 1));
            System.out.print("  Числитель: re = ");
            double mRe = sc.nextDouble();
            System.out.print("  Числитель: im = ");
            double mIm = sc.nextDouble();
            System.out.print("  Знаменатель: re = ");
            double nRe = sc.nextDouble();
            System.out.print("  Знаменатель: im = ");
            double nIm = sc.nextDouble();
            arr[i] = new Fraction(new Complex(mRe, mIm), new Complex(nRe, nIm));
        }

        System.out.println("\nИсходный массив дробей:");
        printArray(arr);
        changeArray(arr);

        System.out.println("\nМассив после изменения:");
        printArray(arr);
        sc.close();
    }

    static void changeArray(Fraction[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            arr[i] = arr[i].add(arr[i + 1]);
        }
    }

    static void printArray(Fraction[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("[" + i + "] " + arr[i]);
        }
    }
}