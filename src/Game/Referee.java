package Game;

// this class reads the entire board for wins and 3-matches.
// this class is connected with the Board class (or something)
// awesome name as well!
public class Referee {

	private boolean matchFound;

	/**
	 * constructor
	 */
	public Referee() {
		matchFound = false;
	}
	
	/**
	 * scans the board for 3-matches
	 */
	public void scan() {
		boolean match = false;

		// ******* Horizontal ********
		// scans the (1,1) , (1,2) , (1,3) grids for horizontal match
		// if all are X
		if (Board.boardGrid[0][0] == 'X' && Board.boardGrid[0][1] == 'X' && Board.boardGrid[0][2] == 'X') {
			match = true;
		}
		// (2,1) , (2,2) , (2,3)
		if (Board.boardGrid[1][0] == 'X' && Board.boardGrid[1][1] == 'X' && Board.boardGrid[1][2] == 'X') {
			match = true;
		}
		// (3,1) , (3,2) , (3,3)
		if (Board.boardGrid[2][0] == 'X' && Board.boardGrid[2][1] == 'X' && Board.boardGrid[2][2] == 'X') {
			match = true;
		}

		// ****** Vertical *********
		// (1,1) , (2,1) , (3,1)
		if (Board.boardGrid[0][0] == 'X' && Board.boardGrid[1][0] == 'X' && Board.boardGrid[2][0] == 'X') {
			match = true;
		}
		// (1,2) , (2,2), (3,2)
		if (Board.boardGrid[0][1] == 'X' && Board.boardGrid[1][1] == 'X' && Board.boardGrid[2][1] == 'X') {
			match = true;
		}
		// (1,3) , (2,3) , (3,3)
		if (Board.boardGrid[0][2] == 'X' && Board.boardGrid[1][2] == 'X' && Board.boardGrid[2][2] == 'X') {
			match = true;
		}

		// ****** Diagonal *********
		// top left to bottom right
		if (Board.boardGrid[0][0] == 'X' && Board.boardGrid[1][1] == 'X' && Board.boardGrid[2][2] == 'X') {
			match = true;
		}
		// top right to bottom left
		if (Board.boardGrid[0][2] == 'X' && Board.boardGrid[1][1] == 'X' && Board.boardGrid[2][0] == 'X') {
			match = true;
		}

		// same as above but looking O
		// ******* Horizontal ********
		if (Board.boardGrid[0][0] == 'O' && Board.boardGrid[0][1] == 'O' && Board.boardGrid[0][2] == 'O') {
			match = true;
		}
		if (Board.boardGrid[1][0] == 'O' && Board.boardGrid[1][1] == 'O' && Board.boardGrid[1][2] == 'O') {
			match = true;
		}
		if (Board.boardGrid[2][0] == 'O' && Board.boardGrid[2][1] == 'O' && Board.boardGrid[2][2] == 'O') {
			match = true;
		}

		// ******* Vertical ********
		if (Board.boardGrid[0][0] == 'O' && Board.boardGrid[1][0] == 'O' && Board.boardGrid[2][0] == 'O') {
			match = true;
		}
		// (1,2) , (2,2), (3,2)
		if (Board.boardGrid[0][1] == 'O' && Board.boardGrid[1][1] == 'O' && Board.boardGrid[2][1] == 'O') {
			match = true;
		}
		// (1,3) , (2,3) , (3,3)
		if (Board.boardGrid[0][2] == 'O' && Board.boardGrid[1][2] == 'O' && Board.boardGrid[2][2] == 'O') {
			match = true;
		}

		// ****** Diagonal *********
		// top left to bottom right
		if (Board.boardGrid[0][0] == 'O' && Board.boardGrid[1][1] == 'O' && Board.boardGrid[2][2] == 'O') {
			match = true;
		}
		// top right to bottom left
		if (Board.boardGrid[0][2] == 'O' && Board.boardGrid[1][1] == 'O' && Board.boardGrid[2][0] == 'O') {
			match = true;
		}

		// if a match is found, modify the matchFound variable
		if (match) {
			matchFound = true;
		}
	}

	/**
	 * gets the matchFound variable
	 * 
	 * @return the matchFound variable
	 */
	public boolean getResult() {
		return this.matchFound;
	}
}
