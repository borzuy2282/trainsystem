package Cars;
public class Passenger extends Car{
    private final double weightNetto = 75;
    private double weightBrutto;
    private final int places = 100;
    private int people;
    private final  boolean elctricity = true;


    public Passenger(String n){
        super(n);
    }
    //getters
    @Override
    public double getWeightNetto() {
        return weightNetto;
    }

    @Override
    public double getWeightBrutto() {
        return weightBrutto;
    }

    public int getPlaces() {
        return places;
    }

    public int getPeople() {
        return people;
    }

    public boolean isElctricity() {
        return elctricity;
    }
//    funcs:
    public void fillTheTrain(int p) throws TooManyPeopleException {
        if(places >= p){
            people = p;
            weightBrutto = weightNetto + people;
        }else{
            throw new TooManyPeopleException("No way we can fit those people, try to re-sell them tickets.");
        }

    }
}
