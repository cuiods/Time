package gamecontrol;

import java.io.IOException;

import net.ClientAI;
import net.ServerAI;
import ui.FrameGame;
import dataBase.DataBase;
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
		if(DataBase.isNet){
			if(DataBase.isServer){
				if(ServerAI.socket!=null&&ServerAI.socket.isConnected()){
					try {
						ServerAI.socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else{
				if(ClientAI.socket!=null&&ClientAI.socket.isConnected()){
					try {
						ClientAI.socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		System.exit(0);
	}
	
	/**
	 * change panels
	 * @param the panel you want to change to, use FRAMEGAME
	 * @see FrameGame
	 */
	public static void changeTo(int num){
		gameframe.changeTo(num);
	}

}
