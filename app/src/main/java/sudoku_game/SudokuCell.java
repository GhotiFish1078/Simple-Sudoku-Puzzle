package sudoku_game;

import java.util.HashSet;
import java.util.Set;

import sudoku_game.exceptions.CannotEditException;
import sudoku_game.exceptions.InvalidNumberException;

/**
 * Represents a single sudoku cell
 */
public class SudokuCell {
    private int value;
    private boolean editable;
    private Set<Integer> notes;

    public SudokuCell(int value, boolean editable) {
        this.value = value;
        this.editable = editable;
        this.notes = new HashSet<>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) throws CannotEditException {
        if (editable) {
            this.value = value;
        } else {
            throw new CannotEditException("Cannot edit this cell");
        }
    }

    public void addMarking(int marking) throws InvalidNumberException {
        if (value < 1 || value > 9) {
            throw new InvalidNumberException("Invalid Number");
        }

        notes.add(marking);
    }

    public void removeMarking(int marking) {
        notes.remove(marking);
    }
}
