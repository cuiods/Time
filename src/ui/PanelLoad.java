package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.button.ButtonExit;
import ui.button.ButtonLoad;

public class PanelLoad extends JPanel implements MouseListener{
	private ButtonExit buttonExit=null;
	Image image = new ImageIcon("graphics/info/load.png").getImage();
	
    public PanelLoad(){
    	buttonExit=new ButtonExit();
    	buttonExit.type=3;
    	buttonExit.setBounds(10, 10, 30, 30);
    	buttonExit.addMouseListener(buttonExit);
    	
		this.setBounds(320, 130, 320, 380);
		this.add(buttonExit);
	}
	
	
    @Override
    public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0,this.getWidth(),this.getHeight(), this);
	}
    
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>=341&&e.getX()<=620){
			if(e.getY()>=192&&e.getY()<=260){
				image = new ImageIcon("graphics/info/load1.png").getImage();
				this.repaint();
			}
			else if(e.getY()>=263&&e.getY()<=331){
				image = new ImageIcon("graphics/info/load2.png").getImage();
				this.repaint();
			}
			else if(e.getY()>=334&&e.getY()<=402){
				image = new ImageIcon("graphics/info/load3.png").getImage();
				this.repaint();
			}
			else if(e.getY()>=405&&e.getY()<=473){
				image = new ImageIcon("graphics/info/load4.png").getImage();
				this.repaint();
			}
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
