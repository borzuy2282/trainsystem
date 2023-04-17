import Cars.Car;
import com.sun.source.tree.ArrayAccessTree;

import java.io.*;
import java.util.ArrayList;

public class FileWriting extends Thread{
    private ArrayList<Trainset>trainsets;
    private Menu menu;
    private boolean stopper = true;

    public FileWriting(ArrayList<Trainset>trainsets, Menu menu){
        this.trainsets = trainsets;
        this.menu = menu;
    }


    public void setTrainsets(ArrayList<Trainset> trainsets) {
        this.trainsets = trainsets;
    }


    @Override
    public void run(){
            while(true) {
                try(FileWriter bw = new FileWriter("AppState.txt", true)){
                    if(trainsets.isEmpty()){
                        bw.write("No trainsets at this moment.\n");
                    }
                    for(Trainset t : sort()){
                        bw.write(t + "\n");
                    }
                    bw.write("\n");
                }catch (IOException e){
                    System.out.println("Something went wrong.");
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("We have problems wuth writing a file.");
                }
                if(!menu.isAlive()){
                    break;
                }
            }
    }
    public ArrayList<Trainset> sort(){
        ArrayList<Trainset>sorted = trainsets;
        for (int j = 0; j < sorted.size() - 1; j++) {
            for (int i = j; i < sorted.size() - 1; i++) {
                if (sorted.get(i).getLenLeft() > sorted.get(i + 1).getLenLeft()) {
                    Trainset tmp = sorted.get(i);
                    sorted.set(i, sorted.get(i + 1));
                    sorted.set(i+1, tmp);
                }
            }
        }
        return sorted;
    }
    public static String printingCars(Trainset t){
        ArrayList <Car> cars = t.getCars();
        if(cars == null){
            return "No car";
        }
        for (int i = 0; i < cars.size() - 1; i++) {
            if(cars.get(i).getWeightBrutto() > cars.get(i+1).getWeightBrutto()){
                Car tmp = cars.get(i);
                cars.set(i, cars.get(i+1));
                cars.set(i+1, tmp);
            }
        }
        StringBuilder returner = new StringBuilder();
        for (Car car : cars) {
            returner.append(car.getName()).append(" ").append(car.getWeightBrutto()).append(" ");
        }
        return returner.toString();
    }
//    public static void update(ArrayList <Trainset> trainsets){
//        ArrayList <Trainset> sorted = new ArrayList<>();
//        for(Trainset t : trainsets){
//            sorted.add(t);
//        }
//        for (int i = 0; i < sorted.size() - 1; i++) {
//            if (sorted.get(i).getLenLeft() > sorted.get(i + 1).getLenLeft()) {
//                Trainset tmp = sorted.get(i);
//                sorted.set(i, sorted.get(i + 1));
//                sorted.set(i + 1, tmp);
//            }
//        }
//
//
//        try{
//            BufferedWriter bw = new BufferedWriter(new FileWriter("AppState.txt"));
//            for(Trainset t : sorted){
//                bw.write(t.getIdTrainset() + ", length left: " + t.getLenLeft() + ". " + printingCars(t));
//                bw.newLine();
//            }
//            bw.newLine();
//            bw.newLine();
//            bw.flush();
//            bw.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
}
