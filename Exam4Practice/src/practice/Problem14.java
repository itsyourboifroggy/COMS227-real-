package practice;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem14 {
    
    // Prints each name in the file followed by the total percentage of votes
    public static void printPercentages(String filename) throws FileNotFoundException {
        // ...details not shown...
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean thing = true;
        
        while (thing) {
            System.out.println("Enter filename for votes: ");
            String filename = scanner.next();
            
            try {
                printPercentages(filename);
                thing = false; 
            } catch (FileNotFoundException e) {
                System.out.println("No such file.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid file format.");
            }
        }
        thing = false;
        
    }
}
