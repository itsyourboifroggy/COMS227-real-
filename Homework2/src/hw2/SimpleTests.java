package hw2;

public class SimpleTests {
	    public static void main(String[] args) {
	        Tennis game = new Tennis("Alice", "Betty", false, false, false);
	        System.out.println(game);
	        
	        game.runSets("aaaaa");
	        game.runGames("ab");
	        game.runPoints("bb");
	        
	    }
}
