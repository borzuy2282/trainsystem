public class Rail{
    private Trainset currentTrain;
    private Station station1_1;
    private Station station1_2;
    private Station station2_1;
    private Station station2_2;
    private final double length;
    private double lenLeft;

    public Rail(Station station1, Station station2, double length) {
        this.station1_1 = station1;
        this.station2_1 = station2;
        this.station1_2 = station2;
        this.station2_2 = station1;
        this.length = length;
        lenLeft = length;
    }
//  getters
    public Station getStation1_1() {
        return station1_1;
    }
    public Station getStation1_2() {
        return station1_2;
    }
    public Station getStation2_1() {
        return station2_1;
    }
    public Station getStation2_2() {
        return station2_2;
    }


    public double getLenLeft() {
        return lenLeft;
    }

    public Trainset getCurrentTrain() {
        return currentTrain;
    }

    public double getLength() {
        return length;
    }
    //  setters
    public void setCurrentTrain(Trainset currentTrain) {
        this.currentTrain = currentTrain;
    }
}
