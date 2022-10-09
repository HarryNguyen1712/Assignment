package Long.JPLLA201.Dao;

import Long.JPLLA201.entities.Airport;
import Long.JPLLA201.entities.FixedWings;
import Long.JPLLA201.entities.Helicopters;

import java.util.List;
import java.util.Set;

public class HelicopterDao implements  HelicopterDaoInterface {
    @Override
    public void add(Helicopters helicopters, Set<String> listOfFixedWingAirplaneID) {
        if(listOfFixedWingAirplaneID.stream().noneMatch(s -> s.equalsIgnoreCase(helicopters.getId()))){
            listOfFixedWingAirplaneID.add(helicopters.getId());
        }
        else System.out.println("Airplane existed");
    }
    @Override
    public void removeFromAirport(Helicopters helicopters,Set<String> listOfFixedWingAirplaneID ){
        if(listOfFixedWingAirplaneID.stream().anyMatch(s -> s.equalsIgnoreCase(helicopters.getId()))){
            listOfFixedWingAirplaneID.remove(helicopters.getId());
        }
        else System.out.println("Airplane is not at this airport");
    }
    public void displayAllHelicopters(List<Helicopters> helicopters, List<Airport> airports){
        for(Helicopters helicopters1: helicopters){
            StringBuilder string= new StringBuilder(helicopters1.toString());
            for(Airport airport:airports){
                if(airport.getListOfFixedWingAirplaneID().stream().anyMatch(s -> helicopters1.getId().equalsIgnoreCase(s))){
                    string.append("\nAirport ID").append(airport.getID()).append("\nAirport Name").append(airport.getName());
                }
            }
            System.out.println(string.toString());
            System.out.println("------------------");
        }
    }

    public Helicopters findById(String id, List<Helicopters> helicoptersList) {
        for(Helicopters helicopters: helicoptersList){
            if(helicopters.getId().equalsIgnoreCase(id)){
                return helicopters;
            }
        }
        System.out.println("we dont have that plane");
        return null;
    }
}
