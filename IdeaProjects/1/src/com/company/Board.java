package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Hit.hit;

public class Board  implements ActionListener {


    public static Object owner;

    public Board(int i, int i1, Object computer) {

    }

    public Board(int i, int j) {
    }

    public Board(Object board) {
    }

    public static void changeboard(int[] shot, int[][] shps, int[][] board) {
        if (hit(shot, shps))
            board[shot[0]][shot[1]] = 1;
        else
            board[shot[0]][shot[1]] = 0;
    }
    public static void initBoard(int[][] board) { //intigerboard
        for (int rw = 0; rw < 9; rw++)
            for (int col = 0; col < 9; col++)
                board[rw][col] = -1;
    }

    public static void showBoard(int[][] board) { //display board
        System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9");
        System.out.println();

        for (int rw = 0; rw < 9; rw++) {
            System.out.print((rw + 1) + "");
            for (int col = 0; col < 9; col++) {
                if (board[rw][col] == -1) {
                    System.out.print("\t" + "~");
                } else if (board[rw][col] == 0) {
                    System.out.print("\t" + "mm");
                } else if (board[rw][col] == 1) {
                    System.out.print("\t" + "bb");
                } else if (board[rw][col] == 2) {
                    System.out.print("\t" + "mm");
                }

            }
            System.out.println();
        }

    }

    public static Object getOwner() {
      return   getOwner();
    }

    public static void setOwner(Object none) {
    }

    private static void setOwner() {
    }

    public static boolean isBeCalled() {
        return isBeCalled();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public int getX() {
        return getX();

    }

    public int getY() {
        return getY();
    }
}

