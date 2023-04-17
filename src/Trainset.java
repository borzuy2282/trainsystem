import Cars.Car;

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
    private ArrayList<Car> cars;
    private double weight;
    private int electricalCars;
    private double speed;
    private Station globalFrom;
    private Station from;
    private Station to;
    private Station globalTo;
    private Rail currentRail;
    private ArrayList<Station> route;
    private ArrayList<Station> all;
    private ArrayList<Station> left;
    private ArrayList<Station> passed;
    private ArrayList<Station> past;
    private ArrayList<Trainset> allTrainsets;
    private double lenLeft;
    private boolean stopper = true;

    Trainset(String name, Station h) {
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

    public ArrayList<Station> getRoute() {
        return route;
    }

    public Station getGlobalTo() {
        return globalTo;
    }

    public ArrayList<Station> getPast() {
        return past;
    }

    public ArrayList<Station> getLeft() {
        return left;
    }

    public ArrayList<Station> getAll() {
        return all;
    }

    public ArrayList<Trainset> getAllTrainsets() {
        return allTrainsets;
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

    public void setElectricalCars(int electricalCars) {
        this.electricalCars = electricalCars;
    }

    public void setAllTrainsets(ArrayList<Trainset> allTrainsets) {
        this.allTrainsets = allTrainsets;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setGlobalTo(Station globalTo) {
        this.globalTo = globalTo;
    }

    public void setTo(Station to) {
        this.to = to;
    }

    public void setAll(ArrayList<Station> all) {
        this.all = all;
    }

    public void setPast(ArrayList<Station> past) {
        this.past = past;
    }

    public void setFrom(Station from) {
        this.from = from;
    }

    public void setStopper(boolean stopper) {
        this.stopper = stopper;
    }

    public void addCar(Car c) throws TooManyCarsException {
        if(cars == null){
            cars = new ArrayList<Car>();
        }
        if (cars.size() >= 10) {
            throw new TooManyCarsException("There are too many cars here, we gonna launch without this");
        } else if (weight >= 1000) {
            throw new TooManyCarsException("We're too heavy, we can't go with this car");
        } else if (electricalCars >= 4) {
            throw new TooManyCarsException("We have no power to join this car");
        } else {
            cars.add(c);
            weight += c.getWeightBrutto();
            if (c.isElectricity()) {
                electricalCars++;
            }
        }
    }

    public void startRide() {

        /*do{

        }
        if(past == null) {
            from = globalFrom;
            left = new ArrayList<Station>();
            left.addAll(all);
            for (int i = 0; i < left.size(); i++) {
                if(left.get(i).equals(globalFrom)){
                    left.remove(i);
                    break;
                }
            }
            ArrayList<Station> t = new ArrayList<>();
            t.add(globalFrom);
            past = t;
        }*/
    }

    public void pick() {
        past = new ArrayList<>();
        Map <Station, Station> parentMap = new HashMap<>();
        route = new ArrayList<>();
        parentMap.put(this.globalFrom, null);
        Stack <Station> st = new Stack<>();
        st.push(this.globalFrom);
        while(!st.empty()){
            Station current = st.pop();
            this.past.add(current);

            if(current.equals(this.globalTo)){
                while (current != null){
                    route.add(0, current);
                    current = parentMap.get(current);

                }
                break;
            }
            for(Station s : current.getCons()){
                boolean flag = true;
                for(Station ps : this.past){
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
    public synchronized void waiting(){

        /*if(forWaiting <= 50) {
            boolean flag = false;
            for (int i = 0; i < allTrainsets.size(); i++) {
                if (!this.getIdTrainset().equals(allTrainsets.get(i).idTrainset)) {
                    if (this.getFrom() != null && allTrainsets.get(i).getFrom() != null) {
                        if (allTrainsets.get(i).getFrom().equals(this.getFrom()) && allTrainsets.get(i).getTo().equals(this.getTo())) {
                            flag = true;
                        }
                    }
                }
            }
            if (flag) {
                System.out.println("I'm waiting " + this.getIdTrainset());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Smth went wrong");
                }
                forWaiting++;
                waiting();

            }
        }else{
            forWaiting = 0;
        }*/
    }
    public void stopper(){
        setStopper(false);
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
        System.out.println("Route is: ");
        for(Station s : this.route){
            System.out.print(s.getName() + " ");
        }
        System.out.println(this.getIdTrainset());
        passed = new ArrayList<>();
        for(int i = 0; i < route.size() - 1; i++){
            from = route.get(i);
            to = route.get(i + 1);
            Rail tmp = route.get(i).getConnection().get(i);
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
            try{
                while(lenLeft > 0) {
                    System.out.println(route.get(i).getName() + " -> " + route.get(i + 1).getName() + " " + lenLeft + " " + this.getIdTrainset());
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
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
            passed.add(route.get(i));
            tmp.setCurrentTrain(null);
            this.setCurrentRail(null);
            System.out.println("We came on a station: " + route.get(i + 1).getName() + " " + this.getIdTrainset());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("We're on a destination station " + this.getIdTrainset());
        route = null;
        Station tmp = this.globalFrom;
        globalFrom = globalTo;
        globalTo = tmp;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(stopper){
            this.run();
        }
        /*
//
//        Random rand = new Random();
//        currentRail = from.getConnection().get(rand.nextInt(0, from.getConnection().size()));
//        this.waiting();

        this.setSpeed(100);
        while (currentRail.getLenLeft() > 0) {
//            System.out.println(tmp.getLenLeft() + " " + this.getIdTrainset());
            System.out.println(currentRail.getStation1().getName() + " -> " + currentRail.getStation2().getName() + " " + this.getIdTrainset());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int temp = (int) (Math.random() * 100);
            if (temp > 50) {
                if (this.getSpeed() + this.getSpeed() * 0.03 < 200) {
                    this.setSpeed(this.getSpeed() + this.getSpeed() * 0.03);
                } else {
                    try {
                        throw new RailroadHazardException("Too much, we won't speed up");
                    } catch (RailroadHazardException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                if (this.getSpeed() - this.getSpeed() * 0.03 > 0) {
                    this.setSpeed(this.getSpeed() - this.getSpeed() * 0.03);
                } else {
                    try {
                        throw new RailroadHazardException("We can't stop, we will go on current speed");
                    } catch (RailroadHazardException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            currentRail.setLenLeft(currentRail.getLenLeft() - this.getSpeed());
        }
        System.out.println("We're here! " + this.getIdTrainset());
        if(getTo().equals(getGlobalTo())){
            System.out.println("We finished our trip " + globalTo.getName());
            Station temp = globalFrom;
            globalFrom = globalTo;
            globalTo = temp;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.past = null;
            this.left = getAll();
            System.out.println("We're starting our trip again!");
            this.route = null;
            this.run();
        }else{
            System.out.println(getTo().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            past.add(getTo());
            left.remove(getTo());
            this.setFrom(this.getTo());
            this.run();
        }*/
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

        String routes = "";
        if(this.route == null){
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
            for(int i = 0; i < passed.size() - 1; i++){
                routeLenPas += passed.get(i).getRail(passed.get(i+1)).getLength();
            }
            routeLenPas += lenLeft;
        }
        return this.name + ", " + this.getIdTrainset() + ": head:" + getHead().getIdLocomotive() + ", cars: " + car + ", home st.: " + source + ". Destination: "+ dest + ". Passed already: " + (routeLenPas / routeLen * 100) + "%. Current from station: " + from + ", current destination: " + to + ". Passed already: " + ((1 - lenLeft/curRouteLen) * 100) + "%.";
    }
}

