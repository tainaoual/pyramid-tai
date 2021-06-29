package com.company;

public class Car extends Vehicle {

    /**
     * Constructor
     */
    public Car(String model, double price) {
        this.setModel(model);
        this.setPrice(price);
        this.setDoor();
        this.setSeater();
        this.setWheel();
    }

    @Override
    void setSeater() {
        seats = 5;
    }

    @Override
    void setWheel() {
        wheels = 4;
    }

    @Override
    void setDoor() {
        doors = 4;
    }

    @Override
    void setModel(String model) {
        this.model = model;
    }

    @Override
    void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "\n Model: " + getModel() + "\n Price: " + getPrice() + "\n Seater: " + getSeater()
                + "\n Wheel: " + getWheel() + "\n Door: " + getDoor();
    }
}