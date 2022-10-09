package Long.JPLLA201.entities;

public class Helicopters extends Airplane {
    private int range;
    private final String flyMethod="rotated wing";

    public Helicopters() {
    }

    public Helicopters(String id, String model, int cruiseSpeed, int emptyWeight, int maxTakeoffWeight, int range) {
        super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getFlyMethod() {
        return flyMethod;
    }

    @Override
    public String toString() {
        return super.toString()+
                ",range=" + range +
                ", flyMethod='" + flyMethod + '\'' +
                '}';
    }

}
