package ui;

import gamecontrol.Controller;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import tools.MusicThread;

public class PanelFade extends JPanel implements Runnable{

	private ArrayList<Image> images=new ArrayList<Image>();
	private ArrayList<Integer> imageAlpha=new ArrayList<Integer>();
	private int flag = 0;
	private int type = 0;
	
	public PanelFade() {
		//set transparency
        setOpaque(false) ;  
        //clear layout
        setLayout(null) ;
        //set size
        setSize(1000, 600);
    }
	
	public void setType(int type){
		this.type = type;
	}
	
	/**
	 * use this method to add an image, because an image and an integer should be
	 * added at the same time
	 * @param image
	 */
	public void addImage(Image image){	
    	images.add(image);
    	imageAlpha.add(0);
    }
	
	/**
	 * this method will show all the images in the array list
	 * fade in, fade out
	 */
    public void showImage() {  
    	if(images.size()==0){
    		return ;
    	}
        Thread t = new Thread(this);
        t.start();
    } 
    
    @Override
    public void paintComponent(Graphics g1){
    	//because Graphics2D has setComponent method
        Graphics2D g = (Graphics2D) g1;     
        if ( images.get(flag) != null) {
        	//this means set transparency, g will not show the picture fully
            g.setComposite(AlphaComposite.SrcOver  
                    .derive((float) imageAlpha.get(flag)/ 100F));  
            //draw the image
            g.drawImage(images.get(flag), 0, 0, this.getWidth(),this.getHeight(), this);  
        }  
        super.paintComponent(g); 
    }
	@Override
	public void run() {
		  
loop:    while(true){
        	/*
        	 * fade in
        	 */
            while (imageAlpha.get(flag) < 100) { 
            	imageAlpha.set(flag, imageAlpha.get(flag)+5) ;    
                repaint(); 
                try {  
                    Thread.sleep(100L);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }
            
            /*
             * pause for 3 seconds
             */
            new MusicThread("music/background/start.wav", false).start();
            try {  
                Thread.sleep(3000L);  
            } catch (InterruptedException e1) {  
                e1.printStackTrace();  
            } 
            
            /*
             * fade out
             */
            while (imageAlpha.get(flag) > 0) { 
            	imageAlpha.set(flag, imageAlpha.get(flag)-5) ; 
                repaint(); 
                try {  
                    Thread.sleep(100L);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }
            
            /*
             * get next image
             */
            switch(type){
            case 0:
            	if(flag<images.size()-1){
                	flag++;
                }else{
                	Controller.changeTo(FrameGame.STARTPANEL);
                	break loop;
                }
            	//not necessary?
            	break;
            case 1:
            	flag=(flag+1)%images.size();
            	break;
            case 2:
            	Controller.exitGame();
            }
            	
        } 
    		
	}  
}
