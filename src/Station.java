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
    public Rail getRail(Station s2){
        for(Rail r : connection){
            if(r.getStation1_1() == this && r.getStation2_1() == s2 || r.getStation1_1() == s2 && r.getStation2_1() == this){
                return r;
            }
        }
        return null;
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
    public static void generationStation(ArrayList<Station>stations, String [] names){
        Random rn = new Random();
        for (int i = 0; i < names.length; i++) {
            stations.add(new Station(names[i]));
        }
        for (int i = 0; i < stations.size(); i++) {
            Station station = stations.get(i);
            int numCon = rn.nextInt(5,11);
            if(station.getCons().size() >= numCon){
                continue;
            }
            for(int j = station.cons.size(); j < numCon; j++){
                int tmp = rn.nextInt(stations.size());
                Station st = stations.get(tmp);
                while(st == station || station.getRail(st) != null || st.getCons().size() == 10){
                    tmp = rn.nextInt(stations.size());
                    st = stations.get(tmp);
                }
                station.addCons(st);
            }
        }
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
