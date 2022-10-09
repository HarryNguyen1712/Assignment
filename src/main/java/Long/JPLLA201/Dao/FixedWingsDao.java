package Long.JPLLA201.Dao;

import Long.JPLLA201.Enum.FixedWingsTypeEnum;
import Long.JPLLA201.entities.Airport;
import Long.JPLLA201.entities.FixedWings;
import Long.JPLLA201.entities.Helicopters;
import validate.Validate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class FixedWingsDao  implements  FixedWingsDaoInterface {

    @Override
    public void add(FixedWings fixedWings, Set<String> listOfFixedWingAirplaneID, Airport airport) {
        if(listOfFixedWingAirplaneID.stream().noneMatch(s -> s.equalsIgnoreCase(fixedWings.getId()))&& Validate.validateRunwaySize(fixedWings,airport)){
            listOfFixedWingAirplaneID.add(fixedWings.getId());
        }
        else if(!Validate.validateRunwaySize(fixedWings,airport)){
            System.out.println("runway size excesses the airport runway size");
        }
        else if(listOfFixedWingAirplaneID.stream().anyMatch(s -> s.equalsIgnoreCase(fixedWings.getId()))){
            System.out.println("Airplane existed");
        }
        else {
            System.out.println("Airplane existed and runway size excesses the airport runway size");
        }
    }

    @Override
    public void changePlaneTypeAndMinNeededRunwaySize(FixedWings fixedWings, String planeType, int minNeededRunwaySize) {
        try{
            fixedWings.setPlaneType(FixedWingsTypeEnum.valueOf(planeType));
            fixedWings.setMinNeededRunwaySize(minNeededRunwaySize);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeFromAirport(FixedWings fixedWings, Set<String> listOfFixedWingAirplaneID) {
        if(listOfFixedWingAirplaneID.stream().anyMatch(s -> s.equalsIgnoreCase(fixedWings.getId()))){
            listOfFixedWingAirplaneID.remove(fixedWings.getId());
        }
        else System.out.println("Airplane is not at this airport");
    }
    public void displayAllFixedWingsPlane(List<FixedWings> fixedWings, List<Airport> airports){
        for(FixedWings fixedWings1: fixedWings){
            StringBuilder string= new StringBuilder(fixedWings1.toString());
            for(Airport airport:airports){
                if(airport.getListOfFixedWingAirplaneID().stream().anyMatch(s -> fixedWings1.getId().equalsIgnoreCase(s))){
                    string.append("\nAirport ID").append(airport.getID()).append("\nAirport Name").append(airport.getName());
                }
            }
            System.out.println(string.toString());
            System.out.println("------------------");
        }
    }
    public FixedWings findById(String ID,List<FixedWings> fixedWingsList){
        for(FixedWings fixedWings: fixedWingsList){
            if(fixedWings.getId().equalsIgnoreCase(ID)){
                return fixedWings;
            }
        }
        System.out.println("we dont have that plane");
        return null;
    }
}
