package ui.button;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonSet extends JLabel{
	ImageIcon ButtonImage = null;
	String filepath = "graphics/button/setButton.png";
	public ButtonSet(){
		ButtonImage = new ImageIcon(filepath);
		this.setIcon(ButtonImage);
		this.setBounds(300, 250, 140, 140);
	}

}
