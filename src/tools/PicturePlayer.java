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
	public static int time0= 1000;
	public static int time1 = 1000;
	public static int time2 = 1000;
	public static int time3 = 1000;
	public static int time4 = 1000;
	public static int time5 = 1000;
	public static int time6 = 1000;
	public static int time7 = 1000;
	public static int time8 = 1000;
	public static int time9 = 1000;
	
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
	public void panelPlay(int x, int y,Graphics g,JPanel p,int chooseTime){
	
		int time = 0;
		switch(chooseTime){
		case 0:
			time = time0;
		    break;
		case 1:
			time = time1;
		    break;
		case 2:
			time = time2;
		    break;
		case 3:
			time = time3;
		    break;
		case 4:
			time = time4;
		    break;
		case 5:
			time = time5;
		    break;
		case 6:
			time = time6;
		    break;
		case 7:
			time = time7;
		    break;
		case 8:
			time = time8;
		    break;
		case 9:
			time = time9;
		    break;
		}
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
					switch(chooseTime){
					case 0:
						if(isRepeat){
							time0 = 1000;
						}
					    break;
					case 1:
						if(isRepeat){
							time1 = 1000;
						}
					    break;
					case 2:
						if(isRepeat){
							time2 = 1000;
						}
					    break;
					case 3:
						if(isRepeat){
							time3 = 1000;
						}
					    break;
					case 4:
						if(isRepeat){
							time4 = 1000;
						}
					    break;
					case 5:
						if(isRepeat){
							time5 = 1000;
						}
					    break;
					case 6:
						if(isRepeat){
							time6 = 1000;
						}
					    break;
					case 7:
						if(isRepeat){
							time7 = 1000;
						}
					    break;
					case 8:
						if(isRepeat){
							time8 = 1000;
						}
					    break;
					case 9:
						if(isRepeat){
							time9 = 1000;
						}
					    break;
					}
				}
			}
			switch(chooseTime){
			case 0:
				if(time0 - speed >= 0){
					time0 -= speed;
				}
			    break;
			case 1:
				if(time1 - speed >= 0){
					time1 -= speed;
				}
			    break;
			case 2:
				if(time2 - speed >= 0){
					time2 -= speed;
				}
			    break;
			case 3:
				if(time3 - speed >= 0){
					time3 -= speed;
				}
			    break;
			case 4:
				if(time4 - speed >= 0){
					time4 -= speed;
				}
			    break;
			case 5:
				if(time5 - speed >= 0){
					time5 -= speed;
				}
			    break;
			case 6:
				if(time6 - speed >= 0){
					time6 -= speed;
				}
			    break;
			case 7:
				if(time7 - speed >= 0){
					time7 -= speed;
				}
			    break;
			case 8:
				if(time8 - speed >= 0){
					time8 -= speed;
				}
			    break;
			case 9:
				if(time9 - speed >= 0){
					time9 -= speed;
				}
			    break;
			}
		
	}
	
		

}
