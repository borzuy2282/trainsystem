import Cars.Car;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String [] namesSt = {"Centrum", "Rondo-ONZ", "Swiętokrzyska", "Politechnika", "Świętokrzyska-Głęboka", "Nowy - Świat - Uniwersytet", "Świętokrzyska - Północna", "Dworzec - Gdański", "Rondo - Radosława", "Stadion - Narodowy", "Rondo - Pragi", "Targówek - Wschodni", "Wileńska", "Trocka", "Marymoncka", "Słodowiec", "Wawrzyszew",  "Bemowo - Ratusz" , "Jelonki",  "Kabaty", "Kyiv-Pasazhyrskyi", "Lviv", "Kharkiv", "Dnipro", "Odessa", "Zaporizhia", "Donetsk", "Mykolaiv", "Vinnytsia", "Khmelnytskyi", "Poltava", "Chernivtsi", "Rivne", "Kryvyi Rih", "Sumy", "Ivano-Frankivsk", "Ternopil", "Lutsk", "Uzhhorod", "Chernihiv", "Kherson", "Zhytomyr", "Mariupol", "Kremenchuk", "Makiivka", "Simferopol", "Cherkasy", "Horishni Plavni", "Kamianets-Podilskyi", "Kovel", "Brovary", "Nikopol", "Kropyvnytskyi", "Berdiansk", "Pryluky", "Yevpatoria", "Yenakiieve", "Sloviansk", "Kramatorsk", "Melitopol", "Kerch", "Sevastopol", "Zhovti Vody", "Kolomyia", "Bila Tserkva", "Korsun-Shevchenkivskyi", "Feodosiya", "Lozova", "Shostka", "Fastiv", "Kamianske", "Lubny", "Odesa-Holovna", "Novohrad-Volynskyi", "Romny", "Berdyansk", "Balakliia", "Zaporizhia-Mala Vyska", "Yasynuvata", "Volnovakha", "Artemivsk", "Slovyansk", "Novovolynsk", "Znamianka", "Kakhovka", "Rokytne", "Polohy", "Kostiantynivka", "Pryazovske", "Korosten", "Novyi Rozdil", "Polonne", "Sarny", "Lubotyn", "Verkhovyna", "Dymer", "Hostomel", "Pokrovsk", "Novi Sanzhary", "Myronivka"};
        String [] namesTr = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "kiwi", "lemon", "mango", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "watermelon", "apricot", "blueberry", "coconut", "durian", "grapefruit", "lime", "lychee", "melon", "nectarine", "peach", "pear", "pineapple", "plum", "pomegranate", "rhubarb", "starfruit", "tomato", "avocado", "blackberry", "boysenberry", "cantaloupe", "clementine", "cranberry", "currant", "dragonfruit", "guava", "jackfruit", "jujube", "kumquat", "mangosteen", "mulberry", "passionfruit", "pawpaw", "persimmon", "plantain", "pummelo", "soursop", "ugli", "breadfruit", "ackee", "cherimoya", "longan", "sugarapple", "sapote", "sapodilla", "feijoa", "tamarillo", "horned melon", "prickly pear", "rambutan", "salak", "durian", "cactus fruit", "custard apple", "mangaba", "black sapote", "chayote", "cupuacu", "jabuticaba", "guava", "lucuma", "langsat", "wampee", "rollinia", "rambutan", "starfruit", "grumichama", "borojó", "jabuticaba", "caimito", "cupuacu", "burahol", "purple apple-berry", "babaco", "doum palm", "dragon fruit", "wild orange", "saguaro fruit", "prickly pear", "sugar plum", "sugar bomb", "fat boy", "big girl"};
        ArrayList<Trainset>trainsets = new ArrayList<>();
        ArrayList<Station>stations = new ArrayList<>();
        ArrayList<Locomotive>locomotives = new ArrayList<>();
        ArrayList<Car>cars = new ArrayList<>();
        Station.generationStation(stations, namesSt);
        Trainset.generationTrainsets(trainsets, locomotives, cars, stations, namesTr);
        Menu menu = new Menu(stations, locomotives, cars, trainsets);
        FileWriting fileWriter = new FileWriting(trainsets, menu);
        menu.start();
        fileWriter.start();
    }
}
