package hw4;

import api.Position;
import api.Cell;
import api.Icon;

public class CirclingPiece extends AbstractPiece {

    private static final Position[] initialPositions = {
        new Position(0, 0),
        new Position(1, 0),
        new Position(2, 0),
        new Position(2, 1)
    };

    // Constructor to initialize position and icons
    public CirclingPiece(Position position, Icon[] icons) {
        super(position);
        if (icons.length != 4) {
            throw new IllegalArgumentException("Icon array must have exactly 4 elements.");
        }
        cells = new Cell[icons.length];
        for (int i = 0; i < icons.length; i++) {
            cells[i] = new Cell(icons[i], initialPositions[i]);
        }
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
    public void transform() {
        for (Cell cell : cells) {
            int row = cell.getRow();
            int col = cell.getCol();
            if (row == 0 && col < 2) {
                cell.setPosition(new Position(row, col + 1));
            } else if (col == 2 && row < 2) {
                cell.setPosition(new Position(row + 1, col));
            } else if (row == 2 && col > 0) {
                cell.setPosition(new Position(row, col - 1));
            } else if (col == 0 && row > 0) {
                cell.setPosition(new Position(row - 1, col));
            } else if (row == 2 && col == 1) {
                cell.setPosition(new Position(2, 2));
            } else if (row == 1 && col == 2) {
                cell.setPosition(new Position(0, 2));
            }
        }
    }
}
