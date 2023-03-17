abstract public class Car {
    private String name;
    public static int forId = 0;
    private String carId;
    Car(String n){
        this.name = n;
        this.carId = "C" + (++forId);
    }
    //getters:
    public String getName() {
        return name;
    }

    public String getCarId() {
        return carId;
    }
}
