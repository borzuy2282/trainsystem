import Cars.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Thread {
    public static void mainMenu(ArrayList<Station> stations, ArrayList <Locomotive> locomotives, ArrayList <Cars.Car> cars, ArrayList <Trainset> trainsets ){
        Scanner sc = new Scanner(System.in);
        System.out.print("Hey, here is your menu, so you will be able to start the program:\n " +
                "1 - create a station\n" +
                "2 - create a locomotive\n" +
                "3 - create a car\n" +
                "4 - create a trainset\n" +
                "5 - add cars to a trainset" +
                "6 - see a list of all station and all stuff connected to it\n" +
                "7 - see a list of all trainsets and all stuff connected to it\n" +
                "8 - quit the program\n" +
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
                creatingTrainset(trainsets, locomotives, cars, stations);
                break;
            }
        }
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
            creatingCar(cars);
        }
    }
    public static void creatingTrainset(ArrayList<Trainset> trainsets, ArrayList<Locomotive> locomotives, ArrayList<Car> cars, ArrayList<Station> stations){
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
            creatingTrainset(trainsets, locomotives, cars, stations);
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
                        creatingTrainset(trainsets, locomotives, cars, stations);
                    }
                }
            }
        }
        if(head == null){
            System.out.println("Whoops, no such a locomotive. Try again");
            creatingTrainset(trainsets, locomotives, cars, stations);
        }
        trainset.setHead(head);
        System.out.println("\nTrainset is created! If you want to add few cars to it - do it through the menu.");
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
        }else{
            stations.get(stations.size() - 1).addCons(toConnect);
        }
        System.out.print("Do you want to add one more station[1 - yes/2 - no]? ");
        if(sc.nextInt() == 1){
            System.out.println();
            addingConnections(stations);
        }
    }
}
