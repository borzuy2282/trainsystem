import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Locomotive l1 = new Locomotive("Bluy");
        Station s1 = new Station("Centrum");
        Station s2 = new Station("Politechnika");
        Station s3 = new Station("Bemowo");
        Station s4 = new Station("Wawer");
        Trainset t1 = new Trainset("Zhuj", s1);
        Trainset t2 = new Trainset("Barabulka", s1);
        ArrayList <Trainset> t = new ArrayList<Trainset>();
        ArrayList <Station> a = (new ArrayList<Station>());
        a.add(s1);
        a.add(s2);
        a.add(s3);
        a.add(s4);
        t.add(t1);
        t.add(t2);
        t1.setAll(a);
        t1.setGlobalTo(s2);
        t2.setAll(a);
        t2.setGlobalTo(s3);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();


    }
}
