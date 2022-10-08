package AssignmentPart1;

import validate.Validate;

import java.util.Scanner;

public class bai6 {
    static Scanner sc = new Scanner(System.in);

    public static int inputN(Scanner sc){
        String input = sc.nextLine();
        int output;
        while(!Validate.validateIntWithoutRound(input) || !Validate.validatePositive(Double.parseDouble(input))){
            System.out.print("Please input positive integer and not char:");
            input=sc.nextLine();
        }
        output=(int)Math.round(Double.parseDouble(input));
        return output;
    }

    public static void convertBinary(int num) {
        int binary[] = new int[40];
        int index = 0;
        while (num > 0) {
            binary[index++] = num % 2;
            num = num / 2;
        }
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }
    }
    public static void main(String[] args) {
        int a;
        int b;
        System.out.print("input a:");
        a=inputN(sc);
        convertBinary(a);
    }
}
