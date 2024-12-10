package lab9;

public class Book extends LibraryItem {
	public Book(String title) {
        super(title);
   } 

   public int getCheckOutPeriod() { 
       return 21; // three weeks
   }
}
