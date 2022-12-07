package com.example.lab1;

public class Task6 {
    public static void main(String[] args) {
        String [] numbers = {"9", "44", "123", "1011", "100"};
        for (String s : numbers){
            if (!s.contains("1")||!s.contains("0")){
                System.out.println("Двійкова форма: "+Integer.toBinaryString(Integer.parseInt(s))+
                        "    Десяткова форма: "+Integer.parseInt(s));

            }   else {
                System.out.println("Двійкова форма: "+s+"    Десяткова форма: "+ Integer.parseInt(s,2));
            }
        }

    }
}
