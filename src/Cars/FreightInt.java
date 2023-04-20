package Cars;

public interface FreightInt {
    public void fillTrain(double load) throws TooManyPeopleException;
    public void emptyTrain();
    public double getCapacity();
    public double getLoaded();
}
