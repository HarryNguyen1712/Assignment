package Long.JPLLA201.entities;

import Long.JPLLA201.Enum.FixedWingsTypeEnum;

public class FixedWings extends  Airplane  {
    private FixedWingsTypeEnum planeType;
    private int minNeededRunwaySize;
    private final String flyMethod="fixed wing";

    public FixedWings() {
    }

    public FixedWings(String id, String model, int cruiseSpeed, int emptyWeight, int maxTakeoffWeight, String planeType, int minNeededRunwaySize) {
        super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
        this.planeType = FixedWingsTypeEnum.valueOf(planeType);
        this.minNeededRunwaySize = minNeededRunwaySize;
    }

    public FixedWingsTypeEnum getPlaneType() {
        return planeType;
    }

    public void setPlaneType(FixedWingsTypeEnum planeType) {
        this.planeType = planeType;
    }

    public int getMinNeededRunwaySize() {
        return minNeededRunwaySize;
    }

    public void setMinNeededRunwaySize(int minNeededRunwaySize) {
        this.minNeededRunwaySize = minNeededRunwaySize;
    }

    public String getFlyMethod() {
        return flyMethod;
    }



    @Override
    public String toString() {
        return super.toString()+",planeType=" + planeType +
                ", minNeededRunwaySize=" + minNeededRunwaySize +
                ", flyMethod='" + flyMethod + '\'' +
                '}';
    }
}
