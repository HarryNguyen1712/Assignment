package AssignmentPart1;

import validate.Validate;

import java.util.Scanner;

public class bai8 {
    static Scanner sc= new Scanner(System.in);
    public static int[] nhapMang(int a[]){

        System.out.println("moi ban nhap chieu dai mang");
        String s=sc.nextLine();
        while(!Validate.validateInt(s)||!Validate.validatePositive(Double.parseDouble(s))){
            System.out.println("chieu mang phai la so nguyen duong");
            s=sc.nextLine();
        }
        a=new int[Integer.parseInt(s)];
        for(int i=0;i<a.length;i++){
            System.out.println("nhap phan tu thu "+(i+1));
            a[i]=sc.nextInt();
        }
        return a;
    }
    public static int tongDuongLe(int[] a){
        int tong=0;
        for (int j : a) {
            if(j%2==1){
                tong += j;
            }

        }
        return tong;
    }
    public static String timK(int[] a){
        int k;
        System.out.println("moi ban nhap so k");
        String s=sc.nextLine();
        while(!Validate.validateInt(s)||!Validate.validatePositive(Double.parseDouble(s))){
            System.out.println("so nhap vao phai la so nguyen duong");
            s=sc.nextLine();
        }
        k= Integer.parseInt(s);
        StringBuilder ketQua= new StringBuilder();
        for(int i=0;i<a.length;i++){
            if(k==a[i]){
                ketQua.append("k co trong mang\n" + "vi tri:").append(i).append("\n");
            }
        }
        if(ketQua.isEmpty()){
            ketQua.append("K khong co trong mang");
        }
        return ketQua.toString();
    }


    public static int[] sapXepTangDan(int[] a){
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }

    public static int[] chenTangDan(int[] a){
        int p;
        System.out.println("moi ban nhap so p");
        String s=sc.nextLine();
        while(!Validate.validateInt(s)||!Validate.validatePositive(Double.parseDouble(s))){
            System.out.println("so nhap vao phai la so nguyen duong");
            s=sc.nextLine();
        }
        p= Integer.parseInt(s);
        int[] b= new int[a.length+1];
        int temp;
        int location=a.length;
        for(int i=0;i<a.length;i++) {
            if (a[i] > p ) {
                location = i;
                break;
            }
        }
        b[location]=p;
        for(int i=0;i<a.length;i++){
            if(i<location){
                b[i]=a[i];
            }
            else {
                b[i+1]=a[i];
            }
        }
        return b;
    }


    public static void main(String[] args){
        int a[]=null;
        StringBuilder stringBuilder=null;
        boolean start = true;
        while (start) {
            System.out.println("Choose what function you want to process:");
            System.out.println("1.Nhap mang a ");
            System.out.println("2.tinh tong so duong le");
            System.out.println("3.kiem tra so k trong mang");
            System.out.println("4.sap xep mang tang dan ");
            System.out.println("5.chen so p (mang van tang dan)");
            System.out.println("6.Exit");
            System.out.println("_________________________");
            sc=new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            boolean inner = true;
            while (inner) {
                switch (choice) {
                    case 1:
                        inner = false;
                        System.out.println("_________________________");
                        a=nhapMang(a);
                        System.out.println("_________________________");
                        break;
                    case 2:
                        inner = false;
                        System.out.println("_________________________");
                        if(a!=null){
                            System.out.println("tong so duong le:"+tongDuongLe(a));
                        }
                        else{
                            System.out.println("ban chua nhap mang");
                        }
                        System.out.println("_________________________");
                        break;
                    case 3:
                        inner = false;
                        System.out.println("_________________________");
                        if(a!=null){
                            System.out.println("kiem tra so k trong man:"+timK(a));
                        }
                        else{
                            System.out.println("ban chua nhap mang");
                        }
                        System.out.println("_________________________");
                        break;
                    case 4:
                        inner = false;
                        System.out.println("_________________________");
                        if(a!=null){
                            System.out.println("mang sau khi sap xep:");
                            a=sapXepTangDan(a);
                            for(int i:a){
                                System.out.print(i+" ");
                            }
                        }

                        else{
                            System.out.println("ban chua nhap mang");
                        }
                        System.out.println("\n");
                        System.out.println("_________________________");
                        break;
                    case 5:
                        inner = false;
                        System.out.println("_________________________");
                        if(a!=null){
                            a=chenTangDan(a);
                            System.out.println("mang sau khi chen");
                            for(int i:a){
                                System.out.print(i+" ");
                            }
                        }
                        else{
                            System.out.println("ban chua nhap mang");
                        }
                        System.out.println("\n");
                        System.out.println("_________________________");
                        break;
                    case 6:
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
