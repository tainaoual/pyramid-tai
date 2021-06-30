package com.company;//package com.company;
import com.company.Board;
import com.company.Game;
import com.company.Owner;

import java.util.Arrays;
//import java.util.Random;
//import java.util.Scanner
import java.util.Random;
import java.util.Scanner;

public class  Main extends Game {

    public static void main(String[] args) {
        // write your code herepublic class battleshp {
   Game game;
    Scanner keyboard;
    String[][] playBoard = new String[8][8];
        Main run = new Main();
      run.start();

    /**
     * Initiate Game object and initiate the grid.
     */
//    public Main() {
//        game = new Game();
//        this.initPlayBoard();
//    }
//
//    public static void main(String[] args) {
//        Main run = new Main();
//        run.start();
//    }

        int[][] board = new int[9][9];//25*25 grid
        int[][] shps = new int[3][2];
        int[] shot = new int[2];//no of shot
        int attempts = 0, shotHit = 0;



       initBoard(board);//function for board
       initshps(shps);//function for ships

        System.out.println();

        do {
            showBoard(board);
            shot(shot);
            attempts++;

            if (hit(shot, shps)) { //hit function
                hint(shot, shps, attempts);
                shotHit++;
            } else
                hint(shot, shps, attempts);

            changeboard(shot, shps, board);


        } while (shotHit != 3);

        System.out.println("\n\n\n game finished! You hit 3 shps in " + attempts + " attempts");
        showBoard(board);
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

    public static void initshps(int[][] shps) {
        Random random = new Random();

        for (int shp = 0; shp < 2; shp++) {
            shps[shp][0] = random.nextInt(2);
            shps[shp][1] = random.nextInt(2);

//let's check if that shot was already tried
//if it was, just finish the do...while when a new pair was randomly selected
            for (int last = 0; last < shp; last++) {
                if ((shps[shp][0] == shps[last][0]) && (shps[shp][1] == shps[last][1]))
                    do {
                        shps[shp][0] = random.nextInt(2);
                        shps[shp][1] = random.nextInt(2);
                    } while ((shps[shp][0] == shps[last][0]) && (shps[shp][1] == shps[last][1]));
            }

        }
    }

    public static void shot(int[] shot) {
        Scanner input = new Scanner(System.in);

        System.out.print("rw: ");
        shot[0] = input.nextInt();
        shot[0]--;

        System.out.print("col: ");
        shot[1] = input.nextInt();
        shot[1]--;

    }

    public static boolean hit(int[] shot, int[][] shps) {

        for (int shp = 0; shp < shps.length; shp++) {
            if (shot[0] == shps[shp][0] && shot[1] == shps[shp][1]) {
                System.out.printf("You hit a shp located in (%d,%d)\n", shot[0] + 1, shot[1] + 1);
                return true;
            }
        }
        return false;
    }

    public static void hint(int[] shot, int[][] shps, int attempt) {
        int rw = 0,
                col = 0;

        for (int line = 0; line < shps.length; line++) {
            if (shps[line][0] == shot[0])
                rw++;
            if (shps[line][1] == shot[1])
                col++;
        }

        System.out.printf("\nHint %d: \nrw %d -> %d shps\n" +
                "col%d -> %d shps\n", attempt, shot[0] + 1, rw, shot[1] + 1, col);
    }

    public static void changeboard(int[] shot, int[][] shps, int[][] board) {
        if (hit(shot, shps))
            board[shot[0]][shot[1]] = 1;
        else
            board[shot[0]][shot[1]] = 0;
    }
    }
//import com.company.Board;
//import com.company.Game;
//import com.company.Owner;
//
//import java.util.Arrays;
//import java.util.Random;
//import java.util.Scanner;
//
//
//public class Main {
//
//    private Game game;
//    private Scanner keyboard;
//    private String[][] playBoard = new String[8][8];
//
//    /**
//     * Initiate Game object and initiate the grid.
//     */
//    public Main() {
//        game = new Game();
//        this.initPlayBoard();
//    }
//
//    public static void main(String[] args) {
//        Main run = new Main();
//        run.start();
//    }
//
//    private void initPlayBoard() {
//        for (String[] ss : this.playBoard) {
//            Arrays.fill(ss, "_");
//        }
//    }
//
//    /**
//     * start to play the game.
//     */
//    private void start() {
//        keyboard = new Scanner(System.in);
//        System.out.println("Hi, let’s play Battleship!");
//        this.initUserPieces();// initiate user's pieces
//        game.getReady();// initiate computer's pieces and other necessary information.
//        System.out.println("OK, the computer placed its ships and grenades at random. Let’s play.");
//        System.out.println();
//        while (!game.isDone()) {// before the game is done, keep calling position
//            while (game.getStepsCanBeUsedForNow() != 0) {// if the current player can play more than once.
//                System.out.print("Position of " + (game.getCurrentPlayer() == Owner.COMPUTER ? "my" : "your") + " rocket: ");
//                int[] position = { 0, 0 };
//                if (game.getCurrentPlayer() == Owner.COMPUTER) {// generate call position randomly
//                    Random r = new Random();
//                    position[0] = r.nextInt(8);
//                    char firstLetter = (char) (position[0] + (int) ('A'));
//                    position[1] = r.nextInt(8);
//                    System.out.println(firstLetter + "" + (position[1] + 1));
//                } else {
//                    String positionStr = keyboard.nextLine();
//                    char[] chars = positionStr.toUpperCase().toCharArray();
//                    if (this.isOutOfRange(chars)) {
//                        System.out.println("Sorry, coordinates outside the grid. Try again.");
//                        continue;
//                    }
//                    position = castCharToInt(positionStr.toUpperCase().toCharArray());
//                }
//
//                Board originalCell = game.shoot(position[0], position[1]);
//                if (!originalBor.isBeCalled()) {
//                    switch (getOwner()) {
//                        case 1:
//                            this.playBoard[position[0]][position[1]] = originalCell.getOwner() == Owner.COMPUTER ? "S" : "s";
//                            System.out.println("Ship hit.");
//                            break;
//                        case 2:
//                            this.playBoard[position[0]][position[1]] = originalCell.getOwner() == Owner.COMPUTER ? "G" : "g";
//                            System.out.println("Boom! Grenade.");
//                            break;
//                        case 3:
//                            this.playBoard[position[0]][position[1]] = "*";
//                            System.out.println("Nothing.");
//                            break;
//                    }
//                } else {
//                    System.out.println("Position already called.");
//                }
//                if (!game.isDone()) {
//                    this.printCurrentStates();
//                }
//            }
//            game.switchPlayer();
//
//        }
//        System.out.println((game.getWinner() == Owner.COMPUTER ? "I" : "You") + " win!");
//        this.printCurrentStates();
//        this.keyboard.close();
//    }
//
//    private int getOwner() {
//        return getOwner();
//    }
//
//    private void initUserPieces() {
//        this.placeShips();
//        this.placeGrenades();
//    }
//
//    /**
//     * Place user's ships, according the position offered by user.
//     */
//    private void placeShips() {
//        int haveGenerated = 0;
//        while (haveGenerated < Game.TOTAL_NUMBER_OF_SHIP) {
//            System.out.print("Enter the coordinates of your ship #" + (++haveGenerated) + ": ");
//            String positionStr = keyboard.nextLine();
//            char[] chars = positionStr.toUpperCase().toCharArray();
//            if (this.isOutOfRange(chars)) {
//                System.out.println("Sorry, coordinates outside the grid. Try again.");
//                --haveGenerated;
//                continue;
//            } else if (this.isOccupied(chars)) {
//                System.out.println("Sorry, coordinates already used. Try again.");
//                --haveGenerated;
//                continue;
//            } else {
//                int[] position = castCharToInt(chars);
//                game.setBoard(new Board(position[0], position[1],  Owner.USER));
//            }
//        }
//        System.out.println();
//    }
//
//    /**
//     * Place user's grenades, according the position offered by user.
//     */
//    private void placeGrenades() {
//        int haveGenerated = 0;
//        while (haveGenerated < Game.TOTAL_NUMBER_OF_GRENADE) {
//            System.out.print("Enter the coordinates of your grenade #" + (++haveGenerated) + ": ");
//            String positionStr = keyboard.nextLine();
//            char[] chars = positionStr.toUpperCase().toCharArray();
//            if (this.isOutOfRange(chars)) {
//                System.out.println("Sorry, coordinates outside the grid. Try again.");
//                --haveGenerated;
//                continue;
//            } else if (this.isOccupied(chars)) {
//                System.out.println("Sorry, coordinates already used. Try again.");
//                --haveGenerated;
//                continue;
//            } else {
//                int[] position = castCharToInt(chars);
//                game.setBoard(new Board(position[0], position[1],  Owner.USER));
//            }
//        }
//        System.out.println();
//    }
//
//    /**
//     * Check whether the input is out of range.
//     *
//     * @param chars
//     * @return true, if out of range; otherwise, false.
//     */
//    private boolean isOutOfRange(char[] chars) {
//        if ('A' <= chars[0] && chars[0] <= 'H' && 1 <= Character.getNumericValue(chars[1]) && Character.getNumericValue(chars[1]) <= 8) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    /**
//     * Check whether the target position is occupied.
//     *
//     * @param chars
//     * @return true, if occupied; otherwise, false.
//     */
//    private boolean isOccupied(char[] chars) {
//        int[] position = castCharToInt(chars);
//        return game.isOccupied(position[0], position[1]);
//    }
//
//    /**
//     * Convert input char to integer
//     *
//     * @param chars
//     * @return
//     */
//    private int[] castCharToInt(char[] chars) {
//        int x = (int) (chars[0]) - (int) ('A');
//        int y = Character.getNumericValue(chars[1]) - 1;
//        return new int[] { x, y };
//    }
//
//    /**
//     * Print out the current grid.
//     */
//    private void printCurrentStates() {
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.print(playBoard[i][j] + "\t");
//            }
//            System.out.println();
//        }
//    }
//
//}
//
