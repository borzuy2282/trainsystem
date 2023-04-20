package Cars;

public class Post extends Car{
    private final double weightNetto = 25;
    private double weightBrutto = weightNetto;
    private final boolean electricity = true;
    private int crew = 0;
    private int place = 10;

    public Post(String n) {
        super(n);
    }
//    getters

    public int getPlace(){return place;}

    public int getCrew() {
        return crew;
    }
//    funcs
    public void fillTrain(int n) throws TooManyPeopleException{
        if(n <= place && n >= 1){
            crew += n;
            place -= n;
            weightBrutto += (n * 0.1);
        }else{
            throw new TooManyPeopleException("It's not the proper number of people to make a crew, try again.");
        }
    }

    @Override
    public void emptyTrain() {
        place += crew;
        crew = 0;
        weightBrutto = weightNetto;
    }
    @Override
    public String toString() {
        return this.getName() + ", " + this.getCarId() + ", current weight: " + weightBrutto + " ";
    }
}
