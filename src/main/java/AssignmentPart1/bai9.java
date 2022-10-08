package AssignmentPart1;

import validate.Validate;

import java.util.Scanner;

public class bai9 {
    static Scanner sc;
    public static int[][] nhapMaTran(int[][] a){
        System.out.println("moi ban nhap so dong cua ma tran");
        String s=sc.nextLine();
        while(!Validate.validateInt(s)||!Validate.validatePositive(Double.parseDouble(s))){
            System.out.println("so dong cua ma tran phai la so nguyen duong");
            s=sc.nextLine();
        }
        int dong= Integer.parseInt(s);
        System.out.println("moi ban nhap so cot cua ma tran");
        s=sc.nextLine();
        while(!Validate.validateInt(s)||!Validate.validatePositive(Double.parseDouble(s))){
            System.out.println("so cot cua ma tran phai la so nguyen duong");
            s=sc.nextLine();
        }
        int cot= Integer.parseInt(s);
        a= new int[dong][cot];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.println("nhap voo phan tu thu ["+i+"]["+j+"]");
                a[i][j]=sc.nextInt();
            }
        }
        return a;
    }

    public static int tichBoiSo(int[][] a){
        int result=1;
        for(int i=0;i<a[0].length;i++){
            if(3%a[0][i]==0){
                result*=a[0][i];
            }
        }
        return result;
    }

    public static int[] GTLNMoiDong(int[][] a){
        int[] x= new int[a.length];
        int max;
        for(int i=0;i<a.length;i++){
            max=a[i][0];
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]>max){
                    max=a[i][j];
                }
            }
            x[i]=max;
        }
        return x;
    }

    public static void main(String[] args) {
        int a[][]=null;
        StringBuilder stringBuilder=null;
        boolean start = true;
        while (start) {
            System.out.println("Choose what function you want to process:");
            System.out.println("1.Nhap ma tran a ");
            System.out.println("2.tinh tich cac boi so cua 3 tren dong dau tien");
            System.out.println("3.cac gia tri lon nhat tren tung dong");
            System.out.println("4.Exit ");
            System.out.println("_________________________");
            sc=new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            boolean inner = true;
            while (inner) {
                switch (choice) {
                    case 1:
                        inner = false;
                        System.out.println("_________________________");
                        a=nhapMaTran(a);
                        System.out.println("_________________________");
                        break;
                    case 2:
                        inner = false;
                        System.out.println("_________________________");
                        if(a!=null){
                            System.out.println("tich cac boi so cua 3 tren dong dau tien:"+tichBoiSo(a));
                        }
                        else{
                            System.out.println("ban chua nhap ma tran");
                        }
                        System.out.println("_________________________");
                        break;
                    case 3:
                        inner = false;
                        System.out.println("_________________________");
                        if(a!=null){
                            System.out.println("cac gia tri lon nhat tren tung dong:");
                            for(int i:GTLNMoiDong(a)){
                                System.out.print(i+" ");
                            }
                        }
                        else{
                            System.out.println("ban chua nhap ma tran");
                        }
                        System.out.println("\n");
                        System.out.println("_________________________");
                        break;
                    case 4:
                        inner = false;
                        start = false;
                        break;
                    default:
                        System.out.println("_________________________");
                        System.out.println("Wrong choice");
                        System.out.println("Try again please");
                        choice = Integer.parseInt(sc.nextLine());
                        System.out.println("_________________________");
                        break;
                }
            }
        }
    }

}
