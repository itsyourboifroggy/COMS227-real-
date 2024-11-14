package lab4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class LineNumberer {
	
	
		
		
public static void main(String[] args) throws FileNotFoundException
		  {
		    File file = new File("/home/jackthinkpad/apps/eclipse/lab6/story.txt");
		    Scanner scanner = new Scanner(file);
		    int lineCount = 1;

		    while (scanner.hasNextLine())
		    {
		      String line = scanner.nextLine();
		      System.out.print(lineCount + " ");
		      System.out.println(line);
		      lineCount += 1;
		    }
		    scanner.close();
		  }
}


