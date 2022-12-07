package com.example.lab1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введіть розмір масиву: ");
        int n = input.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        Random random = new Random();
        for (int i = 0; i < n; i++)
        {
            arr.add(random.nextInt(100));
        }

        printArray(arr);
        printEven(arr, n);
    }

    public static void printArray(ArrayList<Integer> arr)
    {
        for (int i = 0; i < arr.size(); i++)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }

    public static void printEven(ArrayList<Integer> arr, int n)
    {
        int evenSize = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i+1) % 2 == 0 && i % 2 == 0) {
                evenSize++;
            }
        }
        System.out.println("Кількість парних елементів масиву, що стоять на парних місцях: " + evenSize);
    }
}
