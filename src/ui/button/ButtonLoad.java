package ui.button;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonLoad extends JLabel{
	
	ImageIcon ButtonImage = null;
	String filepath = "graphics/button/loadButton.png";
	public ButtonLoad(){
		ButtonImage = new ImageIcon(filepath);
		this.setIcon(ButtonImage);
		this.setBounds(180, 400, 140, 140);
	}

}
