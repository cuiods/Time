package tools;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * draw many pictures in a panel
 * @author Cui
 *
 */
public class PicturePlayer {
	
	//the file path of the pictures
	private String[] pictureSrc = null;
	//the images
	private ArrayList<Image> images = new ArrayList<Image>();
	// whether repeat
	private boolean isRepeat = false;
	//speed of the picture player
	private int speed = 1;
	//define image size
	private int imageSize = 10;
	//set time
	private static int time = 1000;
	
	/**
	 * set picture player
	 * @param pictures String[] file paths of 10 pictures
	 * @param repeat whether repeat play
	 */
	public PicturePlayer(String[] pictures, boolean repeat){
		this.pictureSrc = pictures;
		this.isRepeat = repeat;
		
		
		//load and initialize pictures
		if(pictureSrc.length >= imageSize){
			for(int i = 0; i < imageSize; i++){
				Image image = new ImageIcon(pictureSrc[i]).getImage();
				images.add(image);
			}
		}
		
	}
	
	/**
	 * set picture player
	 * @param pictures  String[] file paths of 10 pictures
	 * @param repeat  whether repeat play
	 * @param speed  set play speed
	 */
	public PicturePlayer(String[] pictures, boolean repeat,int speed){
		this.pictureSrc = pictures;
		this.isRepeat = repeat;
		this.speed = speed;
		
		//load and initialize pictures
		if(pictureSrc.length >= imageSize){
			for(int i = 0; i < imageSize; i++){
				Image image = new ImageIcon(pictureSrc[i]).getImage();
				images.add(image);
			}
		}
		
	}
	
	/**
	 * play pictures
	 * @param x  the location x of the picture you want to draw
	 * @param y  the location y of the picture you want to draw
	 * @param g  graphics g
	 * @param p  panel which will show the picture
	 */
	public void panelPlay(int x, int y,Graphics g,JPanel p){
	
			if(time > 900){
				g.drawImage(images.get(0), x, y, images.get(0).getWidth(p), images.get(0).getHeight(p), p);
				//System.out.println("1");
			}else if(time > 800){
				//System.out.println("2");
				g.drawImage(images.get(1), x, y, images.get(1).getWidth(p), images.get(1).getHeight(p), p);
			}else if(time > 700){
				//System.out.println("3");
				g.drawImage(images.get(2), x, y, images.get(2).getWidth(p), images.get(2).getHeight(p), p);
			}else if(time > 600){
				//System.out.println("4");
				g.drawImage(images.get(3), x, y, images.get(3).getWidth(p), images.get(3).getHeight(p), p);
			}else if(time > 500){
				//System.out.println("5");
				g.drawImage(images.get(4), x, y, images.get(4).getWidth(p), images.get(4).getHeight(p), p);
			}else if(time > 400){
				//System.out.println("6");
				g.drawImage(images.get(5), x, y, images.get(5).getWidth(p), images.get(5).getHeight(p), p);
			}else if(time > 300){
				//System.out.println("7");
				g.drawImage(images.get(6), x, y, images.get(6).getWidth(p), images.get(6).getHeight(p), p);
			}else if(time > 200){
				//System.out.println("8");
				g.drawImage(images.get(7), x, y, images.get(7).getWidth(p), images.get(7).getHeight(p), p);
			}else if(time > 100){
				//System.out.println("9");
				g.drawImage(images.get(8), x, y, images.get(8).getWidth(p), images.get(8).getHeight(p), p);
			}else{
				g.drawImage(images.get(9), x, y, images.get(9).getWidth(p), images.get(9).getHeight(p), p);
				if(time < 100){
					if(isRepeat){
						time = 1000;
					}
				}
			}
			if(time - speed >= 0){
				time -= speed;
			}
		
	}
	
	/**
	 * set time
	 * @param time Default time is 1000
	 */
	public void setTime(int time){
		PicturePlayer.time = time;
	}
		

}
