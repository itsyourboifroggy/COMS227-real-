package hw4;
import api.Position;
import api.Cell;
import api.Icon;
import api.Piece;

public class LShapedPiece extends AbstractPiece {
    
    public LShapedPiece(Position position, Icon[] icons) {
        super(position);
        if (icons.length != 4) {
            throw new IllegalArgumentException("LShapedPiece requires exactly 4 icons");
        }
        cells = new Cell[4];
        for (int i = 0; i < 4; i++) {
            cells[i] = new Cell(icons[i], new Position(0, 0));
        }
        initializeCells();
    }

    private void initializeCells() {
        
        cells[0].setPosition(new Position(0, 0));
        cells[1].setPosition(new Position(0, 1));
        cells[2].setPosition(new Position(1, 1));
        cells[3].setPosition(new Position(2, 1));
    }

    @Override
    public void cycle() {
        Icon tempIcon = cells[cells.length - 1].getIcon();
        for (int i = cells.length - 1; i > 0; i--) {
            cells[i].setIcon(cells[i - 1].getIcon());
        }
        cells[0].setIcon(tempIcon);
    }

    @Override
    public void transform() {
        
        for (int i = 0; i < cells.length; i++) {
            int currentRow = cells[i].getRow();
            int currentCol = cells[i].getCol();
            
            cells[i].setPosition(new Position(currentRow, 2 - currentCol));
        }
    }
}
