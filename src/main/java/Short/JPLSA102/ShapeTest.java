package Short.JPLSA102;

import Short.JPLSA102.entities.Rectangle;

import java.sql.ResultSet;
import java.util.Scanner;

public class ShapeTest {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("input length of array");
        int n= Integer.parseInt(sc.nextLine());
        Rectangle[] rectangles= new Rectangle[n];
        for(int i=0;i<rectangles.length;i++){
            System.out.print("input length of rectangle ["+i+"]:");
            int l=Integer.parseInt(sc.nextLine());
            System.out.print("\ninput width of rectangle ["+i+"]:");
            int w=Integer.parseInt(sc.nextLine());
            rectangles[i]=new Rectangle(l,w);
            System.out.println("---------------");
        }
        int maxarea=rectangles[0].calculateArea();
        for(Rectangle rectangle:rectangles){
            int area=rectangle.calculateArea();
            if(area>maxarea){
                maxarea=area;
            }
        }
        System.out.println("Max area:"+maxarea);
        int minperimeter=rectangles[0].calculatePerimeter();
        for(Rectangle rectangle:rectangles){
            int perimeter=rectangle.calculatePerimeter();
            if(minperimeter>perimeter){
                minperimeter=perimeter;
            }
        }
        System.out.println("Min perimeter:"+minperimeter);
    }
}
