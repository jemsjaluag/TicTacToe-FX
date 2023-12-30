package GUI;

import Game.Board;
import Game.Referee;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Interface extends Application {

	private Referee ref;
	private static boolean player1 = true; // player 1 will use X
	protected static boolean GameOn = true;

	/**
	 * main GUI creation
	 */
	public void start(Stage primaryStage) {

		int height = 400;
		int width = 400;
		// sizes of the box. Fine tuned to perfection.
		int boxSizeHeight = (height - 60) / 3;
		int boxSizeWidth = (width - 60) / 3;
		// calls a referee to the game.
		ref = new Referee();
		Board.createBoard();

		// main panel
		GridPane mainPane = new GridPane();
		mainPane.setPrefSize(width, height);
		mainPane.setPadding(new Insets(10));
		mainPane.setHgap(10);
		mainPane.setVgap(10);

		/*
		 * TODO -> start creating the action events for pressing the boxes. - ideas: -
		 * maybe change the pane of that box from the one created in the GridContents
		 * class
		 * 
		 * -> make the core of the game as well. i.e. alternating turns for X and O
		 */

		// row 1
		Pane pane_11 = new Pane();
		pane_11.setPrefSize(boxSizeWidth, boxSizeHeight);
		pane_11.getStyleClass().add("pane");

		Pane pane_12 = new Pane();
		pane_12.setPrefSize(boxSizeWidth, boxSizeHeight);
		pane_12.getStyleClass().add("pane");

		Pane pane_13 = new Pane();
		pane_13.setPrefSize(boxSizeWidth, boxSizeHeight);
		pane_13.getStyleClass().add("pane");

		// row 2
		Pane pane_21 = new Pane();
		pane_21.setPrefSize(boxSizeWidth, boxSizeHeight);
		pane_21.getStyleClass().add("pane");

		// TEMP & TESTING
		DropShadow glow = new DropShadow();
		glow.setOffsetX(0f);
		glow.setOffsetY(0f);
		glow.setHeight(50);
		glow.setWidth(50);
		if (player1) {
			glow.setColor(Color.RED);
		}
		else {
			glow.setColor(Color.BLUE);
		}
		
		Label coordinateHunter = new Label();
		Pane pane_22 = new Pane(coordinateHunter);
		pane_22.setPrefSize(boxSizeWidth, boxSizeHeight);
		pane_22.getStyleClass().add("pane");
		pane_22.setEffect(glow);

		Pane pane_23 = new Pane();
		pane_23.setPrefSize(boxSizeWidth, boxSizeHeight);
		pane_23.getStyleClass().add("pane");

		// row 3
		Pane pane_31 = new Pane();
		pane_31.setPrefSize(boxSizeWidth, boxSizeHeight);
		pane_31.getStyleClass().add("pane");

		Pane pane_32 = new Pane();
		pane_32.setPrefSize(boxSizeWidth, boxSizeHeight);
		pane_32.getStyleClass().add("pane");

		Pane pane_33 = new Pane();
		pane_33.setPrefSize(boxSizeWidth, boxSizeHeight);
		pane_33.getStyleClass().add("pane");

		// adding the boxes
		// column, row
		mainPane.add(pane_11, 1, 1);
		mainPane.add(pane_12, 2, 1);
		mainPane.add(pane_13, 3, 1);
		mainPane.add(pane_21, 1, 2);
		mainPane.add(pane_22, 2, 2);
		mainPane.add(pane_23, 3, 2);
		mainPane.add(pane_31, 1, 3);
		mainPane.add(pane_32, 2, 3);
		mainPane.add(pane_33, 3, 3);

		// when a box is selected
		mainPane.setOnMouseMoved(event -> {
			double x = event.getSceneX();
			double y = event.getSceneY();

			if (x > getStartX(1) && x < getStartX(1) + 113 && y > getStartX(1) && y < getStartX(1) + 113
					&& player1) {
				pane_11.getStyleClass().clear();
				pane_11.getStyleClass().add("selectedPaneRed");
			}
			else if (x > getStartX(1) && x < getStartX(1) + 113 && y > getStartX(1) && y < getStartX(1) + 113
					&& !player1) {
				pane_11.getStyleClass().clear();
				pane_11.getStyleClass().add("selectedPaneBlue");
			}
			else {
				pane_11.getStyleClass().clear();
				pane_11.getStyleClass().add("pane");
			}

			if (x > getStartX(2) && x < getStartX(2) + 113 && y > getStartX(1) && y < getStartX(1) + 113
					&& player1) {
				pane_12.getStyleClass().clear();
				pane_12.getStyleClass().add("selectedPaneRed");
			}
			else if (x > getStartX(2) && x < getStartX(2) + 113 && y > getStartX(1) && y < getStartX(1) + 113
					&& !player1) {
				pane_12.getStyleClass().clear();
				pane_12.getStyleClass().add("selectedPaneBlue");
			} else {
				pane_12.getStyleClass().clear();
				pane_12.getStyleClass().add("pane");
			}

			if (x > getStartX(3) && x < getStartX(3) + 113 && y > getStartX(1) && y < getStartX(1) + 113
					&& player1) {
				pane_13.getStyleClass().clear();
				pane_13.getStyleClass().add("selectedPaneRed");
			}
			else if (x > getStartX(3) && x < getStartX(3) + 113 && y > getStartX(1) && y < getStartX(1) + 113
					&& !player1) {
				pane_13.getStyleClass().clear();
				pane_13.getStyleClass().add("selectedPaneBlue");
			} else {
				pane_13.getStyleClass().clear();
				pane_13.getStyleClass().add("pane");
			}

			if (x > getStartX(1) && x < getStartX(1) + 113 && y > getStartX(2) && y < getStartX(2) + 113
					&& player1) {
				pane_21.getStyleClass().clear();
				pane_21.getStyleClass().add("selectedPaneRed");
			}
			else if (x > getStartX(1) && x < getStartX(1) + 113 && y > getStartX(2) && y < getStartX(2) + 113
					&& !player1) {
				pane_21.getStyleClass().clear();
				pane_21.getStyleClass().add("selectedPaneBlue");
			} else {
				pane_21.getStyleClass().clear();
				pane_21.getStyleClass().add("pane");
			}

			if (x > getStartX(2) && x < getStartX(2) + 113 && y > getStartX(2) && y < getStartX(2) + 113
					&& player1) {
				pane_22.getStyleClass().clear();
				pane_22.getStyleClass().add("selectedPaneRed");
			}
			else if (x > getStartX(2) && x < getStartX(2) + 113 && y > getStartX(2) && y < getStartX(2) + 113
					&& !player1) {
				pane_22.getStyleClass().clear();
				pane_22.getStyleClass().add("selectedPaneBlue");
			} else {
				pane_22.getStyleClass().clear();
				pane_22.getStyleClass().add("pane");
			}

			if (x > getStartX(3) && x < getStartX(3) + 113 && y > getStartX(2) && y < getStartX(2) + 113
					&& player1) {
				pane_23.getStyleClass().clear();
				pane_23.getStyleClass().add("selectedPaneRed");
			}
			else if (x > getStartX(3) && x < getStartX(3) + 113 && y > getStartX(2) && y < getStartX(2) + 113
					&& !player1) {
				pane_23.getStyleClass().clear();
				pane_23.getStyleClass().add("selectedPaneBlue");
			} else {
				pane_23.getStyleClass().clear();
				pane_23.getStyleClass().add("pane");
			}

			if (x > getStartX(1) && x < getStartX(1) + 113 && y > getStartX(3) && y < getStartX(3) + 113
					&& player1) {
				pane_31.getStyleClass().clear();
				pane_31.getStyleClass().add("selectedPaneRed");
			} 
			else if (x > getStartX(1) && x < getStartX(1) + 113 && y > getStartX(3) && y < getStartX(3) + 113
					&& !player1) {
				pane_31.getStyleClass().clear();
				pane_31.getStyleClass().add("selectedPaneBlue");
			} else {
				pane_31.getStyleClass().clear();
				pane_31.getStyleClass().add("pane");
			}

			if (x > getStartX(2) && x < getStartX(2) + 113 && y > getStartX(3) && y < getStartX(3) + 113
					&& player1) {
				pane_32.getStyleClass().clear();
				pane_32.getStyleClass().add("selectedPaneRed");
			} 
			else if (x > getStartX(2) && x < getStartX(2) + 113 && y > getStartX(3) && y < getStartX(3) + 113
					&& !player1) {
				pane_32.getStyleClass().clear();
				pane_32.getStyleClass().add("selectedPaneBlue");
			} else {
				pane_32.getStyleClass().clear();
				pane_32.getStyleClass().add("pane");
			}

			if (x > getStartX(3) && x < getStartX(3) + 113 && y > getStartX(3) && y < getStartX(3) + 113
					&& player1) {
				pane_33.getStyleClass().clear();
				pane_33.getStyleClass().add("selectedPaneRed");
			}
			else if (x > getStartX(3) && x < getStartX(3) + 113 && y > getStartX(3) && y < getStartX(3) + 113
					&& !player1) {
				pane_33.getStyleClass().clear();
				pane_33.getStyleClass().add("selectedPaneBlue");
			} else {
				pane_33.getStyleClass().clear();
				pane_33.getStyleClass().add("pane");
			}
		});

		// when a box is clicked, it changes the pane contents to either X or O and
		// updates the grid.
		// the Referee object then scans the entire board to see if there is a 3-match.
		// it then changes the player immediately.
		mainPane.setOnMouseClicked(event -> {
			double x = event.getSceneX();
			double y = event.getSceneY();

			if (x > getStartX(1) && x < getStartX(1) + 113 && y > getStartX(1) && y < getStartX(1) + 113
					&& !(Board.occupied(1, 1))) {
				mainPane.add(GridContents.create(boxSizeWidth, boxSizeHeight, player1), 1, 1);
				Board.updateSquare(1, 1, player1);
				ref.scan();
				GameOn = !ref.getResult();
				changePlayer(glow);
			}

			if (x > getStartX(2) && x < getStartX(2) + 113 && y > getStartX(1) && y < getStartX(1) + 113
					&& !(Board.occupied(2, 1))) {
				mainPane.add(GridContents.create(boxSizeWidth, boxSizeHeight, player1), 2, 1);
				Board.updateSquare(2, 1, player1);
				ref.scan();
				GameOn = !ref.getResult();
				changePlayer(glow);
			}

			if (x > getStartX(3) && x < getStartX(3) + 113 && y > getStartX(1) && y < getStartX(1) + 113
					&& !(Board.occupied(3, 1))) {
				mainPane.add(GridContents.create(boxSizeWidth, boxSizeHeight, player1), 3, 1);
				Board.updateSquare(3, 1, player1);
				ref.scan();
				GameOn = !ref.getResult();
				changePlayer(glow);
			}

			if (x > getStartX(1) && x < getStartX(1) + 113 && y > getStartX(2) && y < getStartX(2) + 113
					&& !(Board.occupied(1, 2))) {
				mainPane.add(GridContents.create(boxSizeWidth, boxSizeHeight, player1), 1, 2);
				Board.updateSquare(1, 2, player1);
				ref.scan();
				GameOn = !ref.getResult();
				changePlayer(glow);
			}

			if (x > getStartX(2) && x < getStartX(2) + 113 && y > getStartX(2) && y < getStartX(2) + 113
					&& !(Board.occupied(2, 2))) {
				mainPane.add(GridContents.create(boxSizeWidth, boxSizeHeight, player1), 2, 2);
				Board.updateSquare(2, 2, player1);
				ref.scan();
				GameOn = !ref.getResult();
				changePlayer(glow);
			}

			if (x > getStartX(3) && x < getStartX(3) + 113 && y > getStartX(2) && y < getStartX(2) + 113
					&& !(Board.occupied(3, 2))) {
				mainPane.add(GridContents.create(boxSizeWidth, boxSizeHeight, player1), 3, 2);
				Board.updateSquare(3, 2, player1);
				ref.scan();
				GameOn = !ref.getResult();
				changePlayer(glow);
			}

			if (x > getStartX(1) && x < getStartX(1) + 113 && y > getStartX(3) && y < getStartX(3) + 113
					&& !(Board.occupied(1, 3))) {
				mainPane.add(GridContents.create(boxSizeWidth, boxSizeHeight, player1), 1, 3);
				Board.updateSquare(1, 3, player1);
				ref.scan();
				GameOn = !ref.getResult();
				changePlayer(glow);
			}

			if (x > getStartX(2) && x < getStartX(2) + 113 && y > getStartX(3) && y < getStartX(3) + 113
					&& !(Board.occupied(2, 3))) {
				mainPane.add(GridContents.create(boxSizeWidth, boxSizeHeight, player1), 2, 3);
				Board.updateSquare(2, 3, player1);
				ref.scan();
				GameOn = !ref.getResult();
				changePlayer(glow);
			}

			if (x > getStartX(3) && x < getStartX(3) + 113 && y > getStartX(3) && y < getStartX(3) + 113
					&& !(Board.occupied(3, 3))) {
				mainPane.add(GridContents.create(boxSizeWidth, boxSizeHeight, player1), 3, 3);
				Board.updateSquare(3, 3, player1);
				ref.scan();
				GameOn = !ref.getResult();
				changePlayer(glow);
			}

			/*
			 * TODO this is where you stop and reset the entire game; this gets executed
			 * runtime and this is where inputs are read.
			 */
			if (!GameOn || Board.allOccupied()) {
				winWindow.createWindow(!player1, primaryStage);
			//	start(primaryStage);
			}
		});

		// creating scene and then the primary stage
		Scene scene = new Scene(mainPane);
		scene.getStylesheets().add("CSS");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Tic Tac Toe");
		primaryStage.show();
	}
	

	/**
	 * gets the starting x coordinate of a box
	 * 
	 * @param position the position of the box
	 * @return the starting x coordinate
	 */
	public static double getStartX(int position) {

		double constant = 10 + 10; // Inset + hgap
		double dimensions = 113; // box dimensions
		double hgap = 10; // hgap

		double startX = constant + ((dimensions + hgap) * (position - 1));
		return startX;
	}

	/**
	 * changes the player
	 * 
	 * @param	the shadow in the middle of the game.
	 * @return 	the opposite of the current player.
	 */
	public static boolean changePlayer(DropShadow glow) {
		// changes the color of the glow in the middle for aestheitethics purposes
		if (player1) {
			glow.setColor(Color.BLUE);
		}
		else {
			glow.setColor(Color.RED);
		}
		return player1 = !player1;
	}
	
	// main
	public static void main(String[] args) {
		launch(args);
	}
}



