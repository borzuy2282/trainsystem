import java.util.ArrayList;

public class Station {
    private String name;
    private ArrayList<Station> connection;
    private String idStation;
    private static int forId = 0;
    Station(String n){
        this.name = n;
        idStation = "S" + (++forId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addConnection(Station s){
        connection.add(s);
    }
}
