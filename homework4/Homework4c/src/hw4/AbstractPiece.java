package hw4;

import api.Cell;
import api.Icon;
import api.Piece;
import api.Position;

/**
 * Abstract superclass for implementations of the Piece interface.
 */
public abstract class AbstractPiece implements Piece
{
  /**
   * Position of this Piece
   */
  public Position position;

  /**
   * Cells of this Piece
   */
  public Cell[] cells;
  
  /**
   * Constructs a piece with the given position.
   * Subclasses extending this class MUST call setCells to initialize
   * initial cell positions and icons.
   * @param position
   *   initial position for upper-left corner of bounding box
   */
  public AbstractPiece(Position position)
  {
    this.position = position;
  }

  /**
   * Returns the position of this piece (upper-left corner of its bounding box).
   * 
   * @return position of this shape
   */
  public Position getPosition()
  {
    return position;
  }

  /**
   * Returns a deep copy of the Cell objects in this piece. The cell positions are relative to the upper-left corner of its bounding box.
   * 
   * @return copy of the cells in this piece
   */
  public Cell[] getCells()
  {
    Cell[] copy = new Cell[cells.length];
    for (int i = 0; i < cells.length; ++i) {
      copy[i] = new Cell(cells[i]);
    }
    return copy;
  }

  /**
   * Returns a new array of Cell objects representing the icons in this piece with their absolute positions (relative positions plus position of bounding box).
   * 
   * @return copy of the cells in this piece, with absolute positions
   */
  public Cell[] getCellsAbsolute()
  {
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

  /**
   * Sets the cells in this piece, making a deep copy of the given array.
   * 
   * @param givenCells new cells for this piece
   */
  public void setCells(Cell[] givenCells)
  {
    cells = new Cell[givenCells.length];
    for (int i = 0; i < givenCells.length; ++i) {
      cells[i] = new Cell(givenCells[i]);
    }
  }

  /**
   * Shifts the position of this piece down (increasing the row) by one. No bounds checking is done.
   */
  public void shiftDown()
  {
    position = new Position(position.row() + 1, position.col());
    setCells(cells); // Recalculate cells based on the new position
  }

  /**
   * Shifts the position of this piece left (decreasing the column) by one. No bounds checking is done.
   */
  public void shiftLeft()
  {
    position = new Position(position.row(), position.col() - 1);
    setCells(cells); // Recalculate cells based on the new position
  }

  /**
   * Shifts the position of this piece right (increasing the column) by one. No bounds checking is done.
   */
  public void shiftRight()
  {
    position = new Position(position.row(), position.col() + 1);
    setCells(cells); // Recalculate cells based on the new position
  }

  /**
   * Transforms this piece without altering its position according to the rules of the game to be implemented. Typical operations would be rotation or reflection. No bounds checking is done.
   */
  public void transform() {
      
      for (int i = 0; i < cells.length; i++) {
          int currentRow = cells[i].getRow();
          int currentCol = cells[i].getCol();
          
          cells[i].setPosition(new Position(currentRow, 2 - currentCol));
      }
      }

  /**
   * Cycles the icons within the cells of this piece. Each icon is shifted forward to the next cell (in the original ordering of the cells). The last icon wraps around to the first cell.
   */
  public void cycle()
  {
    Cell temp = cells[cells.length - 1];
    for (int i = cells.length - 1; i > 0; --i) {
      cells[i] = cells[i - 1];
    }
    cells[0] = temp;
  }

  /**
   * Returns a deep copy of this object having the correct runtime type.
   * 
   * @return a deep copy of this object
   */
  @Override
  public Piece clone()
  {
    try
    {
      AbstractPiece s = (AbstractPiece) super.clone();

      // make it into a deep copy (note there is no need to copy the position,
      // since Position is immutable)
      s.cells = new Cell[cells.length];
      for (int i = 0; i < cells.length; ++i) {
        s.cells[i] = new Cell(cells[i]);
      }
      return s;
    }
    catch (CloneNotSupportedException e)
    {
      // can't happen
      return null;
    }
  }
}
