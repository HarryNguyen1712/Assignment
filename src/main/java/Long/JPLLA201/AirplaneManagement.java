package Long.JPLLA201;

import Long.JPLLA101.entities.Book;
import Long.JPLLA101.entities.Magazine;
import Long.JPLLA101.entities.Publications;
import Long.JPLLA201.Dao.AirportDao;
import Long.JPLLA201.Dao.FixedWingsDao;
import Long.JPLLA201.Dao.HelicopterDao;
import Long.JPLLA201.Enum.FixedWingsTypeEnum;
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
            System.out.println("2.Add fixed wing to airport");
            System.out.println("3.Add helicopter to airport");
            System.out.println("4.Remove helicopter from airport");
            System.out.println("5.Remove fixed wing from airport");
            System.out.println("6.Change plane type and min needed runway size of fixed wing airplane");
            System.out.println("7.Display list of all airport information, sorted by airport ID");
            System.out.println("8.Display the status of one airport, selected by airport ID");
            System.out.println("9.Display list of all fixed wing airplanes with its parking airport ID and name");
            System.out.println("10.Display list of all helicopters with its parking airport ID and name");
            System.out.println("11.Exit ");
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
                        String ID= null;
                        FixedWings fixedWings;
                        String airportID;
                        Airport airport;
                        do{
                            System.out.println("input ID fixed wing plane");
                            ID=scanner.nextLine();
                            fixedWings= fixedWingsDao.findById(ID,fixedWingsList);
                        }
                        while(!Validate.validatePrefix(new FixedWings(),ID)||fixedWings==null);
                        do{
                        System.out.println("input ID airport");
                        airportID= scanner.nextLine();
                        airport = airportDao.findById(airportID,airportList);

                        }while (!Validate.validatePrefix(new Airport(), airportID)||airport==null);

                        fixedWingsDao.add(fixedWings,airport.getListOfFixedWingAirplaneID(),airport);
                    }
                    case 3 -> {
                        inner = false;
                        String ID=null;
                        Helicopters helicopters;
                        do{
                            System.out.println("input ID helicopter");
                            ID= scanner.nextLine();
                            helicopters= helicopterDao.findById(ID,helicoptersList);
                        }
                        while(!Validate.validatePrefix(new Helicopters(), ID)||helicopters==null);
                        String airportID;
                        Airport airport;
                        do{
                            System.out.println("input ID airport");
                            airportID= scanner.nextLine();
                            airport = airportDao.findById(airportID,airportList);

                        }while (!Validate.validatePrefix(new Airport(), airportID)||airport==null);
                        helicopterDao.add(helicopters,airport.getListOfFixedWingAirplaneID());
                    }
                    case 4 -> {
                        String ID=null;
                        Helicopters helicopters;
                        do{
                            System.out.println("input ID helicopter");
                            ID= scanner.nextLine();
                            helicopters= helicopterDao.findById(ID,helicoptersList);
                        }
                        while(!Validate.validatePrefix(new Helicopters(), ID)||helicopters==null);
                        Airport airport= airportDao.findByHelicopterId(ID,airportList);
                        helicopterDao.removeFromAirport(helicopters,airport.getListOfHelicopterID());
                        System.out.println("\n");
                        System.out.println("_________________________");
                        inner = false;

                        System.out.println("-----------------------");
                    }
                    case 5 -> {
                        String ID= null;
                        FixedWings fixedWings;
                        do{
                            System.out.println("input ID fixed wing plane");
                            ID=scanner.nextLine();
                            fixedWings= fixedWingsDao.findById(ID,fixedWingsList);
                        }
                        while(!Validate.validatePrefix(new FixedWings(),ID)||fixedWings==null);

                        Airport airport= airportDao.findByFixedWingId(ID,airportList);
                        fixedWingsDao.removeFromAirport(fixedWings,airport.getListOfFixedWingAirplaneID());
                        System.out.println("\n");
                        System.out.println("_________________________");
                        inner = false;
                    }
                    case 6 -> {
                        String ID= null;
                        FixedWings fixedWings;
                        do{
                            System.out.println("input ID fixed wing plane");
                            ID=scanner.nextLine();
                            fixedWings= fixedWingsDao.findById(ID,fixedWingsList);
                        }
                        while(!Validate.validatePrefix(new FixedWings(),ID)||fixedWings==null);
                        boolean temp1=true;
                        String planeType=null;
                        do{
                            System.out.println("input new plane type:(CAG-LGR-PRV) ");
                            planeType= scanner.nextLine();

                            switch (planeType){
                                case "CAG"-> {
                                    fixedWings.setPlaneType(FixedWingsTypeEnum.CAG);
                                    temp1=false;
                                }
                                case "LGR"->{
                                    fixedWings.setPlaneType(FixedWingsTypeEnum.LGR);
                                    temp1=false;
                                }
                                case "PRV"->{
                                    fixedWings.setPlaneType(FixedWingsTypeEnum.PRV);
                                    temp1=false;
                                }
                                default -> {
                                    System.out.println("wrong input");
                                }
                            }
                        }
                        while(temp1);
                        System.out.println("input min needed runway size of fixed wing airplane");
                        int minNeededRunwaySize= Integer.parseInt(scanner.nextLine());
                        fixedWingsDao.changePlaneTypeAndMinNeededRunwaySize(fixedWings,planeType,minNeededRunwaySize);
                        inner = false;
                    }
                    case 7 -> {
                        inner = false;

                        airportDao.displayAirportSortedByID(airportList);
                    }
                    case 8 -> {
                        inner = false;
                        Airport airport;
                        while(true){
                            System.out.println("input ID airport");
                            String airportID= scanner.nextLine();
                            airport= airportDao.findById(airportID,airportList);
                            if(airport!=null){
                                break;
                            }
                            else System.out.println("airport doesn't exist");
                        }
                        airportDao.displayStatusAirportByID(airport);
                    }
                    case 9 -> {
                        inner = false;
                        fixedWingsDao.displayAllFixedWingsPlane(fixedWingsList,airportList);
                    }
                    case 10 -> {
                        inner = false;
                        helicopterDao.displayAllHelicopters(helicoptersList,airportList);
                    }
                    case 11 -> {
                        inner = false;
                        start = false;
                    }
                    default -> {
                        System.out.println("_________________________");
                        System.out.println("Wrong choice");
                        System.out.println("Try again please");
                        choice = Integer.parseInt(scanner.nextLine());
                        System.out.println("_________________________");
                    }
                }
            }
        }
    }
}
