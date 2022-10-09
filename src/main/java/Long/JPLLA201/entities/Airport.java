package Long.JPLLA201.entities;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

public class Airport {
    @Size(min=7, max=7,message = "invalid ID")
    private String ID;
    private String name;
    private int runwaySize;
    private int maxFixedWingParkingPlace;
    private Set<String> listOfFixedWingAirplaneID;
    private int maxRotatedWingParkingPlace;
    private Set<String> listOfHelicopterID;

    public Airport() {
    }

    public Airport(String ID, String name, int runwaySize, int maxFixedWingParkingPlace, Set<String> listOfFixedWingAirplaneID, int maxRotatedWingParkingPlace, Set<String> listOfHelicopterID) {
        this.ID = ID;
        this.name = name;
        this.runwaySize = runwaySize;
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
        this.listOfFixedWingAirplaneID = listOfFixedWingAirplaneID;
        this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
        this.listOfHelicopterID = listOfHelicopterID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunwaySize() {
        return runwaySize;
    }

    public void setRunwaySize(int runwaySize) {
        this.runwaySize = runwaySize;
    }

    public int getMaxFixedWingParkingPlace() {
        return maxFixedWingParkingPlace;
    }

    public void setMaxFixedWingParkingPlace(int maxFixedWingParkingPlace) {
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
    }

    public Set<String> getListOfFixedWingAirplaneID() {
        return listOfFixedWingAirplaneID;
    }

    public void setListOfFixedWingAirplaneID(Set<String> listOfFixedWingAirplaneID) {
        this.listOfFixedWingAirplaneID = listOfFixedWingAirplaneID;
    }

    public int getMaxRotatedWingParkingPlace() {
        return maxRotatedWingParkingPlace;
    }

    public void setMaxRotatedWingParkingPlace(int maxRotatedWingParkingPlace) {
        this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
    }

    public Set<String> getListOfHelicopterID() {
        return listOfHelicopterID;
    }

    public void setListOfHelicopterID(Set<String> listOfHelicopterID) {
        this.listOfHelicopterID = listOfHelicopterID;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", runwaySize=" + runwaySize +
                ", maxFixedWingParkingPlace=" + maxFixedWingParkingPlace +
                ", listOfFixedWingAirplaneID=" + listOfFixedWingAirplaneID +
                ", maxRotatedWingParkingPlace=" + maxRotatedWingParkingPlace +
                ", listOfHelicopterID=" + listOfHelicopterID +
                '}';
    }
}
