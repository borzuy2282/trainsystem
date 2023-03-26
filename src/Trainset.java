import Cars.Car;

import java.util.ArrayList;

public class Trainset implements Runnable {
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
    private boolean lastStop;
    private ArrayList<Station> all;
    private ArrayList<Station> left;
    private ArrayList<Station> past;
    private ArrayList<Trainset> allTrainsets;

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

    public void startRide() {

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
        }
    }

    public void pick(ArrayList<Station> where) {
        int tmp = (int) (Math.random() * where.size());
        setTo(where.get(tmp));
    }
    public void waiting() throws InterruptedException {
        if(forWaiting <= 50) {
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
                Thread.sleep(500);
                forWaiting++;
                waiting();

            }
        }else{
            forWaiting = 0;
        }
    }
    @Override
    public void run(){
        this.startRide();
        this.pick(getLeft());

        currentRail = new Rail(this.getFrom(), this.getTo());
        try {
            this.waiting();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        }
    }


}

