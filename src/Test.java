import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Locomotive l1 = new Locomotive("Bluy");
        Station s1 = new Station("Centrum");
        Station s2 = new Station("Politechnika");
        Station s3 = new Station("Bemowo");
        Station s4 = new Station("Wawer");
        Trainset t1 = new Trainset("Zhuj", s1);
        ArrayList <Station> a = (new ArrayList<Station>());
        a.add(s1);
        a.add(s2);
        a.add(s3);
        a.add(s4);
        t1.setAll(a);
        t1.setGlobalTo(s2);
        t1.start();

    }
}
