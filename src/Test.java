import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Locomotive l1 = new Locomotive("Bluy");
        Station s1 = new Station("Centrum");
        Station s2 = new Station("Politechnika");
        Station s3 = new Station("Bemowo");
        Station s4 = new Station("Wawer");
        Station s5 = new Station("Radosc");
        Station s6 = new Station("Mokotow");
        Station s7 = new Station("Ratusz");
        Station s8 = new Station("Anin");
        Station s9 = new Station("Wschod");
        Station s10 = new Station("Zachod");
        Station s11 = new Station("Koszykowa");
        Station s12 = new Station("Kabaty");
        Station s13 = new Station("Sluzew");
        Station s14 = new Station("Miedzielesie");
        Station s15 = new Station("Mysz");
        Station s16 = new Station("Krakow");
        Trainset t1 = new Trainset("Zhuj", s1);
        Trainset t2 = new Trainset("Barabulka", s2);
        ArrayList <Trainset> t = new ArrayList<Trainset>();
        ArrayList <Station> a = (new ArrayList<Station>());
        a.add(s1);
        a.add(s2);
        a.add(s3);
        a.add(s4);
        s1.addCons(s2);
        s1.addCons(s3);
        s2.addCons(s4);

//        a.add(s5);
//        a.add(s6);
//        a.add(s7);
//        a.add(s8);
//        a.add(s9);
//        a.add(s10);
//        a.add(s11);
//        a.add(s12);
//        a.add(s13);
//        a.add(s14);
//        a.add(s15);
//        a.add(s16);
        t.add(t1);
        t.add(t2);
        t1.setAll(a);
        t1.setGlobalTo(s4);
        t2.setAll(a);
        t2.setGlobalTo(s5);
        t1.setAllTrainsets(t);
        t2.setAllTrainsets(t);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        t1.pick();
        System.out.println("Route is: ");
        for(Station s : t1.getRoute()){
            System.out.print(s.getName() + " ");
        }
//        thread1.start();
//        thread2.start();


    }
}
