import java.util.ArrayList;

public class Locomotive {
    //variables:
    private String name;
    private static double weight = 100;
    private Station home;
    private double currentSpeed;
    private Station globalFrom;
    private Station from;
    private Station to;
    private Station globalTo;
    private String idLocomotive;
    private static int forId = 0;
//    private ArrayList<Cars.Car> cars;

    //constructor:
    Locomotive(String n, Station h){
        this.name = n;
        this.home = h;
        this.from = h;
        this.idLocomotive = "L" + (++forId);
    }
    //getters:
    public String getName() {
        return name;
    }

    public String getIdLocomotive() {
        return idLocomotive;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Station getHome() {
        return home;
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

    public double getWeight() {
        return weight;
    }

    public Station getGlobalTo() {
        return globalTo;
    }
    //setters:
    public void setGlobalFrom(Station globalFrom) {
        this.globalFrom = globalFrom;
    }

    public void setFrom(Station from) {
        this.from = from;
    }

    public void setTo(Station to) {
        this.to = to;
    }

    public void setGlobalTo(Station globalTo) {
        this.globalTo = globalTo;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    //funcs:
//    public void addCar(Cars.Car car) throws TooManyCarsException {
//        if(cars.size() < 10){
//            this.cars.add(car);
//        }else{
//            throw new TooManyCarsException("There is too many cars here, so we gonna launch without this car");
//        }
//    }
}
