import Cars.*;

import java.util.ArrayList;

public class Presentation {
    public static void main(String[] args) {
       Station station1 = new Station("Station1");
       Station station2 = new Station("Station2");
       Trainset trainset = new Trainset("Trainset", station1);
       Locomotive locomotive = new Locomotive("Locomotive");
       Passenger passenger = new Passenger("Passenger");
       Post post = new Post("Post");
       Restaurant restaurant = new Restaurant("Restaurant");
       Baggage baggage = new Baggage("Baggage");
       Freight freight = new Freight("Freight");
       HeavyFreight heavyFreight = new HeavyFreight("HeavyFreight");
       Explosives explosives = new Explosives("Explosives");
       Gaseous gaseous = new Gaseous("Gaseous");
       Liquid liquid = new Liquid("Liquid");
       Refrigerated refrigerated = new Refrigerated("Refrigerated");
       Toxic toxic = new Toxic("Toxic");
       ToxicLiquid toxicLiquid = new ToxicLiquid("ToxicLiquid");

       //stations:
        station1.getName(); // returns name of a station
        station1.getIdStation(); // returns an ID of a station
        station1.getCons(); // returns all connected stations
        station1.getRail(station2); // returns a rail, which connects station1 and station2
        station1.addCons(station2); // adds a connection for station1 and station2
        station1.removeCons(station2); // removes a connection between station1 and station2
        Station.generationStation(new ArrayList<Station>(), new String[100]);
        // generates 100 stations, which are connected one with others, saves it to the ArrayList

        //trainsets:
        trainset.getIdTrainset(); // returns an ID of a trainset
        trainset.getLenLeft(); // returns the length that left between first and second stations
        trainset.getHead(); // returns a locomotive, that is a head of a trainset
        trainset.getCars(); // returns all cars, that are connected to a locomotive
        trainset.getWeight(); // returns a weight of all trainset
        trainset.getElectricalCars(); // returns a number of electrical cars in a trainset
        trainset.getGlobalFrom(); // returns home station
        trainset.getRoute(); // returns built route from a home station to a destination station
        trainset.setHead(locomotive); // sets a head of a trainset
        trainset.setGlobalTo(station2); // sets a global destination
        trainset.setStopper(true); // sets a stopper, to stop the thread
        try {
            trainset.addCar(passenger); // trying to add a car to a trainset
        } catch (TooManyCarsException e) {
            System.out.println("??");
        }
        //Trainset.generationTrainsets(); generates 25 trainsets with 5-10 cars of different type and a head
        station1.addCons(station2);
        trainset.start(); //starts a Thread

        //locomotives:
        locomotive.getIdLocomotive(); //returns an ID of a locomotive
        locomotive.getWeight(); // returns a weight of a locomotive

        //Passenger
        try {
            System.out.println(passenger);
            passenger.fillTrain(50); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(passenger);
        passenger.emptyTrain(); // make a car empty

        //Post
        try {
            System.out.println(post);
            post.fillTrain(7); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(post);
        post.emptyTrain(); // make a car empty

        //Restaurant
        try {
            System.out.println(restaurant);
            restaurant.fillTrain(10); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(restaurant);
        restaurant.emptyTrain(); // make a car empty

        //Baggage
        try {
            System.out.println(baggage);
            baggage.fillTrain(16.5); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(baggage);
        baggage.emptyTrain(); // make a car empty

        //Freight
        try {
            System.out.println(freight);
            freight.fillTrain(16.5); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(freight);
        freight.emptyTrain(); // make a car empty

        //HeavyFreight
        try {
            System.out.println(heavyFreight);
            heavyFreight.fillTrain(16.5); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(heavyFreight);
        heavyFreight.emptyTrain(); // make a car empty

        //Explosives
        try {
            System.out.println(explosives);
            explosives.fillTrain(16.5); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(explosives);
        explosives.emptyTrain(); // make a car empty

        //Liquid
        try {
            System.out.println(liquid);
            liquid.fillTrain(16.5); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(liquid);
        liquid.emptyTrain(); // make a car empty

        //Gaseous
        try {
            System.out.println(gaseous);
            gaseous.fillTrain(16.5); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(gaseous);
        gaseous.emptyTrain(); // make a car empty

        //Refrigerated
        try {
            System.out.println(refrigerated);
            refrigerated.fillTrain(16.5); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(refrigerated);
        refrigerated.emptyTrain(); // make a car empty

        //Toxic
        try {
            System.out.println(toxic);
            toxic.fillTrain(16.5); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(toxic);
        toxic.emptyTrain(); // make a car empty

        //ToxicLiquid
        try {
            System.out.println(toxicLiquid);
            toxicLiquid.fillTrain(16.5); // trying to fill the car
        } catch (TooManyPeopleException e) {
            System.out.println("??");
        }
        System.out.println(toxicLiquid);
        toxicLiquid.emptyTrain(); // make a car empty
    }
}
