import java.util.Random;

public class Rail{
    private Trainset currentTrain;
    private Station station1;
    private Station station2;
    private final double length;
    private double lenLeft;

    public Rail(Station station1, Station station2, double length) {
        this.station1 = station1;
        this.station2 = station2;
        this.length = length;
        lenLeft = length;
    }
//  getters
    public Station getStation1() {
        return station1;
    }

    public Station getStation2() {
        return station2;
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

    public void setLenLeft(double lenLeft) {
        this.lenLeft = lenLeft;
    }

    public void setCurrentTrain(Trainset currentTrain) {
        this.currentTrain = currentTrain;
    }

/*    @Override
    public void run() {
        while(currentTrain != null){

            Random rand = new Random();
            int r = rand.nextInt(2);
            if (r == 0) {
                if (currentTrain.getSpeed() + currentTrain.getSpeed() * 0.03 < 200) {
                    currentTrain.setSpeed(currentTrain.getSpeed() + currentTrain.getSpeed() * 0.03);
                } else {
                    try {
                        throw new RailroadHazardException("Too much, we won't speed up");
                    } catch (RailroadHazardException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                if (currentTrain.getSpeed() - currentTrain.getSpeed() * 0.03 > 0) {
                    currentTrain.setSpeed(currentTrain.getSpeed() - currentTrain.getSpeed() * 0.03);
                } else {
                    try {
                        throw new RailroadHazardException("We can't stop, we will go on current speed");
                    } catch (RailroadHazardException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

//        funcs
    public boolean isConnect(Station s){
        return this.getStation1().equals(s) || this.getStation2().equals(s);
    }
 */
}
