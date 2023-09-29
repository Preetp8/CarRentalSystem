package models;


import java.io.Serializable;

public class Car implements Serializable {
    private int carId;
    private String brand;
    private String model;
    private double rentalCostPerDay;
    private boolean isAvailable;

    public Car(int carId, String brand, String model, double rentalCostPerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.rentalCostPerDay = rentalCostPerDay;
        this.isAvailable = true;
    }

    // Getters, setters, and other methods...''

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public double getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public void setRentalCostPerDay(double rentalCostPerDay) {
        this.rentalCostPerDay = rentalCostPerDay;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setIsAvaliable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }


}