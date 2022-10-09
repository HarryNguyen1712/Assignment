package Long.JPLLA201.Dao;

import Long.JPLLA201.comparator.AirportComparator;
import Long.JPLLA201.entities.Airport;
import validate.Validate;

import java.time.LocalDate;
import java.util.*;

public class AirportDao implements  AirportDaoInterface {
    Scanner scanner=new Scanner(System.in);
    @Override
    public void add(Airport airport, List<Airport>airports) {
        String ID;
        while(true){
            System.out.println("Input ID:");
            ID= scanner.nextLine();
            if(Validate.validateID(Collections.singletonList(airports),ID) ){
               System.out.println("ID existed");
            }
            else if(Validate.validateLengthString(ID)||Validate.validatePrefix(ID)) {

                    System.out.println("invalid format");

            }
            else break;
        }

        System.out.println("Input name:");
        String name= scanner.nextLine();
        System.out.println("Input runaway size:");
        int runawaySize = Integer.parseInt(scanner.nextLine());
        System.out.println("Input max fixed wing parking place:");
        int maxFixedWingParkingPlace= Integer.parseInt(scanner.nextLine());
        System.out.println("Input max rotated wing parking place:");
        int maxRotatedWingParkingPlace= Integer.parseInt(scanner.nextLine());

        airport.setID(ID);
        airport.setName(name);
        airport.setRunwaySize(runawaySize);
        airport.setMaxFixedWingParkingPlace(maxFixedWingParkingPlace);
        airport.setMaxRotatedWingParkingPlace(maxRotatedWingParkingPlace);
        airport.setListOfFixedWingAirplaneID(new HashSet<>());
        airport.setListOfHelicopterID(new HashSet<>());
        airports.add(airport);
    }

    @Override
    public void displayAirportSortedByID(List<Airport> airports) {
        airports.sort(new AirportComparator());
        airports.forEach(airport -> System.out.println(airport.toString()));
    }

    @Override
    public void displayStatusAirportByID(String id,List<Airport> airports) {
        Airport airport= findById(id,airports);
        if(airport!=null){
            System.out.println(airport.toString());
        }
        else System.out.println("airport doesn't exist");
    }

    @Override
    public Airport findById(String id,List<Airport> airports) {
       Optional<Airport> airport1=airports.stream().filter(airport -> airport.getID().equalsIgnoreCase(id)).findFirst();
        return airport1.orElse(null);
    }

    public Airport findByFixedWingId(String id, List<Airport> airports ){
        for(Airport airport: airports){
            if(airport.getListOfFixedWingAirplaneID().stream().anyMatch(s -> s.equalsIgnoreCase(id))){
                return airport;
            }
        }
        return null;
    }
    public Airport findByHelicopterId(String id, List<Airport> airports ){
        for(Airport airport: airports){
            if(airport.getListOfHelicopterID().stream().anyMatch(s -> s.equalsIgnoreCase(id))){
                return airport;
            }
        }
        return null;
    }
}
