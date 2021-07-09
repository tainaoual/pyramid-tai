package com.company;

import java.util.Scanner;

public class crossRoad {
    public static Object ending;

    public void crossRoad() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are at a crossroad. If you go south, you will go back to the town.\n\n");
        System.out.println("1: Go north");
        System.out.println("2: Go east");
        System.out.println("3: Go south");
        System.out.println("4: Go west");
        System.out.println("\n------------------------------------------------------------------\n");

        Scanner inputScanner = new Scanner(System.in);
        int choice = inputScanner.nextInt();

        if (choice == 1) {
            north();
        } else if (choice == 2) {
            east();
        } else if (choice == 3) {
            new lindGate();
        } else if (choice == 4) {
            west();
        } else {
            crossRoad();
        }
    }

    private void west() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You encounter a goblin!\n");
        System.out.println("1: Fight");
        System.out.println("2: Run");
        System.out.println("\n------------------------------------------------------------------\n");

        Scanner inputScanner = new Scanner(System.in);
        int choice = inputScanner.nextInt();

        if (choice == 1) {
            fight();
        } else if (choice == 2) {
            crossRoad();
        } else {
            west();
        }
    }

    private void fight() {
    }


    private void east() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You walked into a forest and found a  goblins!");
        String humanwaipen = "goblin";
        System.out.println("Your Weapon: " + humanwaipen);
        System.out.println("\n\n1: Go back to the crossroad");
        System.out.println("\n------------------------------------------------------------------\n");

        Scanner inputScanner = new Scanner(System.in);
        int choice = inputScanner.nextInt();

        if (choice == 1) {
            crossRoad();
        } else {
            east();
        }
    }

    private void north() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("There is a river. You drink the water and rest at the riverside.");

        System.out.println("\n\n1: Go back to the crossroad");
        System.out.println("\n------------------------------------------------------------------\n");

        Scanner inputScanner = new Scanner(System.in);
        int choice = inputScanner.nextInt();

        if (choice == 1) {
            crossRoad();
        } else {
            north();
        }
    }

    public crossRoad() {
        super();
    }

    @Override
    public String toString() {
        return "crossRoad{}";
    }
}
