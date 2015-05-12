package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.button.ButtonExit;
import ui.button.ButtonLoadChoose;

public class PanelLoad extends JPanel{
	private ButtonExit buttonExit=null;
	Image image = new ImageIcon("graphics/info/gameSetPanel.png").getImage();
	
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
	}
	
	
    @Override
    public void paintComponent(Graphics g){
    	g.drawImage(new ImageIcon("graphics/background/loading.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
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
