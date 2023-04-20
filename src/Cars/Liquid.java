package Cars;

public class Liquid extends Car implements FreightInt{
    private final double weightNetto = 25;
    private double weightBrutto = weightNetto;
    private final boolean electricity = false;
    private double capacity = 30;
    private double loaded = 0;
    public Liquid(String n) {
        super(n);
    }

    @Override
    public double getCapacity() {
        return capacity;
    }

    @Override
    public double getLoaded() {
        return 0;
    }
    @Override
    public void fillTrain(double load) throws TooManyPeopleException{
        if(capacity >= load && load > 0){
            loaded += load;
            weightBrutto += load;
            capacity -= load;
        }
        else{
            throw new TooManyPeopleException("No space for such amount of load");
        }
    }
    @Override
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
