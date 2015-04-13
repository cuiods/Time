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
	
	public void startGame(){
		gameframe = new FrameGame();
		gameframe.showFirstPanel();
	}

}
