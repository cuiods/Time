package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tools.Save;
import ui.button.ButtonExit;
import ui.button.ButtonLoadChoose;

public class PanelLoad extends JPanel{
	private ButtonExit buttonExit=null;
	Image image = new ImageIcon("graphics/info/gameSetPanel.png").getImage();
	public static String time0,time1,time2,time3 = "";
    public PanelLoad(){
    	this.setLayout(null);
    	
    	buttonExit=new ButtonExit();
    	buttonExit.type=3;
    	buttonExit.setBounds(10, 500, 80, 80);
    	buttonExit.addMouseListener(buttonExit);
    	
//		this.setBounds(320, 130, 320, 380);
		this.add(buttonExit);
		
		for(int i = 0; i< 4; i++){
			ButtonLoadChoose choose = new ButtonLoadChoose(i);
			choose.addMouseListener(choose);
			this.add(choose);
		}
		
		getTime();
	}
	
	
    private void getTime() {
		time0 = Save.getSaveTime(0);
		time1 = Save.getSaveTime(1);
		time2 = Save.getSaveTime(2);
		time3 = Save.getSaveTime(3);
	}


	@Override
    public void paintComponent(Graphics g){
    	g.drawImage(new ImageIcon("graphics/background/loading.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    	Font my = new Font("»ªÎÄÐÂÎº", Font.PLAIN, 28);
    	g.setColor(Color.BLACK);
    	g.setFont(my);
    	g.drawString(time0, 250, 120);
    	g.drawString(time1, 250, 240);
    	g.drawString(time2, 250, 360);
    	g.drawString(time3, 250, 480);
	}
//    
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		Point point = MouseInfo.getPointerInfo().getLocation();
//		if(point.getX()>=341&&point.getX()<=620){
//			if(point.getY()>=192&&point.getY()<=260){
//				image = new ImageIcon("graphics/info/load1.png").getImage();
//				this.repaint();
//
//			}
//			else if(point.getY()>=263&&point.getY()<=331){
//				image = new ImageIcon("graphics/info/load2.png").getImage();
//				this.repaint();
//			}
//			else if(point.getY()>=334&&point.getY()<=402){
//				image = new ImageIcon("graphics/info/load3.png").getImage();
//	            this.repaint();
//			}
//			else if(point.getY()>=405&&point.getY()<=473){
//				image = new ImageIcon("graphics/info/load4.png").getImage();
//                this.repaint();
//			}
//		}
//	}
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
}
