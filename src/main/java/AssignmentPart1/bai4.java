package AssignmentPart1;

import validate.Validate;

import java.util.Scanner;

public class bai4 {
    static Scanner sc = new Scanner(System.in);
    public static int inputN(Scanner sc){
        System.out.println("Please input n");
        String input = sc.nextLine();
        int output;
        while(!Validate.validateIntWithoutRound(input) || !Validate.validatePositive(Double.parseDouble(input))){
            System.out.println("Please input positive integer and not char:");
            input=sc.nextLine();
        }
        output=(int)Math.round(Double.parseDouble(input));
        return output;
    }
    public static double bai4(int n){
        String m=Integer.toString(n);
        int result=1;
        while(!m.matches("")){
            if(m.length()>0) {
                result *= Integer.parseInt(m.substring(0, 1));
                m = m.substring(1);

            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(bai4(inputN(sc)));
    }
}
