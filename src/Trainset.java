import Cars.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class Trainset extends Thread {
    private final String name;
    private static int forId = 0;
    private static int forWaiting = 0;
    private final String idTrainset;
    private Locomotive head;
    private ArrayList<Car> cars = new ArrayList<>();
    private double weight;
    private int electricalCars;
    private double speed;
    private Station globalFrom;
    private Station from;
    private Station to;
    private Station globalTo;
    private Rail currentRail;
    private ArrayList<Station> route;
    private ArrayList<Station> passed;
    private int counter = 0;
    private double lenLeft;
    private boolean stopper = true;

    Trainset(String name, Station h) {
        this.name = name;
        this.globalFrom = h;
        idTrainset = "TS" + (++forId);
    }
    //getters
    public String getIdTrainset() {
        return idTrainset;
    }

    public double getLenLeft() {
        return lenLeft;
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

    public Station getGlobalFrom() {
        return globalFrom;
    }

    public ArrayList<Station> getRoute() {
        return route;
    }

    //setters

    public void setHead(Locomotive head) {
        this.head = head;
        weight += head.getWeight();
    }

    public void setCurrentRail(Rail currentRail) {
        this.currentRail = currentRail;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setGlobalTo(Station globalTo) {
        this.globalTo = globalTo;
    }

    public void setStopper(boolean stopper) {
        this.stopper = stopper;
    }

    public void addCar(Car c) throws TooManyCarsException {
        if(cars == null){
            cars = new ArrayList<Car>();
        }
        int tmp = c.isElectricity() ? 1 : 0;
        if (cars.size() + 1 > 10) {
            throw new TooManyCarsException("There are too many cars here, we gonna launch without this");
        } else if (weight + c.getWeightBrutto() > 950) {
            throw new TooManyCarsException("We're too heavy, we can't go with this car");
        } else if (electricalCars + tmp > 5) {
            throw new TooManyCarsException("We have no power to join this car");
        } else {
            cars.add(c);
            weight += c.getWeightBrutto();
            if (c.isElectricity()) {
                electricalCars++;
            }
        }
    }

    public void pick() {
        ArrayList<Station> past = new ArrayList<>();
        Map <Station, Station> parentMap = new HashMap<>();
        route = new ArrayList<>();
        parentMap.put(this.globalFrom, null);
        Stack <Station> st = new Stack<>();
        st.push(this.globalFrom);
        while(!st.empty()){
            Station current = st.pop();
            past.add(current);

            if(current.equals(this.globalTo)){
                while (current != null){
                    route.add(0, current);
                    current = parentMap.get(current);

                }
                break;
            }
            for(Station s : current.getCons()){
                boolean flag = true;
                for(Station ps : past){
                    if(s.equals(ps)){
                        flag = false;
                    }
                }
                if(flag){
                    st.push(s);
                    past.add(s);
                    parentMap.put(s, current);
                }
            }
        }
    }
    public void removeCar(Car car){
        electricalCars--;
        weight -= car.getWeightBrutto();
        cars.remove(car);
    }
    public void stopper(){
        setStopper(false);
    }
    public static void generationTrainsets(ArrayList<Trainset>trainsets, ArrayList<Locomotive> locomotives, ArrayList<Car>cars,ArrayList<Station>stations ,String[]names){
        Random rn = new Random();
        for (int i = 0; i < 25; i++) {
            locomotives.add(new Locomotive(names[i]));
        }
        for (int i = 0; i < 25; i++){
            int stationNum = rn.nextInt(stations.size());
            trainsets.add(new Trainset(names[i+25], stations.get(stationNum)));
            trainsets.get(i).setHead(locomotives.get(i));
        }
        for(Trainset t: trainsets){
            int carNum = rn.nextInt(5, 11);
            for (int i = 0; i < carNum; i++) {
                int carType = rn.nextInt(1, 13);
                if (t.electricalCars == 5) {
                    while (carType == 1 || carType == 2 || carType == 3 || carType == 10) {
                        carType = rn.nextInt();
                    }
                }
            int nameCar = rn.nextInt(100);
            switch (Integer.toString(carType)) {
                case "1" -> {
                    Passenger cr = new Passenger(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                        t.electricalCars++;
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }
                }
                case "2" -> {
                    Restaurant cr = new Restaurant(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                        t.electricalCars++;
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }
                }
                case "3" -> {
                    Post cr = new Post(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                        t.electricalCars++;
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }
                }
                case "4" -> {
                    Baggage cr = new Baggage(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }

                }
                case "5" -> {
                    Freight cr = new Freight(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }
                }
                case "6" -> {
                    HeavyFreight cr = new HeavyFreight(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }
                }
                case "7" -> {
                    Liquid cr = new Liquid(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }
                }
                case "8" -> {
                    Toxic cr = new Toxic(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }
                }
                case "9" -> {
                    Explosives cr = new Explosives(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }
                }
                case "10" -> {
                    Refrigerated cr = new Refrigerated(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                        t.electricalCars++;
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }
                }
                case "11" -> {
                    Gaseous cr = new Gaseous(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }
                }
                case "12" -> {
                    ToxicLiquid cr = new ToxicLiquid(names[nameCar]);
                    cars.add(cr);
                    try {
                        t.addCar(cr);
                        t.weight += cr.getWeightBrutto();
                    } catch (TooManyCarsException e) {
                        System.out.println("whoops");
                    }
                }
            }
            }
        }
    }
    @Override
    public void run(){
        if(head == null){
            System.out.println("Sorry, we can't launch without a locomotive");
            return;
        }
        Random rand = new Random();
        if(route == null){
            this.pick();
        }
        this.setSpeed(50);
        System.out.println("\n" + this.getIdTrainset() + " started its ride.");
        passed = new ArrayList<>();
        for(int i = 0; i < route.size() - 1; i++){
            from = route.get(i);
            to = route.get(i + 1);
            Rail tmp = from.getRail(to);
            while(tmp.getCurrentTrain() != null){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            tmp.setCurrentTrain(this);
            this.setCurrentRail(tmp);
            lenLeft = tmp.getLength();

                while(lenLeft > 0) {
                    if(lenLeft - this.speed >= 0){
                        lenLeft -= this.speed;
                    }else{
                        lenLeft = 0;
                    }
                    if (lenLeft <= 0) {
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    int probability = rand.nextInt(0, 100);
                    if (probability < 50) {
                        if (this.speed - this.speed * 0.03 <= 0) {
                            try {
                                throw new RailroadHazardException("We can't stop!");
                            } catch (RailroadHazardException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            this.speed -= this.speed * 0.03;
                        }
                    } else {
                        if (this.speed + this.speed * 0.03 > 200) {
                            try {
                                throw new RailroadHazardException("Too fast dude!");
                            } catch (RailroadHazardException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            this.speed += this.speed * 0.03;
                        }
                    }
                }
            passed.add(route.get(i));
            counter++;
            tmp.setCurrentTrain(null);
            this.setCurrentRail(null);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("\n" + idTrainset + " finished its ride.");
        route = null;
        Station tmp = this.globalFrom;
        globalFrom = globalTo;
        globalTo = tmp;
        for(Car c : cars){
            c.emptyTrain();
        }
        System.out.println("\nAll cars in trainset " + idTrainset + " are empty now, you can refill them with the menu.");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(stopper){
            this.run();
        }
    }

    @Override
    public String toString() {
        String car = FileWriting.printingCars(this);
        String source;
        String dest;
        String from;
        String to;
        double routeLen = 0;
        double curRouteLen = 0;
        double routeLenPas = 0;
        double curLenPas = 0;
        if(this.route == null || this.route.size() == 0 || this.currentRail == null){
            return this.name + ", " + this.getIdTrainset() + ": head:" + getHead().getIdLocomotive() + ", cars: " + car + ", didn't start its ride yet.";
        }else {
            source = globalFrom.getIdStation();
            dest = globalTo.getIdStation();
            from = this.from.getIdStation();
            to = this.to.getIdStation();
            for (int i = 0; i < route.size() - 1; i++) {
                routeLen += route.get(i).getRail(route.get(i+1)).getLength();
            }
            curRouteLen = this.from.getRail(this.to).getLength();
            for(int i = 0; i < counter; i++){
                routeLenPas += route.get(i).getRail(route.get(i+1)).getLength();
            }
            routeLenPas += currentRail.getLength() - lenLeft;
            curLenPas = curRouteLen - lenLeft;
            if(curRouteLen < 0){
                curRouteLen = 0;
            }
            if(curLenPas <0){
                curLenPas = 0;
            }
        }
        return this.name + ", " + this.getIdTrainset() + ": head:" + getHead().getIdLocomotive() + ", cars: " + car + ", home st.: " + source + ". Destination: "+ dest + ". Passed already: " + (routeLenPas / routeLen) * 100 + "%. Current from station: " + from + ", current destination: " + to + ". Passed already: " + (curLenPas / curRouteLen) * 100 + "%.";
    }
}

