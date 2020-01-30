package maze;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class MazeController {

	public static void processKeyPressed(KeyEvent e, ImageView droid, Image mazeImg) {
		int newX = 0;
		int newY = 0;
		
		int move = 5;
		int droidHeight = 24;
		int droidWidth = 20;
		
		switch (e.getCode()) {
            case UP:
            	newY = (int)(droid.getY() - move);
            	if (droid.getY() >= 10 && isOnPath((int)droid.getX(), newY, mazeImg))
            		droid.setY(newY);
                break;
            case DOWN:
            	newY = (int)(droid.getY() + move);
            	if (droid.getY() <= 400 && isOnPath((int)droid.getX(), newY+droidHeight, mazeImg))
            		droid.setY(newY);
                break;
            case RIGHT:
            	newX = (int)(droid.getX() + move);
            	if (droid.getX() <= 576 && isOnPath(newX+droidWidth, (int)droid.getY(), mazeImg))
            		droid.setX(newX);
                break;
            case LEFT:
            	newX = (int)(droid.getX() - move);
            	if (droid.getX() >= 13 && isOnPath(newX, (int)droid.getY(), mazeImg))
            		droid.setX(newX);
                break;
            default:
            	break;
        }
    	gameComplete(droid);
	}
	
	public static void gameComplete(ImageView droid) {
		if (droid.getX() >= 572) {
			Alert alert = new Alert(AlertType.NONE);
			alert.setTitle("Game Over");
			alert.setContentText("Congratulations, you made it through the maze!");

			ButtonType buttonTypePlayAgain = new ButtonType("Play Again");
			ButtonType buttonTypeExit = new ButtonType("Exit");

			alert.getButtonTypes().setAll(buttonTypePlayAgain, buttonTypeExit);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypePlayAgain){
				// reset robot to starting position
				droid.setX(10);
				droid.setY(260);
			}
			else {
				// exit the game
				System.exit(0);
			}
		}
	}
	
	public static boolean isOnPath(int x, int y, Image mazeImg) {
		// Reading color from the loaded image 
	    PixelReader pixelReader = mazeImg.getPixelReader(); 
	    
	    // Read the color of the image at the pixels where the robot will be moved
	    Color color = pixelReader.getColor(x, y);
	    
	    // If the pixel color is white return true
	    if (color.equals(Color.WHITE))
	    	return true;
	    // Else return false
	    return false;
	}

}
