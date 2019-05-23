package maze;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class MazeController {

	public static void processKeyPressed(KeyEvent e, ImageView droid) {
		switch (e.getCode())
        {
            case UP:
                droid.setY(droid.getY() - 2);
                break;
            case DOWN:
                droid.setY(droid.getY() + 2);
                break;
            case RIGHT:
                droid.setX(droid.getX() + 2);
                break;
            case LEFT:
                droid.setX(droid.getX() - 2);
                break;
            default:
                break;  // do nothing if it's not an arrow key
        }
		
	}

}
