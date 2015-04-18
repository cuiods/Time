package ui;
import java.awt.*;

import javax.swing.*;

import ui.button.ButtonNext;
public class Panelstory1 extends JLabel {
	
	ButtonNext next;
	Image back2;
	
	public Panelstory1(){
		 back2 = new ImageIcon("graphics/storyteller/background2.jpg").getImage();
   	     next = new ButtonNext(1);
   	     this.setLayout(null);
 		 this.add(next);
 		 next.addMouseListener(next);
	}
	
	  public void paintComponent(Graphics g){
  		g.drawImage(back2, 0, 0, this.getWidth(),this.getHeight(),this);
  		Font myFont = new Font("",Font.BOLD,26);
  		g.setFont(myFont);
  		g.drawString("1789年7月14日，欧洲，法国，巴黎，巴士底狱", 50, 50);
  		g.drawString("法国大革命爆发", 100, 100);
  	 } 
}
