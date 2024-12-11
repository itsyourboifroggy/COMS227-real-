package hw4;

import api.Position;
import api.Cell;
import api.Icon;

public class TeePiece extends AbstractPiece {

    // Constructor to initialize position and icons
    public TeePiece(Position position, Icon[] icons) {
        super(position);
        cells = new Cell[icons.length];
        for (int i = 0; i < icons.length; i++) {
            cells[i] = new Cell(icons[i], new Position(0, 0)); // Initialize with default positions
        }
        initializeCells();
    }

    // Initialize cells' positions to form the T shape
    private void initializeCells() {
        cells[0].setPosition(new Position(0, 0)); // Center of the T
        cells[1].setPosition(new Position(1, 0)); // Bottom-center of the T
        cells[2].setPosition(new Position(1, 1)); // Left-center of the T
        cells[3].setPosition(new Position(2, 0)); // Right-center of the T
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

    @Override
    public void cycle() {
        if (cells.length > 1) {
            Icon tempIcon = cells[0].getIcon();
            for (int i = 0; i < cells.length - 1; ++i) {
                cells[i].setIcon(cells[i + 1].getIcon());
            }
            cells[cells.length - 1].setIcon(tempIcon);
        }
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
