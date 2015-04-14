package ui.button;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonClassic extends JLabel{
	ImageIcon ButtonImage = null;
	String filepath = "graphics/button/classicButton.png";
	
	public ButtonClassic(){
		ButtonImage = new ImageIcon(filepath);
		this.setIcon(ButtonImage);
		this.setBounds(550, 250, 140, 140);
	}

}
