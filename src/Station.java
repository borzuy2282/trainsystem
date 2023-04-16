import java.util.ArrayList;
import java.util.Random;

public class Station {
    private String name;
    private ArrayList<Station> cons = new ArrayList<>();
    private ArrayList<Rail> connection = new ArrayList<>();
    private String idStation;
    private static int forId = 0;
    Station(String n){
        this.name = n;
        idStation = "S" + (++forId);
    }

    public String getName() {
        return name;
    }

    public String getIdStation() {
        return idStation;
    }

    public ArrayList<Station> getCons() {
        return cons;
    }

    public boolean isConnected(Station s2){
        for(Station s : cons){
            if(s2 == s){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Rail> getConnection() {
        return connection;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addCons(Station s2){
        cons.add(s2);
        Random rand = new Random();
        double len = rand.nextDouble(100, 1000);
        Rail rail = new Rail(this, s2, len);
        connection.add(rail);
        s2.addCons(this, rail);
    }
    private void addCons(Station s2, Rail rail){
        cons.add(s2);
        connection.add(rail);
    }
    public void removeCons(Station s2){
        Rail r;
        for(Rail i : this.connection){
            if(i.getStation1_1().equals(s2) || i.getStation1_2().equals(s2)){
                s2.connection.remove(i);
                connection.remove(i);
                break;
            }
        }
        this.cons.remove(s2);
        s2.cons.remove(this);
    }

    @Override
    public String toString() {
        String names = "";
        for(Station s : cons){
            names = names + s.getName() + " ";
        }
        return this.name + ", " + this.idStation + ", its connections: [" + names + "].";
    }
}
