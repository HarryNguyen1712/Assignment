package AssignmentPart1;

import validate.Validate;

import java.util.Scanner;

public class bai5 {
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
    public static int  USCLN(int a,int b){

        while(a!=b){
            if(a>b){
                a=a-b;
            }
            else{
                b=b-a;
            }
        }
        return a;
    }
    public static int BSCNN(int a,int b){
        return (a*b)/USCLN(a,b);
    }
    public static void bai5(int a,int b){
        System.out.println("USCLN:"+ USCLN(a,b));
        System.out.println("BSCNN:"+ BSCNN(a,b));
    }
    public static void main(String[] args) {
        int a;
        int b;
        System.out.print("input a:");
        a=inputN(sc);
        System.out.print("input b:");
        b=inputN(sc);
        bai5(a,b);
    }
}
