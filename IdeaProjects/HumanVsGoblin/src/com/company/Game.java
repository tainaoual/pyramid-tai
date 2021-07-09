package com.company;
import java.util.Scanner;
public class Game {

    private int playerHP;
    private int monsterHP;
    private String humanwaipen;
    private String humanName;


    public void playerSetUp() {
        this.playerHP = 10;
        this.monsterHP = 15;
        this.humanwaipen = "Knife";

    }

    public void townGate() {
    }


    public Game() {
        super();
    }

    @Override
    public String toString() {
        return "Game{" +
                "playerHP=" + playerHP +
                ", monsterHP=" + monsterHP +
                ", humanwaipen='" + humanwaipen + '\'' +
                ", humanName='" + humanName + '\'' +
                '}';
    }
}