package ui;
import gamecontrol.Controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import ui.button.ButtonLast;
import ui.button.ButtonNext;
public class Panelstory1 extends JPanel{
	
	public ButtonNext next;
	ButtonLast last;
	public Image story;
	  //Í¼Æ¬¼ÆÊýÆ÷
   public  static int picNum=1;

	public Panelstory1(){
		
		
   	     next = new ButtonNext(1);
   	     last = new ButtonLast(1);
  
   	     this.setLayout(null);
 		 this.add(next);
 		 this.add(last);
 		 last.addMouseListener(last);
 		 next.addMouseListener(next);
 		 
 		 story=new ImageIcon("graphics/storyteller/story1.png").getImage();
 		
	}
	
	  public void paintComponent(Graphics g){
	
  		g.drawImage(story, 0, 0, this.getWidth(),this.getHeight(),this);
  	  
  	 }
 
	
}

