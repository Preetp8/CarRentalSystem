package models;

import java.util.Date;

public class Rental {
    private int rentalId;
    private User user;
    private Car car;
    private Date startDate;
    private Date endDate;
    private int rentalDuration;
    private double totalCost;
    private String status;

    public Rental(int rentalId, User user, Car car, Date startDate, int rentalDuration) {
        this.rentalId = rentalId;
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.rentalDuration = rentalDuration;
        this.status = "Active";
        this.totalCost = calculateTotalCost();
        car.setIsAvaliable(false);
    }

    public double calculateTotalCost() {
        return car.getRentalCostPerDay() * rentalDuration;
    }

    public void endRental() {
        this.status = "Completed";
        car.setIsAvaliable(true);
        this.endDate = new Date(); // Assuming the rental ends now
    }

    public void cancelRental() {
        if ("Active".equals(this.status)) {
            this.status = "Cancelled";
            car.setIsAvaliable(true);
        }
    }

    // Getters, setters, and other methods...

    public int getRentalId() {
        return rentalId;
    }
    public User getUser() {
        return user;
    }
    public Car getCar() {
        return car;
    }
    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }
    public String getStatus() {
        return status;
    }
    public double getTotalCost() {
        return totalCost;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
