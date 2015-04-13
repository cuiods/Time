package ui.button;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonExit extends JLabel{

ImageIcon exitButtonImage = null;
	
	public ButtonExit(){
		exitButtonImage = new ImageIcon("graphics/button/exitButton.png");
		this.setIcon(exitButtonImage);
	}
}
