package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count =0;
        for(int i=1;i<=100;i++){
            if(i%4==0){
                count++;
            }

        }
        System.out.println(count);
        /*Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("Please enter a positive number!");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next(); // this is important!
            }
            number = sc.nextInt();
            System.out.println(number);
        } while (number <= 0);
        System.out.println("Thank you! Got " + number);*/
    }
}