package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordsPerLine {
	public static void main(String[] args) throws FileNotFoundException
	  {
	    File file = new File("story.txt");
	    Scanner scanner = new Scanner(file);
	    int lineCount = 1;
	    int wordCount = 0;

	    while (scanner.hasNextLine())
	    {
	      String line = scanner.nextLine();
	      
	      String words[] = line.split("\\s+"); 
	      wordCount = words.length;
	      System.out.println(wordCount);
	      	
	      lineCount += 1;
	    }
	    
	    scanner.close();
	  }
}

