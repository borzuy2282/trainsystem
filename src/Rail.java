public class Rail {
    private Station station1;
    private Station station2;
    private final double length;
    private double lenLeft;

    public Rail(Station station1, Station station2) {
        this.station1 = station1;
        this.station2 = station2;
        length = Math.random() * 1000;
        lenLeft = length;
    }
//  getters
    public Station getStation1() {
        return station1;
    }

    public Station getStation2() {
        return station2;
    }

    public double getLength() {
        return length;
    }

    public double getLenLeft() {
        return lenLeft;
    }
//  setters

    public void setLenLeft(double lenLeft) {
        this.lenLeft = lenLeft;
    }

    //    funcs
//    public boolean isConnect(Station s){
//        return this.getStation1().equals(s) || this.getStation2().equals(s);
//    }
}
