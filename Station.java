import java.util.ArrayList;

public class Station {
    private String name;
    private ArrayList<Station> connection;
    Station(String n){
        this.name = n;
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
