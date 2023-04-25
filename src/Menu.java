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
                "1 - create a station,  " +
                "2 - create a locomotive,  " +
                "3 - create a car,  " +
                "4 - create a trainset\n" +
                "5 - add car to a trainset,  " +
                "6 - add connections to the station,  " +
                "7 - launch a trainset,  " +
                "8 - fill the car\n" +
                "9 - see a list of all station and all stuff connected to it\n" +
                "10 - see a list of all trainsets and all stuff connected to it\n" +
                "11 - set a destination station for a trainset\n" +
                "12 - remove a trainset,  " +
                "13 - remove a locomotive,  " +
                "14 - remove a car,  " +
                "15 - remove a station\n" +
                "16 - quit the program\n" +
                "So, feel free to use: ");
        String pick = sc.next();
        System.out.println();
        switch(pick){
            case "1" -> {
                creatingStation();
            } case "2" -> {
                creatingLocomotive();
            } case "3" -> {
                creatingCar();
            } case "4" -> {
                creatingTrainset();
            } case "5" -> {
                addingCarToTrainset();
            } case "6" -> {
                creatingConnections();
            } case "7" ->{
                launching();
            } case "8" -> {
                fillingCar();
            } case "9" -> {
                infoStation();
            } case "10" ->{
                infoTrainset();
            }case "11" -> {
                settingDest();
            }case "12" ->{
                removeTrainset();
            } case "13" ->{
                removeLocomotive();
            }case "14" -> {
                removeCar();
            }case "15" ->{
                removeStation();
            }case "16" ->{
                for(Trainset t : threads){
                    t.stop();
                }
                setStopper();
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
        System.out.println("Station created! Id: " + st.getIdStation());
        System.out.print("Do you want to add connections to your stations[1 - yes/2 - no]? ");
        String answer = sc.next();
        if(answer.equals("1")){
            addingConnections();
            return;
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
        System.out.print("Please, choose the type of your car:\n" +
                "1 - Passenger,  " +
                "2 - Restaurant,  " +
                "3 - Post\n" +
                "4 - Baggage,  " +
                "5 - Freight,  " +
                "6 - Heavy Freight\n" +
                "7 - Liquid,  " +
                "8 - Toxic,  " +
                "9 - Explosives\n" +
                "10 - Refrigerated,  " +
                "11 - Gaseous,  " +
                "12 - Liquid toxic\n" +
                "Please, choose: ");
            String answer = sc.next();
            System.out.print("\nPlease, choose a name of your car: ");
            String name = sc.next();
            switch (answer){
                case "1" -> {
                    Passenger cr = new Passenger(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());
                }case "2" -> {
                    Restaurant cr = new Restaurant(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());
                }case "3" -> {
                    Post cr = new Post(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());
                }case "4" -> {
                    Baggage cr = new Baggage(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());;
                }case "5" -> {
                    Freight cr = new Freight(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());
                }case "6" -> {
                    HeavyFreight cr = new HeavyFreight(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());
                }case "7" -> {
                    Liquid cr = new Liquid(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());
                }case "8" -> {
                    Toxic cr = new Toxic(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());
                }case "9" -> {
                    Explosives cr = new Explosives(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());
                }case "10" -> {
                    Refrigerated cr = new Refrigerated(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());
                }case "11" -> {
                    Gaseous cr = new Gaseous(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());
                }case "12" -> {
                    ToxicLiquid cr = new ToxicLiquid(name);
                    cars.add(cr);
                    System.out.println("\n Your car was successfully created! " + cr.getCarId());
                }default -> {
                    System.out.println("\nDon't have this class yet, maybe you will try something else?");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        creatingCar();
                        return;
                    }else{
                        return;
                    }
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
                return;
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
                            return;
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
                return;
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
                return;
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
                return;
            }
        }else{
            trainset.setGlobalTo(dest);
        }

        System.out.println("\nTrainset is created! Id: " + trainset.getIdTrainset() + " If you want to add few cars to it - do it through the menu.");

    }
    public void settingDest(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Tell me an ID of the trainset: ");
        String trainsetID = "TS" + sc.next();
        Trainset trainset = null;
        for(Trainset t : trainsets){
            if(t.getIdTrainset().equals(trainsetID)){
                trainset = t;
                break;
            }
        }
        if(trainset == null){
            System.out.println("\nDid not find trainset with that ID, please try again");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                settingDest();
                return;
            }else{
                return;
            }
        }else{
            if(trainset.isAlive()){
                System.out.println("\nSorry, it is already on its way.");
                System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                int answ = sc.nextInt();
                if(answ == 1){
                    settingDest();
                    return;
                }else{
                    return;
                }
            }else{
                System.out.print("Tell me ID of a station: ");
                String stationID ="S" + sc.next();
                Station station = null;
                for(Station s : stations){
                    if(s.getIdStation().equals(stationID)){
                        station = s;
                    }
                }
                if(station == null){
                    System.out.println("\nWhoops, I didn't find this station, try again");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        settingDest();
                        return;
                    }else{
                        return;
                    }
                } else if (station == trainset.getGlobalFrom()) {
                    System.out.println("\nThis station is already a home station for this trainset.");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        settingDest();
                        return;
                    }else{
                        return;
                    }
                }else{
                    trainset.setGlobalTo(station);
                    System.out.println("\nDestination station changed successfully!");
                }
            }
        }
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
                return;
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
                return;
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
                break;
            }
        }
        if(car == null){
            System.out.println("\nDid not find car with that ID, please try again");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                addingCarToTrainset();
                return;
            }else{
                return;
            }
        }
        try {
            if(trainset.getWeight() + car.getWeightBrutto() > 950){
                System.out.println("\nToo heavy");
                System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                int answ = sc.nextInt();
                if(answ == 1){
                    addingCarToTrainset();
                    return;
                }else{
                    return;
                }
            } else if (trainset.getElectricalCars() + 1 > 5) {
                System.out.println("\nToo much electricity");
                System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                int answ = sc.nextInt();
                if(answ == 1){
                    addingCarToTrainset();
                    return;
                }else{
                    return;
                }
            }else if(trainset.getCars().size() == 10){
                System.out.println("Too much cars");
                System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                int answ = sc.nextInt();
                if(answ == 1){
                    addingCarToTrainset();
                    return;
                }else{
                    return;
                }
            }else {
                trainset.addCar(car);
            }
        } catch (TooManyCarsException e) {
            System.out.println();
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                addingCarToTrainset();
                return;
            }else{
                return;
            }
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
                creatingConnections();
                return;
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
                creatingConnections();
                return;
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
                creatingConnections();
                return;
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
                creatingConnections();
                return;
            }else{
                return;
            }
        }else{
            station1.addCons(station2);
            System.out.println("\nConnection created!");
        }
        System.out.println("So, we're done here.");
    }
    public void removeTrainset(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Tell me an ID of the trainset: ");
        String trainsetID = "TS" + sc.next();
        boolean flag = false;
        for(Trainset t : trainsets){
            if(t.getIdTrainset().equals(trainsetID)){
                if(t.isAlive()){
                    t.stopper();
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
                return;
            }else{
                return;
            }

        }else{
            System.out.println("\nTrainset was removed successfully.");
        }
        System.out.println("So, we're done here.");

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
                return;
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
                for(Trainset t : threads){
                    if(t == trainset){
                        trainset.stopper();
                    }
                }
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
                return;
            }else{
                return;
            }
        }
        boolean flag = false;
        for(Trainset t : trainsets){
            if(t.getRoute()!= null) {
                for (int i = 0; i < t.getRoute().size(); i++) {
                    if (t.getRoute().get(i) == station) {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                break;
            }
        }
        if(flag){
            System.out.println("\nSorry, we can't delete this station it is a part of a trainset's route.");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                removeStation();
                return;
            }else{
                return;
            }
        }else{
            stations.remove(station);
            System.out.println("Station was deleted successfully!");
        }
        System.out.println("So, we're done here.");
    }
    public void removeCar(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Write an ID of a trainset: ");
        String trainsetID = "TS" + sc.next();
        Trainset trainset = null;
        for(Trainset t : trainsets){
            if(trainsetID.equals(t.getIdTrainset())){
                trainset = t;
            }
        }
        if (trainset == null) {
            System.out.println("\nI did not find that trainset, try again.");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                removeCar();
                return;
            }else{
                return;
            }
        }else{
            System.out.print("\nWrite an ID of a car: ");
            String carID = "C" + sc.next();
            Car car = null;
            for(Car c : trainset.getCars()) {
                if(c.getCarId().equals(carID)){
                    car = c;
                }
            }
            if(car == null) {
                System.out.println("\nThis trainset doesn't have this car.");
                System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                int answ = sc.nextInt();
                if (answ == 1) {
                    removeCar();
                    return;
                } else {
                    return;
                }
            }
            trainset.setWeight(trainset.getWeight() - car.getWeightBrutto());
            trainset.removeCar(car);
        }
        System.out.println("\nWe're done here");
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
                return;
            }else{
                return;
            }
        }else if(trainset.getGlobalTo() == null){
            System.out.println("\nPlease, first set a global destination");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                launching();
                return;
            }else{
                return;
            }
        } else{
            if(!trainset.isAlive()) {
                threads.add(trainset);
                trainset.start();
            }else{
                System.out.println("It is already riding.");
            }
        }
        System.out.println("\nSo we're done here");

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
                return;
            }else{
                return;
            }
        }
        if(trainset.getRoute() != null){
            System.out.println("\nSorry, this train already started its trip. Please wait until it will come to destination station");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                fillingCar();
                return;
            }else{
                return;
            }
        }
        if(trainset.getCars() == null || trainset.getCars().size() == 0){
            System.out.println("\nNo cars to be filled");
            System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
            int answ = sc.nextInt();
            if(answ == 1){
                fillingCar();
                return;
            }else{
                return;
            }
        }
        for(Car c : trainset.getCars()){
            if(c instanceof Passenger) {
                System.out.print("\nHow many people do you want to load? ");
                int people = sc.nextInt();
                if(people > ((Passenger) c).getPlaces() || people < 0){
                    System.out.println("\nToo much people, we need to retry.");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                }else if (people == 0) {
                    System.out.println("\nNothing loaded");
                }else{
                    try {
                        ((Passenger)c).fillTrain(people);
                        System.out.println("\nFilled successfully!");
                    } catch (TooManyPeopleException e) {
                        System.out.println();
                        System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                        int answ = sc.nextInt();
                        if(answ == 1){
                            fillingCar();
                            return;
                        }else{
                            return;
                        }
                    }
                }
            }else if(c instanceof Restaurant){
                System.out.print("Tell me the number of staff in a restaurant: ");
                int staff = sc.nextInt();
                if(staff > ((Restaurant) c).getPlace() || staff < 0){
                    System.out.println("\nWe don't need this amount, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                }else if (staff == 0) {
                    System.out.println("\nNo one loaded");
                }else {
                    try {
                        ((Restaurant) c).fillTrain(staff);
                        System.out.println("\nFilled successfully!");

                    } catch (TooManyPeopleException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (c instanceof Post) {
                System.out.print("Write me, how many people do you want to add to crew: ");
                int crew = sc.nextInt();
                if(crew > ((Post) c).getPlace() || crew < 0){
                    System.out.println("\nWe don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                }else if (crew == 0) {
                    System.out.println("\nNo one loaded");
                }else{
                    try {
                        ((Post) c).fillTrain(crew);
                        System.out.println("\nFilled successfully!");
                    } catch (TooManyPeopleException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }else if(c instanceof Baggage){
                System.out.print("Write me, how much do you want to load into baggage car: ");
                double baggage = sc.nextDouble();
                if(baggage > ((Baggage) c).getAvailablePlace() || baggage < 0){
                    System.out.println("\nWe don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                }else if (baggage == 0) {
                    System.out.println("\nNothing loaded");
                }else{
                    try {
                        ((Baggage)c).fillTrain(baggage);
                        System.out.println("\nFilled successfully!");
                    } catch (TooManyPeopleException e) {
                        System.out.println("Something went wrong");
                    }
                }
            }else if(c instanceof Freight){
                System.out.print("Write me, how much do you want to load into freight car: ");
                double baggage = sc.nextDouble();
                if(baggage > ((Freight) c).getCapacity() || baggage < 0){
                    System.out.println("\nWe don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                }else if (baggage == 0) {
                    System.out.println("\nNothing loaded");
                }else {
                    try {
                        ((Freight)c).fillTrain(baggage);
                        System.out.println("\nFilled successfully!");
                    } catch (TooManyPeopleException e) {
                        System.out.println("Something went wrong");
                    }
                }
            } else if (c instanceof HeavyFreight) {
                System.out.print("Write me, how much do you want to load into heavy freight car: ");
                double baggage = sc.nextDouble();
                if(baggage > ((HeavyFreight) c).getCapacity() || baggage < 0){
                    System.out.println("\nWe don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                }else if (baggage == 0) {
                    System.out.println("\nNothing loaded");
                }else {
                    try {
                        ((HeavyFreight)c).fillTrain(baggage);
                        System.out.println("\nFilled successfully!");
                    } catch (TooManyPeopleException e) {
                        System.out.println("Something went wrong");
                    }
                }
            } else if (c instanceof Refrigerated) {
                System.out.print("Write me, how much do you want to load into refrigerated car: ");
                double baggage = sc.nextDouble();
                if(baggage > ((Refrigerated) c).getCapacity() || baggage < 0){
                    System.out.println("\nWe don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                }else if (baggage == 0) {
                    System.out.println("\nNothing loaded");
                }else {
                    try {
                        ((Refrigerated)c).fillTrain(baggage);
                        System.out.println("\nFilled successfully!");
                    } catch (TooManyPeopleException e) {
                        System.out.println("Something went wrong");
                    }
                }
            } else if (c instanceof Liquid) {
                System.out.print("Write me, how much do you want to load into liquid car: ");
                double baggage = sc.nextDouble();
                if(baggage > ((Liquid) c).getCapacity() || baggage < 0){
                    System.out.println("\nWe don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                }else if (baggage == 0) {
                    System.out.println("\nNothing loaded");
                }else {
                    try {
                        ((Liquid)c).fillTrain(baggage);
                        System.out.println("\nFilled successfully!");
                    } catch (TooManyPeopleException e) {
                        System.out.println("Something went wrong");
                    }
                }
            } else if (c instanceof Gaseous) {
                System.out.print("Write me, how much do you want to load into gaseous car: ");
                double baggage = sc.nextDouble();
                if(baggage > ((Gaseous) c).getCapacity() || baggage < 0){
                    System.out.println("\nWe don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                }else if (baggage == 0) {
                    System.out.println("\nNothing loaded");
                }else {
                    try {
                        ((Gaseous)c).fillTrain(baggage);
                        System.out.println("\nFilled successfully!");
                    } catch (TooManyPeopleException e) {
                        System.out.println("Something went wrong");
                    }
                }
            } else if (c instanceof Explosives) {
                System.out.print("Write me, how much do you want to load into explosives car: ");
                double baggage = sc.nextDouble();
                if(baggage > ((Explosives) c).getCapacity() || baggage < 0){
                    System.out.println("\nWe don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                }else if (baggage == 0) {
                    System.out.println("\nNothing loaded");
                }else {
                    try {
                        ((Explosives)c).fillTrain(baggage);
                        System.out.println("\nFilled successfully!");
                    } catch (TooManyPeopleException e) {
                        System.out.println("Something went wrong");
                    }
                }
            } else if (c instanceof Toxic) {
                System.out.print("Write me, how much do you want to load into toxic car: ");
                double baggage = sc.nextDouble();
                if(baggage > ((Toxic) c).getCapacity() || baggage < 0){
                    System.out.println("\nWe don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                }else if (baggage == 0) {
                    System.out.println("\nNothing loaded");
                } else {
                    try {
                        ((Toxic)c).fillTrain(baggage);
                        System.out.println("\nFilled successfully!");
                    } catch (TooManyPeopleException e) {
                        System.out.println("Something went wrong");
                    }
                }
            } else if (c instanceof ToxicLiquid) {
                System.out.print("Write me, how much do you want to load into toxic liquid car: ");
                double baggage = sc.nextDouble();
                if(baggage > ((ToxicLiquid) c).getCapacity() || baggage < 0){
                    System.out.println("\nWe don't need so much, let's do retry");
                    System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                    int answ = sc.nextInt();
                    if(answ == 1){
                        fillingCar();
                        return;
                    }else{
                        return;
                    }
                } else if (baggage == 0) {
                    System.out.println("\nNothing loaded");
                } else {
                    try {
                        ((ToxicLiquid)c).fillTrain(baggage);
                        System.out.println("\nFilled successfully!");
                    } catch (TooManyPeopleException e) {
                        System.out.println("Something went wrong");
                    }
                }
            }else{
                System.out.println("\nThere is a problem.");
                System.out.print("Do you want to try again?[1 - yes/2 - no]: ");
                int answ = sc.nextInt();
                if(answ == 1){
                    fillingCar();
                    return;
                }else{
                    return;
                }
            }
        }
    }

    public void setStopper() {
        this.stopper = false;
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
