package Cars;

abstract public class Car {
    private final String name;
    public static int forId = 0;
    private final String carId;
    private double weightNetto;
    private double weightBrutto = weightNetto;
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
//funcs
    @Override
    public String toString() {
        return name + ", " + carId + ", current weight: " + weightBrutto;
    }
    public void fillTrain(int i) throws TooManyPeopleException{
    }
    public void fillTrain(double i) throws TooManyPeopleException{
    }
    public void emptyTrain(){
    }
}

