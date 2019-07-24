package maze;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class MazeController {

	public static void processKeyPressed(KeyEvent e, ImageView droid) {
		switch (e.getCode())
        {
            case UP:
            	if (droid.getY() >= 10)
                droid.setY(droid.getY() - 2);
                break;
            case DOWN:
            	if (droid.getY() <= 400)
            		droid.setY(droid.getY() + 2);
                break;
            case RIGHT:
            	if (droid.getX() <= 570)
            		droid.setX(droid.getX() + 2);
                break;
            case LEFT:
            	if (droid.getX() >= 9)
            		droid.setX(droid.getX() - 2);
                break;
            default:
                break;  // do nothing if it's not an arrow key
        }
		
	}

}
