package AssignmentPart1;

import validate.Validate;

import java.util.Scanner;

public class bai3 {
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
    public static double bai3(int n){
        int g=0;
        int mauso ;
        double result = 0;
        for(int i=1;i<=n;i++){
            g=(2*i)-1;
            mauso=1;
            for(int k=1;k<=g;k++){
                mauso*=k;
            }
            result+=(1/(double)mauso);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(bai3(inputN(sc)));
    }
}
