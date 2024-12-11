package hw4;

import api.Position;

import api.Cell;

import api.Icon;

import api.Piece;

public class RotatingSPiece extends AbstractPiece {

	private Cell[] cells;

	// Updated constructor

	public RotatingSPiece(Position position, Icon[] icons) {

		super(position);

		cells = new Cell[icons.length];

		for (int i = 0; i < icons.length; i++) {

			cells[i] = new Cell(icons[i], new Position(0, 0)); // Initialize with default positions

		}

		initializeCells();

	}

	// Method to initialize cells' positions to form a specific shape

	private void initializeCells() {

		// Define the initial positions of the cells to form the rotating S shape

		cells[0].setPosition(new Position(0, 0));

		cells[1].setPosition(new Position(0, 1));

		cells[2].setPosition(new Position(1, 1));

		cells[3].setPosition(new Position(1, 2));

	}

	@Override

	public Piece clone() {

		RotatingSPiece cloned = (RotatingSPiece) super.clone();

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
