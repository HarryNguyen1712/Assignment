package AssignmentPart1;

import java.util.Scanner;

public class bai7 {
    static Scanner sc= new Scanner(System.in);
    public static String daoChuoi(String n){
        StringBuilder output= new StringBuilder();
        StringBuilder input = new StringBuilder(n);
        for(int i=0;i<n.length();i++){
            output.append(input.toString().charAt(input.toString().length()-1-i));
        }
        return output.toString();
    }
    public static String sangChuHoa(String n){

        return n.toUpperCase();
    }

    public static String sangChuThuong(String n){

        return n.toLowerCase();
    }
    public static StringBuilder nhapChuoi(StringBuilder sb){
        System.out.print("Moi ban nhap chuoi:");
        String s=sc.nextLine();
        sb.append(s);
        return sb;
    }
    public static void tanSoKiTu(String n){
        char[] arr = n.toLowerCase().toCharArray();
        int count=1;
        int[] result= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                    arr[j]='0';
                }
            }
            result[i]=count;
            count=1;
        }
        for(int i =0;i<arr.length;i++){
            if(arr[i]!=' ' && arr[i]!='0'){
                System.out.println(arr[i]+":"+result[i]);
            }
        }
    }
    public static String tachChuoiCon(String input,int n,int m){
        return input.substring(n,m);
    }
    public static void main(String[] args){
        StringBuilder stringBuilder=null;
        boolean start = true;
        while (start) {
            System.out.println("Choose what function you want to process:");
            System.out.println("1.Nhap String ");
            System.out.println("2.In ra String dao nguoc ");
            System.out.println("3.Doi toan bo ki tu sang hoa");
            System.out.println("4.Doi toan bo ki tu sang thuong ");
            System.out.println("5.Bang tan so xuat hien ki tu");
            System.out.println("6.Exit");
            System.out.println("_________________________");
            int choice = Integer.parseInt(sc.nextLine());
            boolean inner = true;
            while (inner) {
                switch (choice) {
                    case 1:
                        inner = false;
                        stringBuilder= new StringBuilder();
                        System.out.println("_________________________");
                        nhapChuoi(stringBuilder);
                        System.out.println("_________________________");
                        break;
                    case 2:
                        inner = false;
                        System.out.println("_________________________");
                        if(stringBuilder!=null){
                            System.out.println("String dao nguoc:"+daoChuoi(stringBuilder.toString()));
                        }
                        else{
                            System.out.println("ban chua nhap chuoi");
                        }
                        System.out.println("_________________________");
                        break;
                    case 3:
                        inner = false;
                        System.out.println("_________________________");
                        if(stringBuilder!=null){
                            System.out.println("Doi toan bo ki tu sang hoa:"+sangChuHoa(stringBuilder.toString()));
                        }
                        else{
                            System.out.println("ban chua nhap chuoi");
                        }
                        System.out.println("_________________________");
                        break;
                    case 4:
                        inner = false;
                        System.out.println("_________________________");
                        if(stringBuilder!=null){
                            System.out.println("Doi toan bo ki tu sang thuong:"+sangChuThuong(stringBuilder.toString()));
                        }
                        else{
                            System.out.println("ban chua nhap chuoi");
                        }
                        System.out.println("_________________________");
                        break;
                    case 5:
                        inner = false;
                        System.out.println("_________________________");
                        if(stringBuilder!=null){
                            System.out.println("Bang tan so xuat hien ki tu:");
                            tanSoKiTu(stringBuilder.toString());
                        }
                        else{
                            System.out.println("ban chua nhap chuoi");
                        }
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
