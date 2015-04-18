package ui;
import java.awt.*;

import javax.swing.*;

import ui.button.ButtonNext;
public class Panelstory3 extends JPanel {
	Image back;
	ButtonNext start;
	public Panelstory3(){
		back = new ImageIcon("graphics/storyteller/background2.png").getImage();
		start = new ButtonNext(3);
		this.setLayout(null);
		this.add(start);
		start.addMouseListener(start);
	}
     public void paintComponent(Graphics g){
    	 g.drawImage(back, 0,0,this.getWidth(),this.getHeight(),null);
    	 Font font1 = new Font("",Font.BOLD,60);
         g.setFont(font1);
         g.drawString("本关目标", 320, 60);
         Font font2 = new Font("华文新魏",Font.BOLD,30);
         g.setFont(font2);
         g.drawString("带领你的士兵们攻下巴士底狱，升级你的文明！", 20, 200);
     }
           
}
