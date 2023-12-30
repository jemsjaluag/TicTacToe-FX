package Game;

public abstract class Board {
	
	// this represents the board, 3x3
	protected static char[][] boardGrid;
	
	
	/**
	 * constructor
	 * this also creates the board grid that will contain the x and o
	 */
	public static void createBoard() {		
		// temp grid
		boardGrid = new char[3][3];
	}
	
	
	/**
	 * updates a square in the board
	 * @param x			x-axis
	 * @param y			y-axis
	 * @param player1	if true, player1 is playing and X should be created.
	 * 					if false, player2 is playing.
	 */
	public static void updateSquare(int x, int y, boolean player1) {
		// adjust to the indices that start at 0.
		x = x - 1;
		y = y - 1;
		if (boardGrid[y][x] != 'X' && boardGrid[y][x] != 'O') {
			if (player1) {
				boardGrid[y][x] = 'X';
			}
			else {
				boardGrid[y][x] = 'O';
			}
		}
	}
	
	public static char[][] getBoard() {
		return boardGrid;
	}
	
	/**
	 * clears the contents of the board
	 */
	public static void clear() {
		boardGrid = new char[3][3];
	}
	
	public static boolean occupied(int x, int y) {
		x = x - 1;
		y = y - 1;
		boolean toreturn = false;
		if (boardGrid[y][x] == 'X' || boardGrid[y][x] == 'O') {
			toreturn = true;
		}
		return toreturn;
	}
	
	public static boolean allOccupied() {
		boolean toreturn = true;
		for(int x = 1; x <= 3; x++) {
			for(int y = 1; y <= 3; y++) {
				if (!occupied(x, y)) {
					toreturn = false;
				}
			}
		}
		return toreturn;
	}
}
