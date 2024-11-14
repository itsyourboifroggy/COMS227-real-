package lab7;
import java.io.File;
public class Checkpoint2 {
	
	
	public static int countFiles(File file) {
		int totalFiles = 0;
		if (file.isFile()) {
			return 1;
		}
		if (file.isDirectory()) {
			totalFiles = 0;
			
			File[] files = file.listFiles();
				for (File f : files) {
					totalFiles += countFiles(f);
			}
		}
		
		return totalFiles;
	}
	public static int countPatterns(int n)
	{

	  int[] numPatterns = new int [n + 1];
		
	 numPatterns[0] = 1;
	 numPatterns[1] = 1;
	 numPatterns[2] = 1;
	 
	  for (int i = 3; i <= n; i++) {
		  numPatterns[i] = numPatterns[i-1] + numPatterns[i-3];
	  }
	  
	  return numPatterns[n];
	}
	
	public static void main(String[] args)
	  {
		File fileOrDir = new File("C:\\Users\\jack\\eclipse-workspace");
		System.out.println(countFiles(fileOrDir));
	    // Choose the directory you want to list.
	    // If running in Eclipse, "." will just be the current project directory.
	    // Use ".." to list the whole workspace directory, or enter a path to
	    // some other directory.
	    File rootDirectory = new File("../project6");

	    listAllFiles(rootDirectory);
	    System.out.println(countPatterns(25));
	  }
	  
	  /**
	   * Print the names of all items in the hierarchy located under 
	   * a given directory. If the given File object is not a directory, 
	   * just prints the file's name.
	   */
	  public static void listAllFiles(File f)
	  {
	    if (!f.isDirectory())
	    {
	      // Base case: f is a file, so just print its name
	      System.out.println(f.getName());
	    }
	    else
	    {
	      // Recursive case: f is a directory, so go through the 
	      // files and directories it contains, and recursively call
	      // this method on each one
	      System.out.println("+" + f.getName());
	      File[] files = f.listFiles();
	      for (int i = 0; i < files.length; ++i)
	      {
	        listAllFiles(files[i]);
	      }
	    }

	  }
	  
}
	    
	  
	
