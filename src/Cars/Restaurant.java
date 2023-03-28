package Cars;

public class Restaurant extends Car {
    private final double weightNetto = 40;
    private double weightBrutto = weightNetto;
    private final boolean electricity = true;
    private int tables;
    private int waiters;
    private int cookers;

    Restaurant(String n) {
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

    public int getTables() {
        return tables;
    }

    public int getWaiters() {
        return waiters;
    }

    public int getCookers() {
        return cookers;
    }
//    funcs
    public void addWaiters(int waiters) throws TooManyPeopleException{
        if(waiters <= 15 && waiters >= 5){
            this.waiters = waiters;
            weightBrutto += waiters * 0.1;
        }else{
            throw new TooManyPeopleException("Not an amount of waiters to serve people their food without any problems!");
        }
    }
    public void addCookers(int cookers) throws TooManyPeopleException{
        if(cookers <= 5 && cookers >= 2){
            this.cookers = cookers;
            weightBrutto += cookers * 0.1;
        }else{
            throw new TooManyPeopleException("Bad amount of cookers, people won't get their food as tasty as they wanted and not as fast as they wanted.");
        }
    }
}
