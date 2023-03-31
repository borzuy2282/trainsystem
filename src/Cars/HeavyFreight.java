package Cars;

public class HeavyFreight extends Freight{
    private final double weightNetto = 40;
    private double weightBrutto = weightNetto;
    private final double capacity = 90;
    private final boolean electricity = false;
    private double loaded;
    HeavyFreight(String n) {
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

    @Override
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

    @Override
    public void fillTheTrain(double load) throws TooManyPeopleException {
        if(capacity >= load){
            this.loaded = load;
            weightBrutto += load;
        }else{
            throw new TooManyPeopleException("No space for such amount of load");
        }
    }
}
