package hw2;

public class Tennis {
	// instance variables
	private String playerAName;
	private String playerBName;
	private int playerASets;
	private int playerBSets;
	private int playerAGames;
	private int playerBGames;
	private String playerAScore;
	private String playerBScore;
	private boolean isBestOfFive;
	private String callout;
	private boolean playerAServing;
	private int playerAPoints;
	private int playerBPoints;
	private String playerAGameState;
	private String playerBGameState;
	private boolean isPlayingTieBreaks;

	/*
	 * Everything below this line is given to students, either because we haven't
	 * covered loops yet, or because we want to ensure very precise formatting so
	 * that we can test by comparing strings which are printed by the same function.
	 */

	// constructor, initializes variables
	public Tennis(String playerAName, String playerBName, boolean isBestOfFive, boolean isPlayingTieBreaks,
			boolean isGrandSlam) {
		this.playerAName = playerAName;
		this.playerBName = playerBName;
		this.playerASets = 0;
		this.playerBSets = 0;
		this.playerAGames = 0;
		this.playerBGames = 0;
		this.playerAScore = " 0";
		this.playerBScore = " 0";
		this.isBestOfFive = isBestOfFive;
		this.callout = "";
		this.playerAServing = true;
		this.playerAPoints = 0;
		this.playerBPoints = 0;
		this.playerAGameState = "";
		this.playerBGameState = "";
		this.isPlayingTieBreaks = isPlayingTieBreaks;
		playerAGameState = "Love";
		playerAGameState = "Love";

	}

	/**
	 * Prints out what the scoreboard must indicate. It counts sets and games in a
	 * natural way, with whole numbers. However points within a game are counted
	 * using the nonconsecutive numbers 0, 15, 30, 40. When there is a deuce, it is
	 * indicated as 40 for both players. If one player has an advantage, their score
	 * is represented as "AD", while the other player's score is simultaneously
	 * indicated as "--". When counting score in tiebreak games, we simply use
	 * normal counting.
	 */
	@Override
	public String toString() {
		String playerAServingIndicator; // scoreboard
		String playerBServingIndicator;
		if (getPlayerAServing()) {
			playerAServingIndicator = "S>";
			playerBServingIndicator = "  ";
		} else {
			playerAServingIndicator = "  ";
			playerBServingIndicator = "S>";
		}
		String returned = String.format("%2s %-12s %2d %2d %6s\n%2s %-12s %2d %2d %6s\n", playerAServingIndicator,
				getPlayerAName(), getPlayerASets(), getPlayerAGames(), getPlayerAScore(), playerBServingIndicator,
				getPlayerBName(), getPlayerBSets(), getPlayerBGames(), getPlayerBScore());
		// System.out.println(returned);
		return returned;
	}

	// getters
	public String getPlayerAName() {
		return playerAName;
	}

	public String getPlayerBName() {
		return playerBName;
	}

	public boolean getPlayerAServing() {
		return playerAServing;
	}

	public int getPlayerASets() {
		return playerASets;
	}

	public int getPlayerBSets() {
		return playerBSets;
	}

	public int getPlayerAGames() {
		return playerAGames;
	}

	public int getPlayerBGames() {
		return playerBGames;
	}

	public String getPlayerAScore() {
		return playerAScore;
	}

	public String getPlayerBScore() {
		return playerBScore;
	}

	/**
	 * For testing purposes, converts a string of a's and b's into a sequence of
	 * calls to winPoint, using an argument of true if the corresponding character
	 * is an a, and false if the corresponding character is a b. Provides a
	 * convenient way to run many winPoint method calls with very concise notation.
	 *
	 * @param pointList - "script" that is converted into winPoint method calls.
	 */
	public void runPoints(String pointList) {
		for (int i = 0; i < pointList.length(); ++i) {
			if (pointList.charAt(i) == 'a') {
				winPoint(true);
			} else if (pointList.charAt(i) == 'b') {
				winPoint(false);
			} else {
				// skip the character silently
			}
		}
	}

