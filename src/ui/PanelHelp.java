package ui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.button.*;

public class PanelHelp extends JPanel{
	
	public static int picNum = 1;
	public PanelHelp() {
		setLayout(null);
		//set back button
        ButtonReturn returnButton = new ButtonReturn();
        returnButton.setType(1);
        returnButton.addMouseListener(returnButton);
        returnButton.setBounds(10, 500, 80, 80);
        add(returnButton);
        
        ButtonStart start = new ButtonStart();
        start.addMouseListener(start);
        start.setBounds(780, 520, 200, 50);
        start.type = 1;
        add(start);
        
        for(int i = 0; i < 3; i++){
        	ButtonHelp help = new ButtonHelp(i);
        	help.setBounds(130, 130+i*110, 220, 100);
        	help.addMouseListener(help);
        	add(help);
        }
        
        for(int i = 3; i < 5; i++){
        	ButtonHelp help = new ButtonHelp(i);
        	help.setBounds(660+170*(3-i), 350, 100, 100);
        	help.addMouseListener(help);
        	add(help);
        }
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon("graphics/background/background1.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		g.drawImage(new ImageIcon("graphics/help/help"+picNum+".png").getImage(), 0,0,this.getWidth(),this.getHeight(),this);
	}
}
