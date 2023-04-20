package Cars;

public interface HeavyFreightInt {
    public void fillTrain(double load) throws TooManyPeopleException;
    public void emptyTrain();
    public double getCapacity();
    public double getLoaded();
}
