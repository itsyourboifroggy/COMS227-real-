package hw1;

public class Printer {
	private int trayCapacity;
	//holds the value of the number of pages in a document
	private int nextPage = 0;
	//stores the value of every page printed
	private int totalPagesPrinted = 0;
	//total sheets in the tray currently
	private int sheetsAvailable = 0;
	private int documentPages = 0;
	//constructor assigns value to the capacity of the tray accessor
	public Printer(int trayCapacity) {
		this.trayCapacity = trayCapacity;
		
	}
	//starts a new job that copies documents given the page length mutator
	public void startPrintJob(int documentPages) {
		this.documentPages = documentPages;
		nextPage = 0;
		
	}
	
	
	// returns the count of all pages printed since the creation of it accessor
	public int getTotalPages() {
		return totalPagesPrinted;
	}
	//simulates printer printing a page adds to total page count with number of printed total goes to next page printed and then updates pages available
	public void printPage() { // mutator
		totalPagesPrinted += Math.min(sheetsAvailable, 1);
		nextPage = totalPagesPrinted % documentPages;
		sheetsAvailable -= 1;
	}
	// returns next page number to be printed accessor 
	public int getNextPage() {
		return nextPage;
	}
	// removed paper tray from printer making zero sheets available mutator
	public void removeTray() {
		trayCapacity = sheetsAvailable;
		sheetsAvailable = 0;
	}
	// replace the tray returning the original state of the tray before removal mutator
	public void replaceTray() {
		sheetsAvailable = trayCapacity;
	}
	//simulates removing the tray, then adding a given number of sheets then replacing mutator
	public void addPaper(int sheets) {
		sheetsAvailable += sheets;
		sheetsAvailable = Math.min(sheets, trayCapacity);
		
		
	}
	public int getSheetsAvailable() {
		return sheetsAvailable;
	}
	// simulates removing the tray removing sheets and replacingsheetsAvailable += sheets; (can't be below 0) mutator
	public void removePaper(int sheets) {
		sheetsAvailable -= sheets;
		sheetsAvailable = Math.min(sheets, trayCapacity);
	}
}
	
