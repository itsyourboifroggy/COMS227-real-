package hw4;

import api.Position;
import api.Cell;
import api.Icon;
import api.Piece;

public class CirclingPiece extends AbstractPiece {

    private static final Position[] path = {
        new Position(5, 5), 
        new Position(5, 6),
        new Position(5, 7),
        new Position(6, 7),
        new Position(7, 7),
        new Position(7, 6),
        new Position(7, 5),
        new Position(6, 5)
    };

    private int counter = 0;

    // Updated constructor
    public CirclingPiece(Position position, Icon[] icons) {
        super(position);
        cells = new Cell[icons.length];
        for (int i = 0; i < icons.length; i++) {
            cells[i] = new Cell(icons[i], path[i % path.length]);
        }
    }

    @Override
    public Piece clone() {
        CirclingPiece cloned = (CirclingPiece) super.clone();
        cloned.cells = new Cell[cells.length];
        for (int i = 0; i < cells.length; ++i) {
            cloned.cells[i] = new Cell(cells[i]);
        }
        cloned.counter = this.counter;
        return cloned;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Cell[] getCells() {
        return cells;
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
        // Implement the cycling of icons if needed
    }

    
    }

