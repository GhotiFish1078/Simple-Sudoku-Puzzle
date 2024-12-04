package sudoku_game;

public class SudokuGame {
    private SudokuBoard playerBoard;
    private int[][] solution;

    public SudokuGame(int[][] puzzle, int[][] solution) {
        this.solution = solution;

        SudokuCell[][] cells = new SudokuCell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boolean editable = (puzzle[i][j] == 0);
                cells[i][j] = new SudokuCell(puzzle[i][j], editable);
            }
        }

        this.playerBoard = new SudokuBoard(cells);
    }

    public boolean isSolved() {
        return playerBoard.isSolved(solution);
    }

    public void makeMove(int row, int col, int value) {
        playerBoard.insertValue(row, col, value);
    }

    public void makeMarking(int row, int col, int marking) {
        playerBoard.makeMarking(row, col, marking);
    }
}
