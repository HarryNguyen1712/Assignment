package Long.JPLLA201;

import Long.JPLLA101.entities.Book;
import Long.JPLLA101.entities.Magazine;
import Long.JPLLA101.entities.Publications;
import Long.JPLLA201.Dao.AirportDao;
import Long.JPLLA201.Dao.FixedWingsDao;
import Long.JPLLA201.Dao.HelicopterDao;
import Long.JPLLA201.entities.Airport;
import Long.JPLLA201.entities.FixedWings;
import Long.JPLLA201.entities.Helicopters;
import validate.Validate;

import java.util.*;

public class AirplaneManagement {
    static Scanner scanner= new Scanner(System.in);
    static AirportDao airportDao = new AirportDao();
    static FixedWingsDao fixedWingsDao= new FixedWingsDao();
    static HelicopterDao helicopterDao= new HelicopterDao();
    public static void main(String[] args){
        List<Airport> airportList = new ArrayList<>();
        List<FixedWings> fixedWingsList = new ArrayList<>();
        List<Helicopters> helicoptersList = new ArrayList<>();
        Airport airport1= new Airport("AP00001","Da Nang",20,4,new HashSet<>(),4,new HashSet<>());
        Airport airport2= new Airport("AP00002","Ha Noi",30,4,new HashSet<>(),4,new HashSet<>());
        Airport airport3= new Airport("AP00003","Ho Chi Minh",45,4,new HashSet<>(),4,new HashSet<>());
        Airport airport4= new Airport("AP00004","Da Lat",25,4,new HashSet<>(),4,new HashSet<>());
        FixedWings fixedWings1= new FixedWings("FW00001", "BXHS54654", 500, 300, 400, "CAG", 35);
        FixedWings fixedWings2= new FixedWings("FW00002", "ASUD21348", 700, 200, 250, "LGR", 25);
        Helicopters helicopters1 = new Helicopters("RW00001", "HE57548", 200, 100,200, 200);
        Helicopters helicopters2 = new Helicopters("RW00002", "HS24654", 180, 150,250, 300);
        airportList.add(airport1);
        airportList.add(airport2);
        airportList.add(airport3);
        airportList.add(airport4);
        fixedWingsList.add(fixedWings1);
        fixedWingsList.add(fixedWings2);
        helicoptersList.add(helicopters1);
        helicoptersList.add(helicopters2);
        boolean start = true;
        while (start) {
            System.out.println("Choose what function you want to process:");
            System.out.println("1.Add new airport ");
            System.out.println("2.Add Magazine");
            System.out.println("3.Display books and maganizes");
            System.out.println("4.Add author to book");
            System.out.println("5.Display top 10 of magazines by volume");
            System.out.println(".Search book by (isbn, author, publisher)");
            System.out.println("7.Exit ");
            System.out.println("_________________________");
            scanner=new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            boolean inner = true;
            while (inner) {
                switch (choice) {
                    case 1 -> {
                        inner = false;
                        airportDao.add(new Airport(),airportList);
                        System.out.println("\n");
                        System.out.println("_________________________");
                    }
                    case 2 -> {
                        inner = false;
                        System.out.println("input ID fixed wing plane");
                        String ID= scanner.nextLine();
                        FixedWings fixedWings= fixedWingsDao.findById(ID,fixedWingsList);
                        System.out.println("input ID airport");
                        if(fixedWings==null){
                            continue;
                        }
                        String airportID= scanner.nextLine();
                        Airport airport= airportDao.findById(airportID,airportList);
                        if(airport==null){
                            continue;
                        }
                        fixedWingsDao.add(fixedWings,airport.getListOfFixedWingAirplaneID(),airport);
                    }
                    case 3 -> {
                        inner = false;
                        System.out.println("input ID helicopter");
                        String ID= scanner.nextLine();
                        Helicopters helicopters= helicopterDao.findById(ID,helicoptersList);
                        if( helicopters==null){
                            continue;
                        }
                        System.out.println("input ID airport");

                        String airportID= scanner.nextLine();
                        Airport airport= airportDao.findById(airportID,airportList);
                        if(airport==null){
                            continue;
                        }
                        helicopterDao.add(helicopters,airport.getListOfFixedWingAirplaneID());
                    }
                    case 4 -> {
                        System.out.println("input ID helicopter");
                        String ID= scanner.nextLine();
                        Helicopters helicopters= helicopterDao.findById(ID,helicoptersList);
                        if(helicopters==null){
                            continue;
                        }
                        Airport airport= airportDao.findByHelicopterId(ID,airportList);
                        helicopterDao.removeFromAirport(helicopters,airport.getListOfHelicopterID());
                        System.out.println("\n");
                        System.out.println("_________________________");
                        inner = false;

                        System.out.println("-----------------------");
                    }
                    case 5 -> {
                        System.out.println("input ID fixed wing plane");
                        String ID= scanner.nextLine();
                        FixedWings fixedWings= fixedWingsDao.findById(ID,fixedWingsList);
                        if(fixedWings==null){
                            continue;
                        }

                        Airport airport= airportDao.findByFixedWingId(ID,airportList);
                        fixedWingsDao.removeFromAirport(fixedWings,airport.getListOfFixedWingAirplaneID());
                        System.out.println("\n");
                        System.out.println("_________________________");
                        inner = false;
                    }
                    case 6 -> {
                        System.out.println("input your criteria");
                        String criteria= sc.nextLine();
                        bookDao.searchBookByISBNAuthorPublisher(criteria,bookList);
                        inner = false;
                    }
                    case 7 -> {
                        inner = false;
                        start = false;
                    }
                    default -> {
                        System.out.println("_________________________");
                        System.out.println("Wrong choice");
                        System.out.println("Try again please");
                        choice = Integer.parseInt(sc.nextLine());
                        System.out.println("_________________________");
                    }
                }
            }
        }
    }
}
