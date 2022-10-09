package Long.JPLLA201.Dao;

import Long.JPLLA201.entities.Airport;
import Long.JPLLA201.entities.FixedWings;
import Long.JPLLA201.entities.Helicopters;

import java.util.Set;

public interface FixedWingsDaoInterface {
    void add(FixedWings fixedWings, Set<String> listOfFixedWingAirplaneID, Airport airport);
    void changePlaneTypeAndMinNeededRunwaySize(FixedWings fixedWings,String planeType, int minNeededRunwaySize);
    void removeFromAirport(FixedWings fixedWings, Set<String> listOfFixedWingAirplaneID);
}
