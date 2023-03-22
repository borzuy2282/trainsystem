public class Rail {
    private Station station1;
    private Station station2;
    private double length;

    public Rail(Station station1, Station station2) {
        this.station1 = station1;
        this.station2 = station2;
        length = Math.random() * 1000;
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
//    funcs
    public boolean isConnect(Station s){
        return this.getStation1().equals(s) || this.getStation2().equals(s);
    }
}
