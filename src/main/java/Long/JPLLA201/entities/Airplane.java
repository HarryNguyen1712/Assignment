package Long.JPLLA201.entities;

import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Airplane {

    private String id;
    @Size(max=40, message = "model size is maximum 40 characters")
    private String model;
    private int cruiseSpeed;
    private int emptyWeight;
    private int maxTakeoffWeight;

    public Airplane() {
    }

    public Airplane(String id, String model, int cruiseSpeed, int emptyWeight, int maxTakeoffWeight) {
        this.id = id;
        this.model = model;
        this.cruiseSpeed = cruiseSpeed;
        this.emptyWeight = emptyWeight;
        this.maxTakeoffWeight = maxTakeoffWeight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(int cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public int getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(int emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public int getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public void setMaxTakeoffWeight(int maxTakeoffWeight) {
        this.maxTakeoffWeight = maxTakeoffWeight;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", cruiseSpeed=" + cruiseSpeed +
                ", emptyWeight=" + emptyWeight +
                ", maxTakeoffWeight=" + maxTakeoffWeight;
    }
}
