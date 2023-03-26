import Cars.Car;

import java.util.ArrayList;

public class Trainset implements Runnable {
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
    private ArrayList<Station> all;
    private ArrayList<Station> past;

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

    public ArrayList<Station> getPast() {
        return past;
    }

    public ArrayList<Station> getAll() {
        return all;
    }
    //setters

    public void setHead(Locomotive head) {
        this.head = head;
        weight += head.getWeight();
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

    public void addCar(Car c) throws TooManyCarsException {
        if (cars.size() >= 10) {
            throw new TooManyCarsException("There are too many cars here, we gonna launch without this");
        } else if (weight >= 1000) {
            throw new TooManyCarsException("We're too heavy, we can't go with this car");
        } else if (electricalCars >= 6) {
            throw new TooManyCarsException("We have no power to join this car");
        } else {
            cars.add(c);
            weight += c.getWeightBrutto();
            if (c.isElectricity()) {
                electricalCars++;
            }
        }
    }

    public void startRide(Station dest) {
        globalTo = dest;
        from = globalFrom;
        if(past == null) {
            ArrayList<Station> t = new ArrayList<>();
            t.add(globalFrom);
            past = t;
        }
    }

    public Station pick(ArrayList<Station> where){
        int tmp = (int) (Math.random() * where.size());
        boolean flag = true;
        if(getPast() != null){
            for (int i = 0; i < this.getPast().size(); i++) {
                if (this.getPast().get(i).equals(where.get(tmp))) {
                    flag = false;
                }
            }
        }
        if(flag){
            return where.get(tmp);
        }else{
            return this.pick(where);
        }
    }
//    public void waiting(ArrayList <Trainset> all) throws InterruptedException {
//        boolean flag = true;
//        for (int i = 0; i < all.size(); i++) {
//            if(!this.getIdTrainset().equals(all.get(i).idTrainset)){
//                if(this.getFrom() != null && all.get(i).getFrom() != null) {
//                    if (all.get(i).getFrom().equals(this.getFrom()) && all.get(i).getTo().equals(this.getTo())) {
//                        flag = false;
//                    }
//                }
//            }
//        }
//        if(flag){
//            System.out.println("I'm waiting " + this.getIdTrainset());
//            this.join();
//        }
//    }
    @Override
    public void run(){
        this.startRide(globalTo);
        setTo(this.pick(getAll()));

        Rail tmp = new Rail(this.from, this.to);
//        try {
//            this.waiting(all);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        this.setSpeed(10);
        while (tmp.getLenLeft() > 0) {
//            System.out.println(tmp.getLenLeft() + " " + this.getIdTrainset());
            System.out.println(this.getFrom().getName() + " -> " + this.getTo().getName() + " " + this.getIdTrainset());
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

            tmp.setLenLeft(tmp.getLenLeft() - this.getSpeed());
        }
        System.out.println("We're here!");
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
            System.out.println("We're starting our trip again!");
            this.run();
        }else{
            System.out.println(getTo().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            past.add(getTo());
            from = to;
            this.run();
        }
    }
}