// this creates the win window that stops the game when a player is determined as a winner.
// this will be an abstract class as it will only be connected to the interface class.
abstract class winWindow {
	public static void createWindow(boolean winner, Stage primaryStage) {
		
		// new window
		Stage winWindow = new Stage();
		// this locks this window so that you cannot interact with the game window
		// until this is closed.
		winWindow.initModality(Modality.APPLICATION_MODAL);
		
		BorderPane bPane = new BorderPane();
		bPane.setPrefSize(200, 100);
		bPane.setPadding(new Insets(10));
		
		Label winnerLabel = new Label();
		String winnerStr;
		
		// check the board for a draw first before declaring a player a winner.
		// draw conditions :
		//			when the board is all occupied but there is no declared winner.
		//			since the variable GameOn is set to false if there is a winner.
		if (Board.allOccupied() && Interface.GameOn) {
			winnerStr = "Draw!";
		}
		else if (winner) {
			winnerStr = "Player 1 win!";
		}
		else {
			winnerStr = "Player 2 win";
		}
		winnerLabel.setText(winnerStr);
		winnerLabel.setFont(new Font(16));
		winnerLabel.setStyle("-fx-font-weight: 700");
		
		Button playAgain = new Button("Play again");
		// restarts the game by closing the current game and creating another one
		playAgain.setOnAction(event -> {			
			winWindow.close();
			primaryStage.close();
			new Interface().start(primaryStage);
		});
		
		Button exit = new Button("Exit");
		// closes the game and program
		exit.setOnAction(event -> {
			winWindow.close();
			primaryStage.close();
			System.exit(0);
		});
		exit.setPrefWidth(70);
		
		HBox menu = new HBox(40, playAgain, exit);
		
		bPane.setBottom(menu);
		bPane.setCenter(winnerLabel);
		
		Scene winScene = new Scene(bPane);
		winWindow.setScene(winScene);
		winWindow.show();		
	}
}
