import Cars.Car;

import java.io.*;
import java.util.ArrayList;

public class FileWriting implements Runnable{
    private ArrayList<Trainset>trainsets;
    private static final String filename = "AppState.txt";
    public FileWriting(ArrayList<Trainset>trainsets){
        this.trainsets = trainsets;
    }


    public void setTrainsets(ArrayList<Trainset> trainsets) {
        this.trainsets = trainsets;
    }
    @Override
    public void run(){
        while(true) {
            try {
                Thread.sleep(5000);
                update(trainsets);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public static String printingCars(Trainset t){
        ArrayList <Car> cars = t.getCars();
        if(cars == null){
            return "";
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
    public static void update(ArrayList <Trainset> trainsets){
        ArrayList <Trainset> sorted = new ArrayList<>();
        for(Trainset t : trainsets){
            sorted.add(t);
        }
        for (int i = 0; i < sorted.size() - 1; i++) {
            if (sorted.get(i).getLenLeft() > sorted.get(i + 1).getLenLeft()) {
                Trainset tmp = sorted.get(i);
                sorted.set(i, sorted.get(i + 1));
                sorted.set(i + 1, tmp);
            }
        }


        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for(Trainset t : sorted){
                bw.write(t.getIdTrainset() + ", length left: " + t.getLenLeft() + ". " + printingCars(t) + "\n");
            }
            bw.flush();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
