package GUI;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;


abstract class X_Content {
	
	/**
	 * constructor
	 * creates the actual shape
	 * this have parameters that creates the pane and the X symbol based on the
	 * specification of the calling program.
	 */
	public static Pane createX(double width, double height) {
		double LWidth = width - 12, LHeight = height - 12;
		Line line1 = new Line(12, 12, LWidth, LHeight);
		Line line2 = new Line(LWidth, 12, 12, LHeight);
		line1.setStrokeWidth(10);
		line1.setStroke(Color.RED);
		line2.setStrokeWidth(10);
		line2.setStroke(Color.RED);
		
		Pane p = new Pane(line1, line2);
		p.setStyle("-fx-border-style: solid");
		p.getStyleClass().add("pane");
		p.setPrefSize(width, height);
		
		return p;
	}
}


abstract class O_Content {
	
	/**
	 * creates the O symbol
	 * @param width		the width of the pane and O symbool to be made
	 * @param height	the height of the pane and O symbool to be made
	 * @return			the pane with the symbol
	 */
	public static Pane createO(double width, double height) {
		double centerX = width / 2, centerY = height / 2;
		
		Circle circle = new Circle(centerX, centerY, centerX - 10);
		circle.setFill(null);
		circle.setStroke(Color.BLUE);
		circle.setStrokeWidth(10);
		
		Pane p = new Pane(circle);
		p.setPrefSize(width, height);
		return p;
	}
}


abstract class GridContents {
	/**
	 * returns the symbol based on what is needed
	 * @param width		width
	 * @param height	height
	 * @param x			if true, then player1 is playing which means the and X should be created.
	 * @return			if false, the player2 is playing.
	 */
	public static Pane create(double width, double height, boolean x) {
		Pane toreturn = null;
		
		if (x) {
			toreturn = X_Content.createX(width, height);
		}
		else {
			toreturn = O_Content.createO(width, height);
		}
		return toreturn;
	}
}
