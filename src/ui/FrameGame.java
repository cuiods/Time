package ui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class FrameGame extends JFrame implements MouseListener,MouseMotionListener{

	
	public PanelStart startPanel = null;
	public PanelFight fightPanel = null;
    public StoryPlayer storyPlayer = null;
    public PanelLoading loadingPanel = null;
    public PanelLoad loadPanel = null;
    
    int tempX;  
    int tempY;  
    int winX;  
    int winY;  
    int oldX;  
    int oldY;
    int x;
    int y;
	
	public FrameGame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)(screenSize.getWidth()-this.getWidth())/2, (int)((screenSize.getHeight()-this.getHeight())/2-20));
		
		
		//set cursor
		Toolkit toolkit = Toolkit.getDefaultToolkit();   
		Image image = toolkit.getImage("graphics/icon/cursor.png");
		Cursor c = toolkit.createCustomCursor(image , new Point(5,5), "icon/cursor.png");  
		this.setCursor (c);
		
		this.setUndecorated(true);
		this.setVisible(true);
		
		//able to drag
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public void showFirstPanel(){
		startPanel = new PanelStart();
		this.setContentPane(startPanel);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		Point point = arg0.getPoint();  
        Rectangle rec = this.getBounds();  
                  
        winX = (int)rec.getX();  
        winY = (int)rec.getY();       
        x = (int)point.getX();  
        y = (int)point.getY();        
        tempX = x - oldX;  
        tempY = y - oldY;         
          
        this.setLocation((int)(winX + tempX), (int)(winY + tempY)); 
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
        Point point = arg0.getPoint();       
        tempX = (int)point.getX();  
        tempY = (int)point.getY();  
        oldX = (int)point.getX();  
        oldY = (int)point.getY();  
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