	/**
	 * Simulates a point being won by a player and updates the game score
	 * accordingly.
	 *
	 * @param playerAWins True if player A wins the point, false if player B wins
	 *                    the point.
	 */
	public void winPoint(boolean playerAWins) {

		if (playerAWins) {
			playerAPoints += 1;
		} else {
			playerBPoints += 1;
		}

		if (playerAPoints == 0) {
			playerAScore = " 0";
			playerAGameState = "Love";
			callout = playerAGameState + "-" + playerBGameState;

		} else if (playerAPoints == 1) {
			playerAScore = "15";
			playerAGameState = "Fifteen";
			callout = playerAGameState + "-" + playerBGameState;
		} else if (playerAPoints == 2) {
			playerAScore = "30";
			playerAGameState = "Thirty";
			callout = playerAGameState + "-" + playerBGameState;
		} else if (playerAPoints == 3) {
			playerAScore = "40";
			playerAGameState = "Forty";
			callout = playerAGameState + "-" + playerBGameState;

		}

		if (playerBPoints == 0) {
			playerBScore = " 0";
			playerBGameState = "Love";
			callout = playerAGameState + "-" + playerBGameState;
		} else if (playerBPoints == 1) {
			playerBScore = "15";
			playerBGameState = "Fifteen";
			callout = playerAGameState + "-" + playerBGameState;
		} else if (playerBPoints == 2) {
			playerBScore = "30";
			playerBGameState = "Thirty";
			callout = playerAGameState + "-" + playerBGameState;
		} else if (playerBPoints == 3) {
			playerBScore = "40";
			playerBGameState = "Forty";
			callout = playerAGameState + "-" + playerBGameState;
		}
		if (playerAScore == playerBScore) {
			callout = playerAGameState + "-All";
			if (playerAPoints == 3 && playerBPoints == 3) {
				callout = "Deuce";
			}
		}
		if (playerAPoints >= 4 && playerAPoints - 2 >= playerBPoints) {
			playerAPoints = 0;
			playerBPoints = 0;
			winGame(true);
			playerAGameState = "Love";
			playerBGameState = "Love";
		} else if (playerBPoints >= 4 && playerBPoints - 2 >= playerAPoints) {
			playerAPoints = 0;
			playerBPoints = 0;
			winGame(false);
			playerAGameState = "Love";
			playerBGameState = "Love";
		}
	}

	// test method
	public void runGames(String gameList) {
		for (int i = 0; i < gameList.length(); ++i) {
			if (gameList.charAt(i) == 'a') {
				winGame(true);
			} else if (gameList.charAt(i) == 'b') {
				winGame(false);
			} else {
				// skip the character silently
			}
		}
	}

	/**
	 * Simulates a game being won by a player and updates the set score accordingly.
	 *
	 * @param playerAWins True if player A wins the game, false if player B wins the
	 *                    game.
	 */
	public void winGame(boolean playerAWins) {
		if (playerAWins) {
			playerAGames += 1;
			callout = "Game: " + playerAName;
			playerAPoints = 0;
			playerBPoints = 0;
			if (isPlayingTieBreaks && playerAGames >= 6 && playerBGames >= 6) {
				if (playerAPoints >= 7 && (playerAPoints - playerBPoints) >= 2 || playerAGames >= 7) {
					winSet(true);
					playerAGames = 0;
					playerBGames = 0;
					playerAPoints = 0;
					playerBPoints = 0;
				}
			}
			playerAScore = " 0";
			playerBScore = " 0";
			if (playerAGames >= 6 && playerAGames - playerBGames >= 2) {
				winSet(true);
				playerAGames = 0;
				playerBGames = 0;
			}

		} else {
			playerBGames += 1;
			callout = "Game: " + playerBName;
			if (isPlayingTieBreaks && playerBGames >= 6 && playerBGames >= 6) {
				if (playerBPoints >= 7 && (playerBPoints - playerAPoints) >= 2 || playerBGames >= 7) {
					winSet(true);
					playerBGames = 0;
					playerAGames = 0;
					playerBPoints = 0;
					playerAPoints = 0;
				}
			}
			playerAScore = " 0";
			playerBScore = " 0";
			if (playerBGames >= 6 && playerBGames - playerAGames >= 2) {
				winSet(false);
				playerBGames = 0;
				playerAGames = 0;
			}
		}
		playerAServing = !playerAServing; // should reverse the current value of this
	}

	/**
	 * For testing purposes, converts a string of a's and b's into a sequence of
	 * calls to winSet, using an argument of true if the corresponding character is
	 * an a, and false if the corresponding character is a b. Provides a convenient
	 * way to run many winSet method calls with very concise notation.
	 *
	 * @param setList - "script" that is converted into winSet method calls.
	 */
	public void runSets(String setList) {
		for (int i = 0; i < setList.length(); ++i) {
			if (setList.charAt(i) == 'a') {
				winSet(true);
			} else if (setList.charAt(i) == 'b') {
				winSet(false);
			} else {
				// skip the character silently
			}
		}
	}

	/**
	 * Simulates a set being won by a player and checks if the match is over.
	 *
	 * @param playerAWins True if player A wins the set, false if player B wins the
	 *                    set.
	 */
	public void winSet(boolean playerAWins) {
		if (playerAWins) {
			playerASets += 1;
			playerAGames = 0;
			playerBGames = 0;
			playerAPoints = 0;
			playerBPoints = 0;
			callout = "Game and Set: " + playerAName;
		} else {
			playerBSets += 1;
			playerAGames = 0;
			playerBGames = 0;
			playerAPoints = 0;
			playerBPoints = 0;
			callout = "Game and Set: " + playerBName;
		}
		if (isBestOfFive) {
			if (playerASets >= 3) {
				callout = "Game, Set and Match: " + playerAName;
			} else if (playerBSets >= 3) {
				callout = "Game, Set and Match: " + playerBName;
			}
		} else if (!isBestOfFive) {
			if (playerASets >= 2) {
				callout = "Game, Set and Match: " + playerAName;
			} else if (playerBSets >= 2) {
				callout = "Game, Set and Match: " + playerBName;
			}
		}
	}

	/**
	 * Retrieves the current callout message indicating the status of the match.
	 * 
	 * @return The current callout message.
	 */
	public String getCallOut() {
		return callout;
	}

}
