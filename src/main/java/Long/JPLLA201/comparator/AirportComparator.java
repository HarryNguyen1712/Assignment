package Long.JPLLA201.comparator;

import Long.JPLLA201.entities.Airport;

import java.util.Comparator;

public class AirportComparator implements Comparator<Airport> {

    @Override
    public int compare(Airport o1, Airport o2) {
        return o1.getID().compareTo(o2.getID());
    }
}
