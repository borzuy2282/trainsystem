package Cars;

public class Baggage extends Car {
    private final double weightNetto = 25;
    private double weightBrutto = weightNetto;
    private double availablePlace = 30;
    private final boolean electricity = false;
    private double load = 0;

    public Baggage(String n) {
        super(n);
    }
//    funcs

    public double getLoad() {
        return load;
    }

    public double getAvailablePlace() {
        return availablePlace;
    }

    public void fillTrain(double s) throws TooManyPeopleException{
        if(s > availablePlace || s <= 0){
            throw new TooManyPeopleException("You are taking too much, this car can't fill it inside");
        }else{
            load += s;
            availablePlace -= s;
            weightBrutto += s;
        }
    }
    public void emptyTrain(){
        availablePlace += load;
        load = 0;
        weightBrutto = weightNetto;
    }
    @Override
    public String toString() {
        return this.getName() + ", " + this.getCarId() + ", current weight: " + weightBrutto + " ";
    }
}
