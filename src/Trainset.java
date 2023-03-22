import Cars.Car;

import java.util.ArrayList;

public class Trainset {
    private final String name;
    private static int forId = 0;
    private final String idTrainset;
    private Locomotive head;
    private ArrayList<Car> cars;
    private double weight;
    private int electricalCars;
    private double speed;
    private Station globalFrom;
    private Station from;
    private Station to;
    private Station globalTo;
    Trainset(String name, Station h){
        this.name = name;
        this.globalFrom = h;
        idTrainset = "TS" + (++forId);
    }
    //getters
    public String getName() {
        return name;
    }

    public String getIdTrainset() {
        return idTrainset;
    }

    public Locomotive getHead() {
        return head;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public double getWeight() {
        return weight;
    }

    public int getElectricalCars() {
        return electricalCars;
    }

    public double getSpeed() {
        return speed;
    }

    public Station getGlobalFrom() {
        return globalFrom;
    }

    public Station getFrom() {
        return from;
    }

    public Station getTo() {
        return to;
    }

    public Station getGlobalTo() {
        return globalTo;
    }
    //setters

    public void setHead(Locomotive head) {
        this.head = head;
        weight += head.getWeight();
    }
    public void addCar(Car c) throws TooManyCarsException{
        if(cars.size() >= 10){
            throw new TooManyCarsException("There are too many cars here, we gonna launch without this");
        } else if (weight >= 1000) {
            throw new TooManyCarsException("We're too heavy, we can't go with this car");
        }else if(electricalCars >= 6){
            throw new TooManyCarsException("We have no power to join this car");
        }else{
            cars.add(c);
            weight += c.getWeightBrutto();
            if(c.isElectricity()){
                electricalCars ++;
            }
        }
    }
//    add here algorithm to find the shortest way
    public void startRide(Station dest){
        globalTo = dest;
        from = globalFrom;
    }

}
