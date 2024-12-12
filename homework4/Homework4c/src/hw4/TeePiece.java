package hw4;

import api.Position;
import api.Cell;
import api.Icon;

public class TeePiece extends AbstractPiece {

    // Constructor to initialize position and icons
    public TeePiece(Position position, Icon[] icons) {
        super(position);
        if (icons.length != 4) {
        	throw new IllegalArgumentException();
        }
        cells = new Cell[icons.length];
        for (int i = 0; i < icons.length; i++) {
            cells[i] = new Cell(icons[i], new Position(0, 0)); 
        }
        initializeCells();
    }

    // Initialize cells' positions to form the T shape
    private void initializeCells() {
        cells[0].setPosition(new Position(0, 0)); 
        cells[1].setPosition(new Position(1, 0));
        cells[2].setPosition(new Position(1, 1)); 
        cells[3].setPosition(new Position(2, 0)); 
    }

    @Override
    public Position getPosition() {
        return position;
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
    public void cycle() {
        if (cells.length > 1) {
            Icon tempIcon = cells[cells.length - 1].getIcon();
            for (int i = cells.length - 1; i > 0; i--) {
                cells[i].setIcon(cells[i - 1].getIcon());
            }
            cells[0].setIcon(tempIcon);
        }
    }

    @Override
    public Cell[] getCells() {
        Cell[] copy = new Cell[cells.length];
        for (int i = 0; i < cells.length; ++i) {
            Position pos = new Position(cells[i].getRow(), cells[i].getCol());
            copy[i] = new Cell(cells[i].getIcon(), pos);
        }
        return copy;
    }



    @Override
    public TeePiece clone() {
        TeePiece cloned = (TeePiece) super.clone();
        cloned.cells = new Cell[cells.length];
        for (int i = 0; i < cells.length; ++i) {
            cloned.cells[i] = new Cell(cells[i]);
        }
        return cloned;
    }
}
