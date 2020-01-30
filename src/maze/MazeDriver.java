package maze;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MazeDriver extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public ImageView droid;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Load maze background image
		Image mazeImg = new Image("maze.png");
		ImageView maze = new ImageView(mazeImg);
				
		// Load robot
		Image droidImg = new Image ("robot.png");
		droid = new ImageView(droidImg);
		droid.setX(10);
		droid.setY(260);
		
		Group group = new Group(maze, droid);
		Scene scene = new Scene(group);
		
		// Call processKeyPressed
		scene.setOnKeyPressed(e->{MazeController.processKeyPressed(e, droid, mazeImg);});
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Maze");
		primaryStage.show();
	}

}
