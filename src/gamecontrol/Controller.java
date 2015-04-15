package gamecontrol;

import ui.*;
/**
 * 
 * game controller
 * set game panels
 * @author Cui
 *
 */
public class Controller {
	
	public static FrameGame gameframe = null;
	
	public Controller(){}
	
	public static void startGame(){
		//start game
		gameframe = new FrameGame();
		gameframe.showFirstPanel();
	}
	
<<<<<<< HEAD
=======
	public static void exitGame(){
		System.exit(0);
	}

>>>>>>> origin/master
}
