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
      ButtonPass5 five;
      ButtonPass6 six;
      
      public ButtonReturn returnButton;
    
      public PanelStory0(){
    	  
          this.setLayout(null);
          
          //set back button
          returnButton = new ButtonReturn();
          returnButton.setType(1);
          returnButton.addMouseListener(returnButton);
          returnButton.setBounds(10, 500, 80, 80);
          add(returnButton);
  		
  		  //初始化ButtonPass并添加到面板上
          one = new ButtonPass1();
  		  two = new ButtonPass2();
  		  three = new ButtonPass3();
  		  four= new ButtonPass4();
  		  five = new ButtonPass5();
  		  six = new ButtonPass6();
  		
  		  this.add(one);
  		  one.addMouseListener(one);
  		  this.add(two);
  		  two.addMouseListener(two);
  		  this.add(three);
  		  three.addMouseListener(three);
  		  this.add(four);
  		  four.addMouseListener(four);
  		  this.add(five);
  		  five.addMouseListener(five);
  		  this.add(six);
  		  six.addMouseListener(six);
  		 
  		  path=new ImageIcon("graphics/storyteller/universe.gif").getImage();
      }
      public void paintComponent(Graphics g){
  		   g.drawImage(path, 0, 0, this.getWidth(),this.getHeight(),this);
           g.drawImage(new ImageIcon("graphics/storyteller/path.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
     }
}
