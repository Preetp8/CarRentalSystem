import models.User;
import models.Car;
import models.Rental;
import services.CarRentalSystem;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Car Rental System =====");
            System.out.println("1. Register User");
            System.out.println("2. Add Car");
            System.out.println("3. View Available Cars");
            System.out.println("4. Rent a Car");
            System.out.println("5. Return a Car");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    User user = new User(system.generateUserId(), username, password);
                    system.registerUser(user);
                    System.out.println("User registered successfully!");
                }
                case 2 -> {
                    System.out.print("Enter car brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter car model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter rental cost per day: ");
                    double cost = scanner.nextDouble();
                    Car car = new Car(system.generateCarId(), brand, model, cost);
                    system.addCar(car);
                    System.out.println("Car added successfully!");
                }
                case 3 -> {
                    List<Car> availableCars = system.getAvailableCars();
                    System.out.println("Available Cars:");
                    for (Car availableCar : availableCars) {
                        System.out.println(availableCar.getBrand() + " " + availableCar.getModel() + " - $" + availableCar.getRentalCostPerDay() + "/day");
                    }
                }
                case 4 -> {
                    System.out.print("Enter your user ID: ");
                    String userName = scanner.nextLine();
                    User rentingUser = system.findUserByName(userName);

                    if (rentingUser != null) {
                        System.out.print("Enter car Model to rent: ");
                        String carModel = scanner.nextLine();
                        Car rentingCar = system.findCarByModel(carModel);

                        if (rentingCar != null && rentingCar.isAvailable()) {
                            System.out.print("Enter rental duration (in days): ");
                            int duration = scanner.nextInt();
                            Rental rental = new Rental(system.generateRentalId(), rentingUser, rentingCar, new Date(), duration);
                            system.addRental(rental);
                            System.out.println("Car rented successfully!");

                        } else {
                            System.out.println("Car not available or invalid ID!");
                        }

                    } else {
                        System.out.println("Invalid user ID!");
                    }

                }

                case 5 -> {
                    System.out.print("Enter your user ID: ");
                    int returnUserId = scanner.nextInt();
                    system.returnCar(returnUserId);
                    System.out.println("Car returned successfully!");
                }
                case 6 -> {
                    System.out.println("Thank you for using the Car Rental System!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
