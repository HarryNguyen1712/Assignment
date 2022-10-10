package Long.JPLLA201.Dao;

import Long.JPLLA201.entities.Airport;

import java.util.List;

public interface AirportDaoInterface {
    void add(Airport airport, List<Airport> airports);
    void displayAirportSortedByID(List<Airport> airports);
    void displayStatusAirportByID(Airport airport);

    Airport findById(String id,List<Airport> airports);
}
