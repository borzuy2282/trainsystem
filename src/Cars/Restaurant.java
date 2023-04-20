package Cars;

public class Restaurant extends Car {
    private final double weightNetto = 35;
    private double weightBrutto = weightNetto;
    private final boolean electricity = true;
    private int staff = 0;
    private int place = 15;

    public Restaurant(String n) {
        super(n);
    }
//    getters


    public int getStaff() {
        return staff;
    }

    public int getPlace() {
        return place;
    }

    //    funcs

    @Override
    public void fillTrain(int i) throws TooManyPeopleException {
        if (i > place || i <= 0){
            throw new TooManyPeopleException("Not right amount of staff");
        }else{
            staff += i;
            place -= i;
            weightBrutto += i * 0.1;
        }
    }

    @Override
    public void emptyTrain() {
        place += staff;
        staff = 0;
        weightBrutto = weightNetto;
    }
    @Override
    public String toString() {
        return this.getName() + ", " + this.getCarId() + ", current weight: " + weightBrutto + " ";
    }
}
