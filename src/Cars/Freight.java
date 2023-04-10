package Cars;

public class Freight extends Car{
    private final double weightNetto = 20;
    private double weightBrutto = weightNetto;
    private final double capacity = 45;
    private final boolean electricity = false;
    private double loaded;
    public Freight(String n) {
        super(n);
    }

    @Override
    public double getWeightNetto() {
        return weightNetto;
    }

    @Override
    public double getWeightBrutto() {
        return weightBrutto;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public boolean isElectricity() {
        return electricity;
    }

    public double getLoaded() {
        return loaded;
    }
    public void fillTheTrain(double load) throws TooManyPeopleException{
        if(capacity >= load){
            this.loaded = load;
            weightBrutto += load;
        }
        else{
            throw new TooManyPeopleException("No space for such amount of load");
        }
    }
}
