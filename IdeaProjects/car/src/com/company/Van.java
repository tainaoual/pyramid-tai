package com.company;

public class Van extends Vehicle {

    /**
     * Constructor
     */
    public Van(String model, double price) {
        this.setModel(model);
        this.setPrice(price);
        this.setDoor();
        this.setSeater();
        this.setWheel();
    }

    @Override
    void setSeater() {
        seats = 8;
    }

    @Override
    void setWheel() {
        wheels = 6;
    }

    @Override
    void setDoor() {
        doors = 5;
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
