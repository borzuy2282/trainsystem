package Cars;
public class Passenger extends Car{
    private final double weightNetto = 75;
    private double weightBrutto = weightNetto;
    private int freePlaces = 100;
    private int people = 0;
    private final  boolean electricity = true;


    public Passenger(String n){
        super(n);
    }
    //getters
    public int getPlaces() {
        return freePlaces;
    }

    public int getPeople() {
        return people;
    }
//    funcs:
    public void fillTrain(int p) throws TooManyPeopleException {
        if(freePlaces >= p && p > 0){
            people += p;
            freePlaces -= p;
            weightBrutto += people * 0.1;
        }else{
            throw new TooManyPeopleException("No way we can fit those people, try to re-sell them tickets.");
        }
    }
    public void fillTrain(double p){
        throw new IllegalArgumentException("How can you get half of a person?");
    }
    public void emptyTrain(){
        freePlaces += people;
        people = 0;
        weightBrutto = weightNetto;
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getCarId() + ", current weight: " + weightBrutto + " ";
    }
}
