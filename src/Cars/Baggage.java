package Cars;

public class Baggage extends Car {
    private final double weightNetto = 55;
    private double weightBrutto;
    private final double availablePlace = 30;
    private final boolean electricity = false;

    public Baggage(String n) {
        super(n);
    }
//    getters

    @Override
    public double getWeightNetto() {
        return weightNetto;
    }

    @Override
    public double getWeightBrutto() {
        return weightBrutto;
    }

    public double getAvailablePlace() {
        return availablePlace;
    }

    @Override
    public boolean isElectricity() {
        return electricity;
    }
//    funcs
    public void fillTheTrain(double s) throws TooManyPeopleException{
        if(s > availablePlace){
            throw new TooManyPeopleException("You are taking too much, this car can't fill it inside");
        }else{
            weightBrutto = weightNetto + s;
        }
    }
}
