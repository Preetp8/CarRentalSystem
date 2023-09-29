package services;


import models.Rental;
import models.User;
import models.Car;
import utils.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarRentalSystem {
    private List<User> listOfUsers = new ArrayList<>();

    public static final String CAR_FILE = "cars.dat";
    private List<Car> listOfCars = new ArrayList<>();

    private List<Rental> listOfRentals = new ArrayList<>();

    public void registerUser(User user) {
        listOfUsers.add(user);
    }

    public void addCar(Car car) {
        listOfCars.add(car);
        FileUtil.saveCarsToFile(listOfCars, CAR_FILE);
    }

    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : listOfCars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public CarRentalSystem(){
        listOfCars = FileUtil.loadCarsFromFile(CAR_FILE);
    }

    // Other methods...
    public int generateUserId() {   //gen a unique user ID, using the size of the listOfUsers to get new ID
        return listOfUsers.size() + 1;
    }

    public int generateCarId() { //use the size of listOfCars to gen user with given ID
        return listOfCars.size() + 1;
    }

    public User findUserById(int userId) { //method searchs the list of Users for a user with the given ID
        for (User user : listOfUsers) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;  // User not found
    }

    public User findUserByName(String userName) { //method searchs the list of Users for a user with the given ID
        for (User user : listOfUsers) {
            if (Objects.equals(user.getUsername(), userName)) {
                return user;
            }
        }
        return null;  // User not found
    }

    public Car findCarById(int carId) { //searches listOfCars for a car with the given ID
        for (Car car : listOfCars) {
            if (car.getCarId() == carId) {
                return car;
            }
        }
        return null;  // Car not found
    }

    public Car findCarByModel(String carModel) { //searches listOfCars for a car with the given ID
        for (Car car : listOfCars) {
            if (Objects.equals(car.getModel(), carModel)) {
                return car;
            }
        }
        return null;  // Car not found
    }


    public int generateRentalId() {  // use size of listofRentals list to gen a new rentalID
        return listOfRentals.size() + 1;
    }

    public void addRental(Rental rental) { //method adds new rental to listOfRentals
        listOfRentals.add(rental);
    }

    public void returnCar(int returnUserId) {   //method marks the rental as complete and sets car's avaliability to true
        for (Rental rental : listOfRentals) {
            if (rental.getUser().getUserId() == returnUserId && "Active".equals(rental.getStatus())) {
                rental.endRental();
                break;
            }
        }
    }


}

