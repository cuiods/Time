package ui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelNetSet extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon("gaphics/background/background.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
	}
}
