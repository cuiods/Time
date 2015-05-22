package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.button.ButtonNetChoose;
import ui.button.ButtonOnlineStart;
import ui.button.ButtonReturn;

public class PanelNetSet extends JPanel{

	public PanelNetSet() {
		setLayout(null);
		
		ButtonReturn returnButton = new ButtonReturn();
	    returnButton.setType(1);
	    returnButton.addMouseListener(returnButton);
	    returnButton.setBounds(10, 500, 80, 80);
	    add(returnButton);
	    
	    ButtonNetChoose choose0 = new ButtonNetChoose(0);
	    ButtonNetChoose choose1 = new ButtonNetChoose(1);
	    choose0.addMouseListener(choose0);
	    choose1.addMouseListener(choose1);
	    add(choose0);add(choose1);
	    
	    ButtonOnlineStart start = new ButtonOnlineStart();
	    start.addMouseListener(start);
	    add(start);
	    
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon("graphics/background/background.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		g.drawImage(new ImageIcon("graphics/net/netset.png").getImage(), 400,50,434,306, this);
	}
}
