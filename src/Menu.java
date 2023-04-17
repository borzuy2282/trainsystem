import Cars.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Thread {
    private ArrayList <Station> stations;
    private ArrayList <Locomotive> locomotives;
    private ArrayList <Car> cars;
    private ArrayList <Trainset> trainsets;
    private ArrayList<Trainset> threads = new ArrayList<>();
    private boolean stopper = true;
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
                "6 - add connections to the station\n" +
                "7 - launch a trainset\n" +
                "8 - fill the car" +
                "9 - see a list of all station and all stuff connected to it\n" +
                "10 - see a list of all trainsets and all stuff connected to it\n" +
                "11 - remove a trainset\n" +
                "12 - remove a locomotive\n" +
                "13 - remove a car\n" +
                "14 - remove a station\n" +
                "15 - quit the program\n" +
                "So, feel free to use: ");
        int pick = sc.nextInt();
        System.out.println();
        switch(pick){
            case 1 -> {
                creatingStation();
            } case 2 -> {
                creatingLocomotive();
            } case 3 -> {
                creatingCar();
            } case 4 -> {
                creatingTrainset();
            } case 5 -> {
                addingCarToTrainset();
            } case 6 -> {
                creatingConnections();
            } case 7 ->{
                launching();
            } case 8 -> {
                fillingCar();
            } case 9 -> {
                infoStation();
            } case 10 ->{
                infoTrainset();
            } case 11 ->{
                removeTrainset();
            } case 12 ->{
                removeLocomotive();
            }case 13 -> {
                removeCar();
            }case 14 ->{
                removeStation();
            }case 15 ->{
                for(Trainset t : threads){
                    t.stop();
                }
                setStopper(false);
            }
            default -> {
                System.out.println("Something went wrong.");
            }
        }
        if(stopper) {
            mainMenu();
        }
    }
    public void creatingStation(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, tell me the name of the station you want to create: ");
        String name = sc.next();
        System.out.println();
        Station st = new Station(name);
        stations.add(st);
        System.out.print("Do you want to add connections to your stations[1 - yes/2 - no]? ");
        int answer = sc.nextInt();
        if(answer == 1){
            addingConnections();
        }
        System.out.println("\nSo, we're done here");
    }
    public void creatingLocomotive(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, pass me the name of your locomotive: ");
        String name = sc.next();
        Locomotive lc = new Locomotive(name);
        locomotives.add(lc);
        System.out.println("\nYour locomotive successfully created, its ID - " + lc.getIdLocomotive());
    }
    public void creatingCar(){
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
                creatingCar();
            }else{
                return;
            }

        }
    }
    public void creatingTrainset(){
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
                creatingTrainset();
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
                            creatingTrainset();
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
                creatingTrainset();
            }else{
                return;
            }
        }else {
            trainset.setHead(head);
            trainsets.add(trainset);
        }
        System.out.print("Please enter an ID of a destination station: ");
        String destID = "S" + sc.next();
        Station dest = null;
        for(Station s : stations){
            if(destID.equals(s.getIdStation())){
                dest = s;
            }
        }
        if(dest == null){
            System.out.print("\nNo station like with this ID.");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                creatingTrainset();
            }else{
                return;
            }
        }
        if(dest.equals(home)){
            System.out.println("\nWe can't set home station as a destination!");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                creatingTrainset();
            }
        }else{
            trainset.setGlobalTo(dest);
        }

        System.out.println("\nTrainset is created! If you want to add few cars to it - do it through the menu.");

    }
    public void addingConnections(){
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
                addingConnections();
            }else{
                return;
            }

        }else{
            stations.get(stations.size() - 1).addCons(toConnect);
        }
        System.out.print("Do you want to add one more station[1 - yes/2 - no]? ");
        if(sc.nextInt() == 1){
            System.out.println();
            addingConnections();
        }
    }
    public void addingCarToTrainset(){
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
                addingCarToTrainset();
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
                addingCarToTrainset();
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
    public void creatingConnections(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Tell me ID of a first station: ");
        String firstID ="S" + sc.next();
        Station station1 = null;
        for(Station s : stations){
            if(s.getIdStation().equals(firstID)){
                station1 = s;
                break;
            }
        }
        if(station1 == null){
            System.out.println("\nWhoops, I didn't find this station, try again");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                creatingTrainset();
            }else{
                return;
            }
        }
        System.out.print("Tell me ID of a second station: ");
        String secondID ="S" + sc.next();
        Station station2 = null;
        if(secondID.equals(firstID)){
            System.out.println("\nIt is the same as the first station. Declined");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                creatingTrainset();
            }else{
                return;
            }
        }
        for(Station s : stations){
            if(s.getIdStation().equals(secondID)){
                station2 = s;
                break;
            }
        }
        if(station2 == null){
            System.out.println("\nWhoops, I didn't find this station, try again");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                creatingTrainset();
            }else{
                return;
            }
        }
        boolean flag = false;
        for(Station s : station1.getCons()){
            if(s == station2){
                flag = true;
            }
        }
        for(Station s : station2.getCons()){
            if(s == station1){
                flag = true;
            }
        }
        if(flag){
            System.out.println("\nThey are already connected.");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                creatingTrainset();
            }else{
                return;
            }
        }else{
            station1.addCons(station2);
            for(Station s : stations){
                if(s == station1){
                    int ind = stations.indexOf(s);
                    stations.remove(s);
                    stations.add(ind, station1);
                }
                if(s == station2){
                    int ind = stations.indexOf(s);
                    stations.remove(s);
                    stations.add(ind, station2);
                }
            }
            System.out.println("\nConnection created!");
        }
    }
    public void removeTrainset(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Tell me an ID of the trainset: ");
        String trainsetID = "TS" + sc.next();
        boolean flag = false;
        for(Trainset t : trainsets){
            if(t.getIdTrainset().equals(trainsetID)){
                if(t.isAlive()){
                    t.stop();
                }
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
                removeTrainset();
            }else{
                return;
            }

        }else{
            System.out.println("\nTrainset was removed successfully.");
        }

    }
    public void removeLocomotive(){
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
                removeLocomotive();
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
    public void removeStation(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, write the ID of a station you want to delete: ");
        String ID = "S" + sc.next();
        Station station = null;
        for(Station s : stations){
            if(s.getIdStation().equals(ID)){
                station = s;
                break;
            }
        }
        if(station == null){
            System.out.println("\nI did not find that station, try again.");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                removeStation();
            }else{
                return;
            }
        }
        boolean flag = false;
        for(Trainset t : trainsets){
            if(t.getRoute().get(0).equals(station) || t.getRoute().get(t.getRoute().size() - 1).equals(station)){
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("\nSorry, we can't delete this station it is a key for a trainset's route.");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                removeStation();
            }else{
                return;
            }
        }else{
            ArrayList <Station> connections = station.getCons();
            for(Station s : connections){
                s.removeCons(station);
            }
            System.out.println("Station was deleted successfully!");
        }
    }
    public void removeCar(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Write an ID of a trainset: ");
        String trainsetID = "TS" + sc.next();
        Trainset trainset;
        for(Trainset t : trainsets){
            if(t.getIdTrainset().equals(trainsetID)){
                System.out.print("\nWrite an ID of a car: ");
                String carID = "C" + sc.next();
                for(Car c : t.getCars()){
                    if(c.getCarId().equals(carID)){
                        t.removeCar(c);
                        trainset = t;
                        int tmp = trainsets.indexOf(t);
                        trainsets.remove(t);
                        trainsets.add(tmp, trainset);
                    }
                }
            }
        }
        System.out.println("\nSorry, there was some troubles.");
        System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
        int answ = sc.nextInt();
        if(answ == 1){
            fillingCar();
        }
    }
    public void infoStation(){
        for(Station s : stations){
            System.out.println(s);
        }
    }
    public void infoTrainset(){
        for(Trainset t : trainsets){
            System.out.println(t);
        }
    }
    public void launching(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Type an ID of a trainset you want to launch: ");
        String id = "TS" + sc.next();
        Trainset trainset = null;
        for(Trainset t : trainsets){
            if(t.getIdTrainset().equals(id)){
                trainset = t;
                break;
            }
        }
        if(trainset == null){
            System.out.println("\nI did not find that trainset, try again.");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                launching();
            }
        }else{

            threads.add(trainset);
            trainset.start();
        }

    }
    public void fillingCar(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Pass me the ID of a trainset: ");
        String trainsetID = "TS" + sc.next();
        Trainset trainset = null;
        for(Trainset t: trainsets){
            if(t.getIdTrainset().equals(trainsetID)){
                trainset = t;
            }
        }
        if(trainset == null){
            System.out.println("\nI did not find that trainset, try again.");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                fillingCar();
            }else{
                return;
            }
        }
        if(trainset.getCars() == null){
            System.out.println("No cars to be filled");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                fillingCar();
            }else{
                return;
            }
        }
        for(Car c : trainset.getCars()){
            if(c instanceof Passenger) {
                System.out.print("How many people do you want to load? ");
                int people = sc.nextInt();
                if(people > 100){
                    System.out.println("Too much people, we need to retry.");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                    }else{
                        return;
                    }
                }else{
                    try {
                        c.fillTrain(people);
                    } catch (TooManyPeopleException e) {
                        throw new RuntimeException(e);
                    }
                }
            }else if(c instanceof Restaurant){
                System.out.print("Let's first fill it with a cookers, pass the number of them: ");
                int cookers = sc.nextInt();
                if(cookers >= 5 || cookers <= 2){
                    System.out.println("We don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                    }else{
                        return;
                    }
                }
                System.out.print("\nNow let's set the number of waiters: ");
                int waiters = sc.nextInt();
                if(waiters <= 5 || waiters >= 15){
                    System.out.println("We don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                    }else{
                        return;
                    }
                }
                try {
                    ((Restaurant) c).addCookers(cookers);
                    ((Restaurant) c).addWaiters(waiters);
                } catch (TooManyPeopleException e) {
                    throw new RuntimeException(e);
                }
            } else if (c instanceof Post) {
                System.out.print("Write me, how many people do you want to put here");
                int crew = sc.nextInt();
                if(crew <= 3 || crew >= 10){
                    System.out.println("We don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                    }else{
                        return;
                    }
                }else{
                    try {
                        c.fillTrain(crew);
                    } catch (TooManyPeopleException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void setStopper(boolean stopper) {
        this.stopper = stopper;
    }

    public ArrayList<Trainset> getTrainsets() {
        return trainsets;
    }

    @Override
    public void run() {

        while (stopper){
            this.mainMenu();
        }
    }
}
