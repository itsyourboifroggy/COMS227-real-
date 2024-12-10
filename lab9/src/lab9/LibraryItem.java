package lab9;

public abstract class LibraryItem  implements Item {
	 private String title; 
	    protected LibraryItem(String title) {
	        this.title = title;
	    } 

	    public String getTitle() {
	        return title;
	    } 

	    public abstract int getCheckOutPeriod();
	} 

