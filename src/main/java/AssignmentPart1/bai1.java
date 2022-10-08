package AssignmentPart1;

import validate.Validate;

import java.util.Scanner;

public class bai1 {
    static Scanner sc = new Scanner(System.in);
    public static int inputN(Scanner sc){
        System.out.println("Please input n");
        String input = sc.nextLine();
        int output;
        while(!Validate.validateInt(input) || !Validate.validatePositive(Double.parseDouble(input))){
            System.out.println("Please input positive integer and not char:");
            input=sc.nextLine();
        }
        output=(int)Math.round(Double.parseDouble(input));
        return output;
    }
    public static void bai1(int i){
        for(int n=1;n<=i;n++){
            for(int k=1;k<=n;k++){
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        bai1(inputN(sc));
    }
}
