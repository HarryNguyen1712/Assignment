package Long.JPLLA201.Dao;

import Long.JPLLA201.entities.FixedWings;
import Long.JPLLA201.entities.Helicopters;

import java.util.Set;

public interface HelicopterDaoInterface {
    void add(Helicopters helicopters, Set<String> listOfHelicopterID);
    void removeFromAirport(Helicopters helicopters,Set<String> listOfFixedWingAirplaneID);

}
