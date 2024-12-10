package lab9;

public class ReferenceBook extends Book {
	public ReferenceBook(String title) {
        super(title);
    } 

    public String getTitle() {
        return "REF: " + super.getTitle();
    } 

    public int getCheckOutPeriod() {
        return 0; // reference books don't circulate
    } 
}
