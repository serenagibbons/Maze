package maze;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class MazeController {

	public static void processKeyPressed(KeyEvent e, ImageView droid, Image mazeImg) {
		int newX = 0;
		int newY = 0;
		
		int move = 2;
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
            	if (droid.getX() <= 570 && isOnPath(newX+droidWidth, (int)droid.getY(), mazeImg))
            		droid.setX(newX);
                break;
            case LEFT:
            	newX = (int)(droid.getX() - move);
            	if (droid.getX() >= 9 && isOnPath(newX, (int)droid.getY(), mazeImg))
            		droid.setX(newX);
                break;
        }
		
	}
	
	public static boolean isOnPath(int x, int y, Image mazeImg) {
		// Get height and width of maze
		int width = (int)mazeImg.getWidth(); 
	    int height = (int)mazeImg.getHeight(); 
		
		// Reading color from the loaded image 
	    PixelReader pixelReader = mazeImg.getPixelReader(); 
	    
	    // Read the color of the image at the pixels where the robot will be moved
	    Color color = pixelReader.getColor(x, y);
	    
	    System.out.println(color);
	    // If the pixel color is white return true
	    if (color.equals(Color.WHITE))
	    	return true;
	    // Else return false
	    return false;
	}

}
