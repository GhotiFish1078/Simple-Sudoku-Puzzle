package sudoku_game;

import sudoku_game.exceptions.CannotEditException;
import sudoku_game.exceptions.InvalidNumberException;

public class SudokuBoard {
    private SudokuCell[][] playerBoard;

    public SudokuBoard(SudokuCell[][] playerBoard) {
        this.playerBoard = playerBoard;
    }

    public void insertValue(int row, int column, int value) {
        try {
            playerBoard[row][column].setValue(value);
        } catch (CannotEditException e) {
            System.err.println(e.getMessage());
        }
    }

    public void makeMarking(int row, int column, int marking) {
        try {
            playerBoard[row][column].addMarking(marking);
        } catch (InvalidNumberException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean isSolved(int[][] solutionBoard) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Checks the player board against the solution board
                if (playerBoard[i][j].getValue() != solutionBoard[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    // Return integer array of the board
    public int[][] returnBoard() {
        int[][] board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = playerBoard[i][j].getValue();
            }
        }

        return board;
    }
}
