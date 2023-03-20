import java.util.ArrayList;

abstract public class Car {
    private String name;
    public static int forId = 0;
    private String carId;
    private double weightNetto;
    private double weightBrutto;
    private boolean electricity;
    Car(String n){
        this.name = n;
        this.carId = "C" + (++forId);
    }
    //getters:
    public String getName() {
        return name;
    }

    public String getCarId() {
        return carId;
    }

    public double getWeightNetto() {
        return weightNetto;
    }

    public double getWeightBrutto() {
        return weightBrutto;
    }

    public boolean isElectricity() {
        return electricity;
    }
}
