package Cars;

public class Freight extends Car{
    private final double weightNetto = 35;
    private double weightBrutto = weightNetto;
    private double capacity = 45;
    private final boolean electricity = false;
    private double loaded = 0;
    public Freight(String n) {
        super(n);
    }
    public double getCapacity() {
        return capacity;
    }

    public double getLoaded() {
        return loaded;
    }
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
