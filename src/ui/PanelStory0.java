package ui;

import javax.swing.*;

import ui.button.*;

import java.awt.*;

public class PanelStory0 extends JPanel{
      Image path;
      ButtonPass1 one;
      ButtonPass2 two;
      ButtonPass3 three;
      ButtonPass4 four;
      
      public ButtonLast last;
    
      public PanelStory0(){
    	  
    	  last = new ButtonLast();
          this.setLayout(null);
  		  this.add(last);
  		  last.addMouseListener(last);
  		
  		  //初始化ButtonPass并添加到面板上
  		one = new ButtonPass1();
		two = new ButtonPass2();
		three = new ButtonPass3();
		four= new ButtonPass4();
		
		this.add(one);
		one.addMouseListener(one);
		this.add(two);
		two.addMouseListener(two);
		this.add(three);
		three.addMouseListener(three);
		this.add(four);
		four.addMouseListener(four);
		
  		 
  		 path=new ImageIcon("graphics/storyteller/path.png").getImage();
      }
      public void paintComponent(Graphics g){
  		   g.drawImage(path, 0, 0, this.getWidth(),this.getHeight(),this);
          
        		
          
     }
}
