package ui;
import java.awt.*;

import javax.swing.*;

import ui.button.ButtonNext;
public class Panelstory2 extends JPanel{
	ButtonNext next;
	Image back,thewoman,napolun;
	
	public Panelstory2(){
		 napolun = new ImageIcon("graphics/storyteller/napolun.png").getImage();
		 thewoman = new ImageIcon("graphics/storyteller/thewoman.png").getImage();
		 back = new ImageIcon("graphics/storyteller/background2.png").getImage();
  	     next = new ButtonNext(2);
  	     this.setLayout(null);
		 this.add(next);
		 next.addMouseListener(next);
	}
	 public void paintComponent(Graphics g){
		 g.drawImage(back, 0, 0, this.getWidth(),this.getHeight(),this);
		 g.drawImage(thewoman, 0, 30,700,470, null);
		 g.drawImage(napolun,840,500,50,50,this);
		 g.setColor(Color.red);
		 Font myfont = new Font("",Font.BOLD,50);
		 g.setFont(myfont);
		 g.drawString("We need you!", 500, 300);
		 g.drawString("你还在等什么？", 500, 100);
	 }
}
