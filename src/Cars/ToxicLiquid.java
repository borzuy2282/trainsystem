package Cars;

public class ToxicLiquid extends Car implements HeavyFreightInt{
    private Liquid liquid;
    private final double weightNetto = 35;
    private double weightBrutto = weightNetto;
    private final boolean electricity = false;
    private double capacity = 65;
    private double loaded = 0;
    public ToxicLiquid(String n) {
        super(n);
        liquid = new Liquid(n);
    }

    @Override
    public double getCapacity() {
        return 0;
    }

    @Override
    public double getLoaded() {
        return 0;
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
