package Cars;

public class HeavyFreight extends Car{
    private final double weightNetto = 45;
    private double weightBrutto = weightNetto;
    private double capacity = 90;
    private final boolean electricity = false;
    private double loaded = 0;
    public HeavyFreight(String n) {
        super(n);
    }
    public double getLoaded() {
        return loaded;
    }
    public double getCapacity() {
        return capacity;
    }

    @Override
    public void fillTrain(double load) throws TooManyPeopleException {
        if(capacity >= load && load > 0){
            loaded += load;
            weightBrutto += load;
            capacity -= load;
        }else{
            throw new TooManyPeopleException("No space for such amount of load");
        }
    }
    public void emptyTrain(){
        capacity += loaded;
        loaded = 0;
        weightBrutto = weightNetto;
    }
    @Override
    public String toString() {
        return this.getName() + ", " + this.getCarId() + ", current weight: " + weightBrutto + " ";
    }
}
