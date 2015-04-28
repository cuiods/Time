package ui;

import java.awt.*;

import javax.swing.*;

import ui.button.*;

public class PanelStory2 extends JPanel {
     public ButtonNext next;
     public ButtonLast last;
     public Image story;

     
     public PanelStory2(){
    	 next = new ButtonNext();
   	     last = new ButtonLast();
  
   	     this.setLayout(null);
 		 this.add(next);
 		 this.add(last);
 		 last.addMouseListener(last);
 		 next.addMouseListener(next);
 		 
 		 story=new ImageIcon("graphics/storyteller/story3.png").getImage();
     }
     public void paintComponent(Graphics g){
    		
   		g.drawImage(story, 0, 0, this.getWidth(),this.getHeight(),this);
   	  
   	 }
}
