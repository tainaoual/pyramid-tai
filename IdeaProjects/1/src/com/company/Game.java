package com.company;


import java.util.Random;
public class Game {
    /**
     * Total number of ship that each player can place
     */
    public static final int TOTAL_NUMBER_OF_SHIP = 6;

    /**
     * Total number of grenade that each player can place
     */
    public static final int TOTAL_NUMBER_OF_GRENADE = 4;

    /**
     * The size of game board
     */
    private Board[][] cells = new Board[8][8];


    /**
     * The number of ship that computer possesses now
     */
    private int numberOfShipOfComputer;

    /**
     * The number of ship that user possesses now
     */
    private int numberOfShipOfUser;


    /**
     * Who's turn to call a position
     */
    private Owner currentPlayer;

    /**
     * How many times that the current player can call a position
     */
    private int stepsCanBeUsedForNow;

    /**
     * How many times that the following player can call a position
     */
    private int stepsCanBeUsedForNext;
    private Board[][] Boards;
    private Object Board;

    /**
     * Initiate all cells in the game board.
     */
    public Game() {
        this.initArray();
    }

    public Board[][] getBoards() {
        return Boards;
    }

    public Owner getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Owner currentOwner) {
        this.currentPlayer = currentOwner;
    }

    public int getStepsCanBeUsedForNow() {
        return stepsCanBeUsedForNow;
    }

    public String toString() {
        return "The user has " + this.numberOfShipOfUser + " left; the computer has " + this.numberOfShipOfComputer + " left.";
    }

    public boolean equals(Game other) {
        if (this == other) {
            return true;
        }
        if (null == other) {
            return false;
        }
        if (cells.equals(other.cells)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Place all pieces. Initiate the counters for game playing.
     */
    public void getReady() {
        this.placeComputerPieces();
        this.numberOfShipOfComputer = TOTAL_NUMBER_OF_SHIP;
        this.numberOfShipOfUser = TOTAL_NUMBER_OF_SHIP;
        this.currentPlayer = Owner.USER;
        this.stepsCanBeUsedForNow = 1;
        this.stepsCanBeUsedForNext = 1;
    }

    /**
     * Call a position
     *
     * @param x first dimension to be called.
     * @param y second dimension to be called.
     * @return the cell has be called.
     */
    public Board shoot(int x, int y) {
        Board Board = this.getBoard(x, y);
        Board originalCell = new Board(Board);
        if (isBeCalled()) {// If the rocket falls on a coordinate that has been called before, regardless of what was there before, nothing happens.
            --this.stepsCanBeUsedForNow;



              if (getOwner() == Owner.COMPUTER) {

                    --this.numberOfShipOfComputer;
                } else {
                    --this.numberOfShipOfUser;
                }
               // cell.setType(Type.NOTHING);
                currentPlayer.setOwner();
                --this.stepsCanBeUsedForNow;
            } else {// If the rocket falls on a position where there is nothing, then nothing happens, and the other player can shoot his/her rocket.
                --this.stepsCanBeUsedForNow;
            }

        return originalCell;

    }

    private boolean isBeCalled() {
    return true;
    }

    private int[] getOwner() {
       return getRandomPosition();
    }

    /**
     * Switch player when one players has finished.
     */
    public void switchPlayer() {
        this.currentPlayer = (this.currentPlayer == Owner.USER ? (Owner) Owner.COMPUTER : Owner.USER);
        this.stepsCanBeUsedForNow = this.stepsCanBeUsedForNext;
        this.stepsCanBeUsedForNext = 1;
    }

    /**
     * Check whether the ships from one player have sunk.
     *
     * @return true, if either side has no ship left; false, otherwise.
     */
    public boolean isDone() {
        return this.numberOfShipOfComputer == 0 || this.numberOfShipOfUser == 0;
    }

    /**
     * Get the winner of the game.
     *
     * @return the winner
     */
    public Owner getWinner() {
        if (this.isDone()) {
            return this.numberOfShipOfComputer == 0 ? Owner.USER : (Owner) Owner.COMPUTER;
        } else {
            return (Owner) Owner.NONE;
        }
    }

    /**
     * Get the cell from the input position
     *
     * @param x first dimension
     * @param y second dimension
     * @return the cell from the input position
     */
    public Board getBoard(int x, int y) {
        return this.Boards[x][y];
    }

    /**
     * Check whether the cell is occupied
     *
     * @param x first dimension
     * @param y second dimension
     * @return true, if occupied
     */
    public boolean isOccupied(int x, int y) {
        return !(this.cells[x][y].getOwner() == Owner.NONE);
    }

    /**
     * Put a cell into the cell array.
     * @param c the cell to be put
     */
    public void setBoard(Board c) {
        this.cells[c.getX()][c.getY()] = c;
    }

    private void initArray() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.cells[i][j] = new Board(i, j);
            }
        }
    }

    /**
     * Place computer's pieces
     */
    private void placeComputerPieces() {
        generateShipsForComputer();
        generateGrenadesForComputer();
    }

    /**
     * Place computer's ships randomly
     */
    private void generateShipsForComputer() {
        int shipHasBeenPlaced = 0;
        while (shipHasBeenPlaced < Game.TOTAL_NUMBER_OF_SHIP) {
            int[] position = this.getRandomPosition();
            if (this.isOccupied(position[0], position[1])) {
                continue;
            } else {
                this.setBoard(new Board(position[0], position[1],  Owner.COMPUTER));
                ++shipHasBeenPlaced;
            }
        }

    }

    /**
     * Place computer's grenades randomly
     */
    private void generateGrenadesForComputer() {
        int grenadeHasBeenPlaced = 0;
        while (grenadeHasBeenPlaced < Game.TOTAL_NUMBER_OF_GRENADE) {
            int[] position = this.getRandomPosition();
            if (this.isOccupied(position[0], position[1])) {
                continue;
            } else {
                this.setBoard(new Board(position[0], position[1], Owner.COMPUTER));
                ++grenadeHasBeenPlaced;
            }
        }
    }

    /**
     * Generate random number
     * @return
     */
    private int[] getRandomPosition() {
        Random r = new Random();
        int[] position = { r.nextInt(8), r.nextInt(8) };
        return position;
    }

    protected void start() {

    }
}
