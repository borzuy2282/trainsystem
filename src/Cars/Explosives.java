package Cars;

public class Explosives extends Car implements HeavyFreightInt{
    private final double weightNetto = 45;
    private double weightBrutto = weightNetto;
    private double capacity = 50;
    private final boolean electricity = false;
    private double loaded = 0;
    public Explosives(String n) {
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
    public void fillTrain(double load) throws TooManyPeopleException{
        if(load > capacity){
            throw new TooManyPeopleException("No space for such amount of load");
        }else{
            loaded = load;
            weightBrutto += loaded;
            capacity -= loaded;
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
