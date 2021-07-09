package com.company;

import java.util.Scanner;

 public class Human {
    public   int playerHP;
   // public int monsterHP;
    public String humanwaipen;
    public String humanName;
    public void Human(){
        this.playerHP=100;
         this.humanName="tai";
         this.humanwaipen = "nife";
        int playerHP = 10;
        //int monsterHP = 15;
        String humanwaipen = "Knife";

        System.out.println("Your HP: "+ playerHP);
        System.out.println("Your Weapon: "+ humanwaipen);

        System.out.println("Please enter your name:");

        Scanner inputScanner= new Scanner(System.in);
        String humanName = inputScanner.nextLine();

        System.out.println("Hello " + humanName + ", let's start the game!");
    }

    public Human() {
        super();
    }

     @Override
     public String toString() {
         return "Human{" +
                 "playerHP=" + playerHP +
                 ", humanwaipen='" + humanwaipen + '\'' +
                 ", humanName='" + humanName + '\'' +
                 '}';
     }
 }


