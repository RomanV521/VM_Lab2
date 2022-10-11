package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        System.out.print("Введите num1:");
        num1 = sc.nextInt();
        System.out.print("Введите num2:");
        num2 = sc.nextInt();

        System.out.println("Результат сравнения: "+add(num1, num2));
    }

    /**
     * Перевод из восьмеричной в двоичную<br><br>
     * Convert from decimal to binary
     * @param input
     * @return
     */
    public static String toBin(int input)
    {
        int temp=0;
        String output="";

        //Перевод из 8-ной в 10-ную при помощи встроеной функции
        input = Integer.parseInt(input+"", 8);

        //Перевод из 10-ной в 2-ную при помощи деления на два
        while(input !=0){
            temp = input%2;
            output = temp + output;
            input = input/2;
        }
        return output;
    }

    public static String add(int a, int b){
        int num1 = Integer.parseInt(toBin(a));
        int num2 = Integer.parseInt(toBin(b));


//        return Integer.toBinaryString(num1 + num2);

        int temp;
        int carry = 0;
        StringBuilder output= new StringBuilder();

        while (num1 !=0 || num2 != 0){
            temp = (num1 % 10 + num2 % 10 + carry)%2;
            output.append(temp);

            carry = (num1 % 10 + num2 % 10 + carry)/2;
            num1 = num1/10;
            num2 = num2/10;
        }
        if (carry != 0){
            output.append(carry);
        }
        return output.reverse().toString();
    }
}
