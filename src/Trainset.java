import Cars.Car;

import java.util.ArrayList;

public class Trainset extends Thread {
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
//    public String getName() {
//        return name;
//    }

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

    public void setSpeed(double speed) {
        this.speed = speed;
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
    public void run(){
        this.startRide(this.getTo());
        Rail tmp = new Rail(this.from, this.to);
        this.setSpeed(10);
        while(tmp.getLenLeft() > 0){
            System.out.println(tmp.getLenLeft());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int temp = (int) (Math.random() * 100);
            if(temp > 50){
                if(this.getSpeed() + this.getSpeed() * 0.03 < 200){
                    this.setSpeed(this.getSpeed() + this.getSpeed() * 0.03);
                }else{
                    try {
                        throw new RailroadHazardException("Too much, we won't speed up");
                    } catch (RailroadHazardException e) {
                        throw new RuntimeException(e);
                    }
                }
            }else{
                if(this.getSpeed() - this.getSpeed() * 0.03 > 0) {
                    this.setSpeed(this.getSpeed() - this.getSpeed() * 0.03);
                }else{
                    try{
                        throw new RailroadHazardException("We can't stop, we will go on current speed");
                    } catch (RailroadHazardException e){
                        throw new RuntimeException(e);
                    }
                }
            }

            tmp.setLenLeft(tmp.getLenLeft() - this.getSpeed());
        }
        System.out.println("We're here!");
    }
}

