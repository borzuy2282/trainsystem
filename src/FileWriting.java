import Cars.Car;
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
    @Override
    public void run(){
            while(true) {
                try(FileWriter bw = new FileWriter("AppState.txt", true)){
                    if(trainsets.isEmpty()){
                        bw.write("No trainsets at this moment.\n");
                    }else {
                        for (Trainset t : sort()) {
                            bw.write(t + "\n");
                        }
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
                if(sorted.get(i).getRoute() != null && sorted.get(i + 1).getRoute() != null) {
                    if (sorted.get(i).getLenLeft() > sorted.get(i + 1).getLenLeft()) {
                        Trainset tmp = sorted.get(i);
                        sorted.set(i, sorted.get(i + 1));
                        sorted.set(i + 1, tmp);
                    }
                }
            }
        }
        return sorted;
    }
    public static String printingCars(Trainset t){
        ArrayList <Car> cars = t.getCars();
        if(cars == null || cars.size() == 0){
            return "No car";
        }
        for (int i = 0; i < cars.size() - 1; i++) {
            if(cars.get(i).getWeightBrutto() > cars.get(i+1).getWeightBrutto()){
                Car tmp = cars.get(i);
                cars.set(i, cars.get(i+1));
                cars.set(i+1, tmp);
            }
        }
        String returner = "";
        for (Car car : cars) {
            returner += car;
        }
        return returner;
    }
}
