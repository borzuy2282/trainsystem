import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        String [] namesSt = {"Centrum", "Rondo-ONZ", "Swiętokrzyska", "Politechnika", "Świętokrzyska-Głęboka", "Nowy - Świat - Uniwersytet", "Świętokrzyska - Północna", "Dworzec - Gdański", "Rondo - Radosława", "Stadion - Narodowy", "Rondo - Pragi", "Targówek - Wschodni", "Wileńska", "Trocka", "Marymoncka", "Słodowiec", "Wawrzyszew",  "Bemowo - Ratusz" , "Jelonki",  "Kabaty", "Kyiv-Pasazhyrskyi", "Lviv", "Kharkiv", "Dnipro", "Odessa", "Zaporizhia", "Donetsk", "Mykolaiv", "Vinnytsia", "Khmelnytskyi", "Poltava", "Chernivtsi", "Rivne", "Kryvyi Rih", "Sumy", "Ivano-Frankivsk", "Ternopil", "Lutsk", "Uzhhorod", "Chernihiv", "Kherson", "Zhytomyr", "Mariupol", "Kremenchuk", "Makiivka", "Simferopol", "Cherkasy", "Horishni Plavni", "Kamianets-Podilskyi", "Kovel", "Brovary", "Nikopol", "Kropyvnytskyi", "Berdiansk", "Pryluky", "Yevpatoria", "Yenakiieve", "Sloviansk", "Kramatorsk", "Melitopol", "Kerch", "Sevastopol", "Zhovti Vody", "Kolomyia", "Bila Tserkva", "Korsun-Shevchenkivskyi", "Feodosiya", "Lozova", "Shostka", "Fastiv", "Kamianske", "Lubny", "Odesa-Holovna", "Novohrad-Volynskyi", "Romny", "Berdyansk", "Balakliia", "Zaporizhia-Mala Vyska", "Yasynuvata", "Volnovakha", "Artemivsk", "Slovyansk", "Novovolynsk", "Znamianka", "Kakhovka", "Rokytne", "Polohy", "Kostiantynivka", "Pryazovske", "Korosten", "Novyi Rozdil", "Polonne", "Sarny", "Lubotyn", "Verkhovyna", "Dymer", "Hostomel", "Pokrovsk", "Novi Sanzhary", "Myronivka"};
        String [] namesTr = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "kiwi", "lemon", "mango", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "watermelon", "apricot", "blueberry", "coconut", "durian", "grapefruit", "lime", "lychee", "melon", "nectarine", "peach", "pear", "pineapple", "plum", "pomegranate", "rhubarb", "starfruit", "tomato", "avocado", "blackberry", "boysenberry", "cantaloupe", "clementine", "cranberry", "currant", "dragonfruit", "guava", "jackfruit", "jujube", "kumquat", "mangosteen", "mulberry", "passionfruit", "pawpaw", "persimmon", "plantain", "pummelo", "soursop", "ugli", "breadfruit", "ackee", "cherimoya", "longan", "sugarapple", "sapote", "sapodilla", "feijoa", "tamarillo", "horned melon", "prickly pear", "rambutan", "salak", "durian", "cactus fruit", "custard apple", "mangaba", "black sapote", "chayote", "cupuacu", "jabuticaba", "guava", "lucuma", "langsat", "wampee", "rollinia", "rambutan", "starfruit", "grumichama", "borojó", "jabuticaba", "caimito", "cupuacu", "burahol", "purple apple-berry", "babaco", "doum palm", "dragon fruit", "wild orange", "saguaro fruit", "prickly pear", "sugar plum", "sugar bomb", "fat boy", "big girl"};
//
        ArrayList <Trainset> t = new ArrayList<Trainset>();
        ArrayList <Station> a = (new ArrayList<Station>());
//        a.add(s1);
//        a.add(s2);
////        a.add(s3);
//        a.add(s4);
//        s1.addCons(s2);
////        s1.addCons(s3);
////        s3.addCons(s4);
//        s2.addCons(s4);

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
//        t.add(t1);
////        t.add(t2);
//        t1.setAll(a);
//        t1.setGlobalTo(s4);
//        t2.setAll(a);
//        t2.setGlobalTo(s1);
//        t1.setAllTrainsets(t);
//        t2.setAllTrainsets(t);
//        Thread thread1 = new Thread(t1);
//        Thread thread2 = new Thread(t2);


//        try {
//            t1.addCar(new Cars.Passenger("Zhuj"));
//        } catch (TooManyCarsException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            t1.addCar(new Cars.Post("Bluy"));
//        } catch (TooManyCarsException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            t1.addCar(new Cars.Restaurant("Chuj"));
//        } catch (TooManyCarsException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            t2.addCar(new Cars.Passenger("Zhuj"));
//        } catch (TooManyCarsException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            t2.addCar(new Cars.Post("Bluy"));
//        } catch (TooManyCarsException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            t2.addCar(new Cars.Restaurant("Chuj"));
//        } catch (TooManyCarsException e) {
//            throw new RuntimeException(e);
//        }
//        Locomotive l = new Locomotive("qwer");
        ArrayList <Locomotive> locomotives = new ArrayList<>();
//        locomotives.add(l1);
//        t1.setHead(l1);
        ArrayList <Cars.Car> cars = new ArrayList<>();
//        Restaurant r = new Restaurant("asdfg");
//        Passenger p = new Passenger("qee");
//        cars.add(p);
//        FileWriting test = new FileWriting(t);
//        Thread fileWrite = new Thread(test);
        Station.generationStation(a, namesSt);
        Trainset.generationTrainsets(t, locomotives, cars, a, namesTr);
//        Trainset t1 = new Trainset("Bluy", a.get(0));
//        Locomotive l2 = new Locomotive("qwer");
//        t1.setHead(l2);
//        t1.setGlobalTo(a.get(15));
//        t.add(t1);
//        locomotives.add(l2);
        Menu menu = new Menu(a, locomotives, cars, t);
        FileWriting fw = new FileWriting(menu.getTrainsets(), menu);
//        fileWrite.start();
//        thread1.start();
//        thread2.start();
       menu.start();
       fw.start();





    }
}
