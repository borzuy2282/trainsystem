package Cars;

public class Refrigerated extends Car implements FreightInt{
    private final boolean electricity = true;
    private double weightNetto = 25;
    private double weightBrutto = weightNetto;
    private double capacity = 30;
    private double loaded = 0;

    public Refrigerated(String n) {
        super(n);
    }

    @Override
    public double getCapacity() {
        return capacity;
    }

    @Override
    public double getLoaded() {
        return loaded;
    }

    @Override
    public void fillTrain(double load) throws TooManyPeopleException {
        if(load > capacity || load <= 0){
            throw new TooManyPeopleException("No space for such amount of load");
        }else{
            loaded += load;
            capacity -= load;
            weightBrutto += load;
        }
    }

    @Override
    public void emptyTrain() {
        capacity += loaded;
        loaded = 0;
        weightBrutto = weightNetto;
    }
    @Override
    public String toString() {
        return this.getName() + ", " + this.getCarId() + ", current weight: " + weightBrutto + " ";
    }
}
