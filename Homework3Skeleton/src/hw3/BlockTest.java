package hw3;

import api.Orientation;
import api.Direction;
public class BlockTest {
    public static void main(String[] args) {
        // Creating a horizontal block
        Block horizontalBlock = new Block(2, 3, 4, Orientation.HORIZONTAL);
        
        // Test initial state
        assert horizontalBlock.getFirstRow() == 2 : "Initial row should be 2";
        assert horizontalBlock.getFirstCol() == 3 : "Initial col should be 3";
        assert horizontalBlock.getLength() == 4 : "Length should be 4";
        assert horizontalBlock.getOrientation() == Orientation.HORIZONTAL : "Orientation should be HORIZONTAL";

        // Move the block right
        horizontalBlock.move(Direction.RIGHT);
        assert horizontalBlock.getFirstCol() == 4 : "Col after moving right should be 4";
        
        // Move the block left
        horizontalBlock.move(Direction.LEFT);
        assert horizontalBlock.getFirstCol() == 3 : "Col after moving left should be 3";

        // Reset the block
        horizontalBlock.reset();
        assert horizontalBlock.getFirstRow() == 2 : "Row after reset should be 2";
        assert horizontalBlock.getFirstCol() == 3 : "Col after reset should be 3";

        // Creating a vertical block
        Block verticalBlock = new Block(5, 6, 3, Orientation.VERTICAL);
        
        // Test initial state
        assert verticalBlock.getFirstRow() == 5 : "Initial row should be 5";
        assert verticalBlock.getFirstCol() == 6 : "Initial col should be 6";
        assert verticalBlock.getLength() == 3 : "Length should be 3";
        assert verticalBlock.getOrientation() == Orientation.VERTICAL : "Orientation should be VERTICAL";

        // Move the block up
        verticalBlock.move(Direction.UP);
        assert verticalBlock.getFirstRow() == 4 : "Row after moving up should be 4";
        
        // Move the block down
        verticalBlock.move(Direction.DOWN);
        assert verticalBlock.getFirstRow() == 5 : "Row after moving down should be 5";

        // Reset the block
        verticalBlock.reset();
        assert verticalBlock.getFirstRow() == 5 : "Row after reset should be 5";
        assert verticalBlock.getFirstCol() == 6 : "Col after reset should be 6";

        System.out.println("All test cases passed!");
    }
}
