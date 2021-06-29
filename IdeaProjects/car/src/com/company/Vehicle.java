package com.company;

public  abstract class Vehicle {


        protected double price;
        protected int seats;
        protected int wheels;
        protected int doors;
        protected String model;

        abstract void setSeater();
        abstract void setWheel();
        abstract void setDoor();
        abstract void setModel(String model);
        abstract void setPrice(double price);

        public int getSeater() {
            return seats;
        }

        public int getWheel() {
            return wheels;
        }

        public int getDoor() {
            return doors;
        }

        public String getModel() {
            return model;
        }

        public double getPrice() {
            return price;
        }
    }

// public door, private engine,
//    and protected tire