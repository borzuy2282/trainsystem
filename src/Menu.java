import Cars.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Thread {
    private ArrayList <Station> stations;
    private ArrayList <Locomotive> locomotives;
    private ArrayList <Car> cars;
    private ArrayList <Trainset> trainsets;
    public Menu(ArrayList <Station> stations, ArrayList <Locomotive> locomotives, ArrayList <Car> cars, ArrayList <Trainset> trainsets){
        this.stations = stations;
        this.locomotives = locomotives;
        this.cars = cars;
        this.trainsets = trainsets;
    }
    public void mainMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Hey, here is your menu, so you will be able to start the program:\n " +
                "1 - create a station\n" +
                "2 - create a locomotive\n" +
                "3 - create a car\n" +
                "4 - create a trainset\n" +
                "5 - add car to a trainset\n" +
                " - launch a trainset\n" +
                " - see a list of all station and all stuff connected to it\n" +
                " - see a list of all trainsets and all stuff connected to it\n" +
                " - remove a trainset\n" +
                " - remove a locomotive\n" +
                " - remove a car\n" +
                " - remove a station\n" +
                " - quit the program\n" +
                "So, feel free to use: ");
        int pick = sc.nextInt();
        System.out.println();
        switch(pick){
            case 1 -> {
                creatingStation(stations);
                break;
            } case 2 -> {
                creatingLocomotive(locomotives);
                break;
            } case 3 -> {
                creatingCar(cars);
                break;
            } case 4 -> {
                creatingTrainset(trainsets, locomotives, stations);
                break;
            }
            case 5 -> {
                addingCarToTrainset(trainsets, cars);
                break;
            }default -> {
                System.out.println("Something went wrong.");
            }
        }
        mainMenu();
    }
    public static void creatingStation(ArrayList <Station> stations){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, tell me the name of the station you want to create: ");
        String name = sc.next();
        System.out.println();
        Station st = new Station(name);
        stations.add(st);
        System.out.print("Do you want to add connections to your stations[1 - yes/2 - no]? ");
        int answer = sc.nextInt();
        if(answer == 1){
            addingConnections(stations);
        }
        System.out.println("\nSo, we're done here");
    }
    public static void creatingLocomotive(ArrayList <Locomotive> locomotives){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, pass me the name of your locomotive: ");
        String name = sc.next();
        Locomotive lc = new Locomotive(name);
        locomotives.add(lc);
        System.out.println("\nYour locomotive successfully created, its ID - " + lc.getIdLocomotive());
    }
    public static void creatingCar(ArrayList<Cars.Car> cars){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, choose the type of your car: " +
                "1 - Passenger" +
                "2 - Restaurant" +
                "3 - Post" +
                "4 - Baggage" +
                "5 - Freight" +
                "6 - Heavy Freight" +
                "7 - Liquid" +
                "8 - Toxic" +
                "9 - Explosives" +
                "10 - Refrigerated" +
                "11 - Gaseous" +
                "12 - Liquid toxic" +
                "Please, choose: ");
        int answer = sc.nextInt();
        if(answer >= 1 && answer <= 12){
            System.out.print("\nPlease, choose a name of your car: ");
            String name = sc.next();
            switch (answer){
                case 1 -> {
                    Passenger cr = new Passenger(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }case 2 -> {
                    Restaurant cr = new Restaurant(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }case 3 -> {
                    Post cr = new Post(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }case 4 -> {
                    Baggage cr = new Baggage(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }case 5 -> {
                    Freight cr = new Freight(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }case 6 -> {
                    HeavyFreight cr = new HeavyFreight(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }case 7 -> {
                    Liquid cr = new Liquid(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }case 8 -> {
                    Toxic cr = new Toxic(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }case 9 -> {
                    Explosives cr = new Explosives(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }case 10 -> {
                    Refrigerated cr = new Refrigerated(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }case 11 -> {
                    Gaseous cr = new Gaseous(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }case 12 -> {
                    ToxicLiquid cr = new ToxicLiquid(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created!");
                    break;
                }default -> {
                    System.out.println("Something happend :/");
                }
            }
        }else{
            System.out.println("\nDon't have this class yet, maybe you will try something else?");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                creatingCar(cars);
            }else{
                return;
            }

        }
    }
    public static void creatingTrainset(ArrayList<Trainset> trainsets, ArrayList<Locomotive> locomotives, ArrayList<Station> stations){
        Scanner sc = new Scanner(System.in);
        System.out.print("So, first of all you have to create a name, type here: ");
        String name = sc.next();
        System.out.print("\nNow please choose a home station for this trainset, type station's id here: ");
        String stationID ="S" + sc.next();
        Station home = null;
        for (int i = 0; i < stations.size(); i++) {
            if(stations.get(i).getIdStation().equals(stationID)){
                home = stations.get(i);
            }
        }
        if(home == null){
            System.out.println("Whoops, I didn't find this station, try again");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                creatingTrainset(trainsets, locomotives, stations);
            }else{
                return;
            }

        }
        Trainset trainset = new Trainset(name, home);
        System.out.println("\nSo, now you have to set a head of a trainset.");
        System.out.print("Please, type a head locomotive's id: ");
        String locomotiveId = "L" + sc.next();
        Locomotive head = null;
        for (int j = 0; j < locomotives.size(); j++) {
            if(locomotives.get(j).getIdLocomotive().equals(locomotiveId)){
                head = locomotives.get(j);
                for (int i = 0; i < trainsets.size(); i++) {
                    if(head.equals(trainsets.get(i).getHead())){
                        System.out.println("Whoops, this locomotive is busy already, let's try again.");
                        System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                        int answ = sc.nextInt();
                        if(answ == 1){
                            creatingTrainset(trainsets, locomotives, stations);
                        }else{
                            return;
                        }

                    }
                }
            }
        }
        if(head == null){
            System.out.println("Whoops, no such a locomotive. Try again");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                creatingTrainset(trainsets, locomotives, stations);
            }
        }else {
            trainset.setHead(head);
            trainsets.add(trainset);
            System.out.println("\nTrainset is created! If you want to add few cars to it - do it through the menu.");
        }
    }
    public static void addingConnections(ArrayList <Station> stations){
        Scanner sc = new Scanner(System.in);
        System.out.print("Tell me, what station you want to connect with yours[type an ID of it]: ");
        String id = "S" + sc.next();
        Station toConnect = null;
        for (int i = 0; i < stations.size(); i++) {
            if(stations.get(i).getIdStation().equals(id)){
                toConnect = stations.get(i);
            }
        }
        if(toConnect == null) {
            System.out.println("Well, it looks like there are no stations with this id.");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                addingConnections(stations);
            }else{
                return;
            }

        }else{
            stations.get(stations.size() - 1).addCons(toConnect);
        }
        System.out.print("Do you want to add one more station[1 - yes/2 - no]? ");
        if(sc.nextInt() == 1){
            System.out.println();
            addingConnections(stations);
        }
    }
    public static void addingCarToTrainset(ArrayList <Trainset> trainsets, ArrayList<Car> cars){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, type an ID of a trainset you want to work with: ");
        String trainsetID = "TS" + sc.next();
        Trainset trainset = null;
        for(Trainset t : trainsets){
            if(t.getIdTrainset().equals(trainsetID)){
                trainset = t;
            }
        }
        if(trainset == null){
            System.out.println("\nDid not find trainset with that ID, please try again");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                addingCarToTrainset(trainsets, cars);
            }else{
                return;
            }

        }
        System.out.print("\nNow, tell me please an ID of a car that you want to add: ");
        String carID = "C" + sc.next();
        Car car = null;
        for(Car c : cars){
            if(c.getCarId().equals(carID)){
                car = c;
            }
        }
        if(car == null){
            System.out.println("\nDid not find car with that ID, please try again");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                addingCarToTrainset(trainsets, cars);
            }else{
                return;
            }

        }
        try {
            trainset.addCar(car);
        } catch (TooManyCarsException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nCar added successfully!");

    }
    public static void removeTrainset(ArrayList<Trainset> trainsets){
        Scanner sc = new Scanner(System.in);
        System.out.print("Tell me an ID of the trainset: ");
        String trainsetID = "TS" + sc.next();
        boolean flag = false;
        for(Trainset t : trainsets){
            if(t.getIdTrainset().equals(trainsetID)){
                trainsets.remove(t);
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("\nI did not find that trainset, try again.");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                removeTrainset(trainsets);
            }else{
                return;
            }

        }else{
            System.out.println("\nTrainset was removed successfully.");
        }

    }
    public static void removeLocomotive(ArrayList <Trainset> trainsets, ArrayList <Locomotive> locomotives){
        Scanner sc = new Scanner(System.in);
        System.out.print("Type an ID of a locomotive you want to remove: ");
        String locomotiveID = "L" + sc.next();
        Locomotive locomotive = null;
        for( Locomotive l : locomotives){
            if(l.getIdLocomotive().equals(locomotiveID)){
                locomotive = l;

            }
        }
        if(locomotive == null){
            System.out.println("\nNo locomotive with that ID");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                removeLocomotive(trainsets, locomotives);
            }else{
                return;
            }
        }
        boolean flag = false;
        Trainset trainset = null;
        for(Trainset t : trainsets){
            if(t.getHead() == locomotive){
                trainset = t;
                flag = true;
            }
        }
        if(flag){
            System.out.print("\nThis locomotive is in the trainset, if you will delete it - trainset will also be removed. Give us a confirmation[1 - yes/2 - no]:");
            int answ = sc.nextInt();
            if(answ == 1){
                trainsets.remove(trainset);
                locomotives.remove(locomotive);
            }else{
                System.out.println("\nWe're coming back to the menu");
                return;
            }
        }else{
            locomotives.remove(locomotive);
        }
    }
    public static void infoStation(ArrayList <Station> stations){
        for(Station s : stations){
            System.out.println(s);
        }
    }
    public static void infoTrainset(ArrayList <Trainset> trainsets){
        for(Trainset t : trainsets){
            System.out.println(t);
        }
    }

    @Override
    public void run() {
        while (true){
            this.mainMenu();
        }
    }
}
