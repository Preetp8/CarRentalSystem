package utils;

import models.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static void saveCarsToFile(List<Car> cars, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> loadCarsFromFile(String filename) {
        List<Car> cars = new ArrayList<>();
        File file = new File(filename);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                cars = (List<Car>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return cars;
    }
}
