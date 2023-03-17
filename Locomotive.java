public class Locomotive {
    private String name;
    private Station home;
    private double currentSpeed;
    Station globalFrom;
    Station from;
    Station to;
    Station globalTo;
    private String idLocomotive;
    private static int forId = 0;

    Locomotive(String n, Station h){
        this.name = n;
        this.home = h;
        this.from = h;
        this.idLocomotive = "L" +
    }
}
