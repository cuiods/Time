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
	
	/**
	 * start game:show start panel
	 */
	public static void startGame(){
		gameframe = new FrameGame();
		gameframe.showFirstPanel();
	}
	
	/**
	 * exit game
	 */
	public static void exitGame(){
		System.exit(0);
	}

}
