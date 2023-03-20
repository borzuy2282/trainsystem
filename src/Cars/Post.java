package Cars;

public class Post extends Car{
    private final double weightNetto = 50;
    private double weightBrutto;
    private final boolean electricity = true;
    private int crew;

    Post(String n) {
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

    @Override
    public boolean isElectricity() {
        return electricity;
    }

    public int getCrew() {
        return crew;
    }
//    funcs
    public void addCrew(int n) throws TooManyPeopleException{
        if(n <= 10 && n >= 3){
            crew = n;
            weightBrutto = weightNetto + (n * 0.1);
        }else{
            throw new TooManyPeopleException("It's not the proper number of people to create a crew, so please, change the number of people here.");
        }
    }
}
