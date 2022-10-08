package Short.JPLSA101;

import Short.JPLSA101.entities.Sedan;
import Short.JPLSA101.entities.Car;
import Short.JPLSA101.entities.Ford;
import Short.JPLSA101.entities.Truck;

import java.util.ArrayList;
import java.util.List;

public class APP {
    public static void main(String[] args){
        Sedan sedan =new Sedan(200,2000,"black",20);
        Sedan sedan1 =new Sedan(300,2100,"red",20);
        Sedan sedan2 =new Sedan(300,3000,"green",20);
        List<Car> carList= new ArrayList<>();
        carList.add(sedan);
        carList.add(sedan1);
        carList.add(sedan2);
        Ford ford =new Ford(200,2000,"black",2022,200);
        Ford ford1 =new Ford(300,3000,"white",2022,150);
        Ford ford2 =new Ford(400,5000,"gold",2022,300);
        carList.add(ford);
        carList.add(ford1);
        carList.add(ford2);
        Truck Truck =new Truck(220,2000,"black",600);
        Truck Truck1 =new Truck(300,2500,"black",600);
        Truck Truck2 =new Truck(400,3000,"black",600);
        carList.add(Truck);
        carList.add(Truck1);
        carList.add(Truck2);
        for(Car car: carList){
            System.out.println("Type:"+car.getClass().getSimpleName()+",sale price:"+car.getSalePrice());
        }
    }
}
