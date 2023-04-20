import java.util.ArrayList;

public class Locomotive {
    //variables:
    private String name;
    private static double weight = 100;
    private String idLocomotive;
    private static int forId = 0;

    //constructor:
    Locomotive(String n){
        this.name = n;
        this.idLocomotive = "L" + (++forId);
    }
    //getters:
    public String getName() {
        return name;
    }

    public String getIdLocomotive() {
        return idLocomotive;
    }

    public double getWeight() {
        return weight;
    }

}
