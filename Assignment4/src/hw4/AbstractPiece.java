
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
  private Position position;

  /**
   * Cells of this Piece
   */
  private Cell[] cells;
  
  /**
   * Constructs a piece with the given position.
   * Subclasses extending this class MUST call setCells to initialize
   * initial cell positions and icons.
   * @param position
   *   initial position for upper-left corner of bounding box
   */
  protected AbstractPiece(Position position)
  {
    this.position = position;
  }

  // YOUR CODE HERE TO IMPLEMENT THE Piece INTERFACE
    
  @Override
  public Piece clone()
  {
    try
    {
      AbstractPiece s = (AbstractPiece)super.clone();

      // make it into a deep copy (note there is no need to copy the position,
      // since Position is immutable)
      s.cells = new Cell[cells.length];
      for (int i = 0; i < cells.length; ++i)
      {
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
