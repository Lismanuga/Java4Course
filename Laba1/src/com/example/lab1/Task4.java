package com.example.lab1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args)
    {
        int rows, columns;
        System.out.print("Введіль кількісь рядків: ");
        rows = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.print("Введіть кількість стовпців: ");
        columns = Integer.parseInt(new Scanner(System.in).nextLine());
        int[][] matrix = new int[rows][columns];
        System.out.println("Початкова матриця: ");
        int[] sum = new int[rows];
        for (int i = 0; i < rows; i++) {
            sum[i] = 0;
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) ((Math.random() * 22) - 11);
                System.out.printf("%1$5s", matrix[i][j]);
                if (matrix[i][j] < 0 && matrix[i][j] % 2 == -1) {
                    sum[i] += Math.abs(matrix[i][j]);
                }
            }
            System.out.printf(" Sum: %1$s" + "\r\n", sum[i]);
        }
        for (int i = 0; i < sum.length - 1; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[i] > sum[j]) {
                    int b = sum[i];
                    sum[i] = sum[j];
                    sum[j] = b;
                    for (int m = 0; m < columns; m++) {
                        b = matrix[i][m];
                        matrix[i][m] = matrix[j][m];
                        matrix[j][m] = b;
                    }
                }
            }
        }
        System.out.println("Оброблена матриця: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%1$5s", matrix[i][j]);
            }
            System.out.printf(" Sum: %1$s" + "\r\n", sum[i]);
        }
}
}
