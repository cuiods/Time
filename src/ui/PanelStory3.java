package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

import ui.button.*;

public class PanelStory3 extends JPanel{
	public ButtonNext next;
	public ButtonLast last;
	public Image story;
    public static int picNum=0;
    
    public PanelStory3(){
   	     next = new ButtonNext();
  	     last = new ButtonLast();
 
  	     this.setLayout(null);
		 this.add(next);
		 this.add(last);
		 last.addMouseListener(last);
		 next.addMouseListener(next);
		 
		 story=new ImageIcon("graphics/storyteller/pass3/story1.png").getImage();
    }
    public void paintComponent(Graphics g){
		
   		g.drawImage(story, 0, 0, this.getWidth(),this.getHeight(),this);
   	  
   	 }
}
