package com.example.lab1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Введіть a");
        double a = myObj.nextDouble();
        System.out.println("Введіть b");
        double b = myObj.nextDouble();
        System.out.println("Введіть c");
        double c = myObj.nextDouble();

        double root1, root2;

        double determinant = b * b - 4 * a * c;

        if (determinant > 0) {
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);
            System.out.format("Перший корінь = %.2f , другий корінь = %.2f", root1, root2);
            System.out.println();
        }
        else if (determinant == 0) {
            root1 = root2 = -b / (2 * a);
            System.out.format("Перший та другий корені = %.2f;", root1);
            System.out.println();
        }
        else {
            System.out.format("Немає дійсних коренів");
            System.out.println();
        }
    }
}