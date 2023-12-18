package edu.umb.cs680.hw12;


public class Car {
    // Private fields to store car information
    private String model;
    private String make;
    private int mileage;
    private float price;
    private int year;
    private int dominationCount = 0;

    // Constructor that initializes the car's properties
    public Car(String model, String make, int mileage, float price, int year) {
        this.model = model;
        this.make = make;
        this.mileage = mileage;
        this.price = price;
        this.year = year;
    }

    // Getter and setter methods for the 'model' field
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getter and setter methods for the 'make' field
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    // Getter and setter methods for the 'mileage' field
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    // Getter and setter methods for the 'price' field
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Getter and setter methods for the 'year' field
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public void setDominationCount(int count) {
        this.dominationCount = count;
    }

    // Override the toString method to provide a string representation of the car
    @Override
    public String toString() {
        return "Car [model=" + model + ", make=" + make + ", mileage=" + mileage + ", price=" + price + ", year=" + year + "]";
    }
}


    // private variables for Car Class
    