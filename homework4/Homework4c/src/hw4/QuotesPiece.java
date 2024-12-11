package hw4;

import api.Position;
import api.Cell;
import api.Icon;
import api.Piece;

public class QuotesPiece extends AbstractPiece {    
    
    private Cell[] cells;

    // Updated constructor
    public QuotesPiece(Position position, Icon[] icons) {
        super(position);
        cells = new Cell[icons.length];
        for (int i = 0; i < icons.length; i++) {
            cells[i] = new Cell(icons[i], new Position(0, 0)); // Initialize with default positions
        }
        initializeCells();
    }

    // Method to initialize cells' positions to form a specific shape
    private void initializeCells() {
        cells[0].setPosition(new Position(0, 0)); // Example position
        cells[1].setPosition(new Position(0, 1)); // Example position
        // Adjust these positions as needed to form the desired shape
    }

    @Override
    public Piece clone() {
        QuotesPiece cloned = (QuotesPiece) super.clone();
        cloned.cells = new Cell[cells.length];
        for (int i = 0; i < cells.length; ++i) {
            cloned.cells[i] = new Cell(cells[i]);
        }
        return cloned;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Cell[] getCells() {
        Cell[] copy = new Cell[cells.length];
        for (int i = 0; i < cells.length; ++i) {
            copy[i] = new Cell(cells[i]);
        }
        return copy;
    }

    @Override
    public Cell[] getCellsAbsolute() {
        Cell[] absoluteCells = new Cell[cells.length];
        for (int i = 0; i < cells.length; i++) {
            absoluteCells[i] = new Cell(cells[i]);
            absoluteCells[i].setPosition(new Position(
                cells[i].getRow() + position.row(),
                cells[i].getCol() + position.col()
            ));
        }
        return absoluteCells;
    }

    @Override
    public void setCells(Cell[] givenCells) {
        cells = new Cell[givenCells.length];
        for (int i = 0; i < givenCells.length; ++i) {
            cells[i] = new Cell(givenCells[i]);
        }
    }

    @Override
    public void shiftDown() {
        position = new Position(position.row() + 1, position.col());
    }

    @Override
    public void shiftLeft() {
        position = new Position(position.row(), position.col() - 1);
    }

    @Override
    public void shiftRight() {
        position = new Position(position.row(), position.col() + 1);
    }

    @Override
    public void cycle() {
        if (cells.length > 1) {
            Cell temp = cells[0];
            for (int i = 0; i < cells.length - 1; ++i) {
                cells[i] = cells[i + 1];
            }
            cells[cells.length - 1] = temp;
        }
    }

}
