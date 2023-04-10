package Cars;

public class Refrigerated extends Freight{
    private final boolean electricity = true;
    private double weightNetto = 25;

    public Refrigerated(String n) {
        super(n);

    }
}
