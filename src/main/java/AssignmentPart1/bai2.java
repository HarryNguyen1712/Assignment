package AssignmentPart1;

import validate.Validate;

import java.util.Scanner;

/**
 * The type Bai 2.
 */
public class bai2 {
    static Scanner sc = new Scanner(System.in);
    /**
     * nhập đầu vào.
     *
     * @param sc the sc
     * @return the int
     */
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
    /**
     * Tinh chuỗi đề cho.
     *
     * @param n the n
     * @return the double
     */
public static double bai2(int n){
        double s=1;
        for(int i=2;i<=n;i++){
            s = s +  (1 / (double)i);

        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println(bai2(inputN(sc)));
    }
}
