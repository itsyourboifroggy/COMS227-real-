package hw4;

import api.Position;
import api.Cell;
import api.Icon;
import api.Piece;

public class QuotesPiece extends AbstractPiece {    
    
    // Constructor to initialize position and icons
    public QuotesPiece(Position position, Icon[] icons) {
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

    
    private void initializeCells() {
        cells[0].setPosition(new Position(0, 0)); 
        cells[1].setPosition(new Position(1, 0)); 
        cells[2].setPosition(new Position(0, 2)); 
        cells[3].setPosition(new Position(1, 2)); 
    }

    @Override
    public void cycle() {
        if (cells.length > 1) {
            Icon tempIcon = cells[cells.length - 1].getIcon(); // stores last icon
            for (int i = cells.length - 1; i > 0; i--) { //shifts icon
                cells[i].setIcon(cells[i - 1].getIcon());
            }
            cells[0].setIcon(tempIcon); // sets icon of first cell to last saved icon
        }
    }

    @Override
    public void transform() { 
        for (Cell cell : cells) {
            int row = cell.getRow();
            int col = cell.getCol();
            cell.setPosition(new Position(col, 2 - row));
        }
    }
}
