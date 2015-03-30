package snakeGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class snakeGame {
	static BufferedInputStream buf;
	final static int UP = 1;
	final static int DOWN = 2;
	final static int LEFT = 3;
	final static int RIGHT = 4;
	int x = 255;
	int y = 255;
	int tx = 0;
	int ty = 0;
	int length = 5;
	int speed = 10;
	int direction = UP;
	boolean alive = true;
	ArrayList<Location> LocationList = new ArrayList<Location>();
	food dot = new food();
	public static void main(String[] args) {
				snakeGame game = new snakeGame();
				game.go();
						
		
	}
	public class Location{
		private int lx = 0;
		private int ly = 0;
		public void setLX(int temp){
			lx = temp;
		}
		public void setLY(int temp){
			ly = temp;
		}
		public int getLX(){
			return lx;
		}
		public int getLY(){
			return ly;
		}
	}
	public class food{
		public int fx = 0;
		public int fy = 0;
		public void newfood(){
			fx = (int)(Math.random()*48)*10+20;
			fy = (int)(Math.random()*48)*10+20;
		}
	}
	public void go(){
		try {
			   File dir = new File("D:/");// 这里是你所要播放文件的路径
			   File[] fs = dir.listFiles();
			   File fObject = new File(dir, "background.wav");// 歌曲名,记住格式有限制
			   FileInputStream files = new FileInputStream(fObject);
			   buf = new BufferedInputStream(files);
			   AudioStream audio = new AudioStream(buf);
			   AudioPlayer.player.start(audio);
			  } catch (IOException e) {
			   System.out.println(e.getMessage());
			  }
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(drawPanel);
		drawPanel.setBackground(Color.white);
		frame.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
				  int key = e.getKeyCode();
				  switch(key){
				  case KeyEvent.VK_UP:
					  if(direction!= UP&&direction!= DOWN){
						  direction = UP;
					  }
				   break;
				  case KeyEvent.VK_DOWN:
					  if(direction!= UP&&direction!= DOWN){
						  direction = DOWN;
					  }
				   break;
				  case KeyEvent.VK_LEFT:
					  if(direction!= LEFT&&direction!= RIGHT){
						  direction = LEFT;
					  }
					  break;
				  case KeyEvent.VK_RIGHT:
					  if(direction!= LEFT&&direction!= RIGHT){
						  direction = RIGHT;
					  }
				   break;
				  }
			}
			
		});
		frame.setSize(535,560);
		frame.setVisible(true);
		dot.newfood();
		while(alive){
			Location loc = new Location();
			loc.setLX(x);
			loc.setLY(y);
			LocationList.add(loc);
			switch(direction){
			case UP:
				y-=speed;break;
			case DOWN:
				y+=speed;break;
			case LEFT:
				x-=speed;break;
			case RIGHT:
				x+=speed;break;
			}
			drawPanel.repaint();
			try{
				Thread.sleep(50);
			}catch(Exception ex){}
			if(Math.abs(dot.fx-x)<=5&&Math.abs(dot.fy-y)<=5){
				length+=2;
				dot.newfood();
				audioPlay test = new audioPlay();
				test.repaint();
				try {
					   File dir = new File("D:/");// 这里是你所要播放文件的路径
					   File[] fs = dir.listFiles();
					   File fObject = new File(dir, "eat.wav");// 歌曲名,记住格式有限制
					   FileInputStream files = new FileInputStream(fObject);
					   buf = new BufferedInputStream(files);
					   AudioStream audio = new AudioStream(buf);
					   AudioPlayer.player.start(audio);
					  } catch (IOException e) {
					   System.out.println(e.getMessage());
					  }
			}
			for(int num = 2;num<LocationList.size();num++){
				Location cube = new Location();
				cube = LocationList.get(num);
				tx = cube.getLX();
				ty = cube.getLY();
				if(Math.abs(tx-x)<10&&Math.abs(ty-y)<10){
					alive = false;
					try {
						   File dir = new File("D:/");// 这里是你所要播放文件的路径
						   File[] fs = dir.listFiles();
						   File fObject = new File(dir, "dead.wav");// 歌曲名,记住格式有限制
						   FileInputStream files = new FileInputStream(fObject);
						   buf = new BufferedInputStream(files);
						   AudioStream audio = new AudioStream(buf);
						   AudioPlayer.player.start(audio);
						  } catch (IOException e) {
						   System.out.println(e.getMessage());
						  }
				}
			}
			if(x<5||y<5||x>495||y>495){
				alive = false;
				try {
					   File dir = new File("D:/");// 这里是你所要播放文件的路径
					   File[] fs = dir.listFiles();
					   File fObject = new File(dir, "dead.wav");// 歌曲名,记住格式有限制
					   FileInputStream files = new FileInputStream(fObject);
					   buf = new BufferedInputStream(files);
					   AudioStream audio = new AudioStream(buf);
					   AudioPlayer.player.start(audio);
					  } catch (IOException e) {
					   System.out.println(e.getMessage());
					  }
			}
		}
		System.out.println("Game Over! Your final score is "+ length + "!!");
		int reset = JOptionPane.showConfirmDialog(null, 
				"Your final score is " + length + "!!! Replay?", "Game Over!", JOptionPane.YES_NO_OPTION);
		if(reset == 0){
			snakeGame game = new snakeGame();
			game.go();
		}
		else{
			System.exit(0);
		}
		
	}
	public class audioPlay extends Applet
	{
	public void paint(Graphics g)
	{
	g.drawString("Please put on your earphone and enjoy the music!!", 20, 100);
	play(getDocumentBase(),"1.wav");
	}
	}
	class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){			
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.blue);
			g.fillRect(500, 0, 20, 520);
			g.fillRect(0, 500, 520, 20);
			Location cube = new Location();
			if(LocationList.size()>length){
				LocationList.remove(0);
			}
			for(int num = 0;num<LocationList.size();num++){
				cube = LocationList.get(num);
				tx = cube.getLX();
				ty = cube.getLY();
				if(num%2==0){
				g.setColor(Color.green);
				}
				else{
					g.setColor(Color.black);
				}
				g.fillRect(tx-5, ty-5, 10, 10);
			}
			g.setColor(Color.black);
			g.fillRect(x-5, y-5, 10, 10);
			g.setColor(Color.red);
			g.fillOval(dot.fx, dot.fy, 10, 10);
		}
		}

}
