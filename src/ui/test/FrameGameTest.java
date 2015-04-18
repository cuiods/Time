package ui.test;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import ui.FrameGame;

public class FrameGameTest {
	public static void main(String[] args){
		 FrameGame fg = new FrameGame();
		 GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
		 gd.setFullScreenWindow(fg); 
	}

}
