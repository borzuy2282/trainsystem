

public class Locomotive {
    //variables:
    private String name;
    private Station home;
    private double currentSpeed;
    Station globalFrom;
    Station from;
    Station to;
    Station globalTo;
    private String idLocomotive;
    private static int forId = 0;

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
}
