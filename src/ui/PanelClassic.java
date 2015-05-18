package ui;

import gamecontrol.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tools.DrawUnits;
import tools.MusicThread;
import tools.PicturePlayer;
import tools.Save;
import ui.button.ButtonClassicScience;
import ui.button.ButtonClassicUnit;
import ui.button.ButtonGameSet;
import ui.button.ButtonPause;
import ui.button.ButtonScience;
import ui.button.ButtonUnit;
import units.S_Castle;
import units.S_Unit;
import dataBase.DataBase;

public class PanelClassic extends JPanel implements Runnable{

	    //background image
		private Image fightBackGround = null;
		//set button
		private ButtonGameSet gameSet = null;
		//pause and continue button
		private ButtonPause pause = null;
		
		//when game over, the panel appears
		static PanelGameOver gameOverPanel = null;
		//for special effects, @warning :not equal to database
		public static boolean isTech_3 = false;
		public static boolean isTech_6 = false;
		public static boolean isTech_7 = false;
		public static boolean isTech_8 = false;
		public static ArrayList<S_Unit> enemy = new ArrayList<S_Unit>();
		//to play music
		//public static MusicPlayer fightPlayer = new MusicPlayer();
		static MusicThread musicPlay  = new MusicThread("music/background/pass1.wav", true);
		
		public PanelClassic(){
			//set music
			setMusic();		
			//set castles
			setCastle();	
			//set buttons
			setButtons();	
			//clear Layout
			setLayout(null);
			//set AI
			setAI();
			//auto save
			save();
		}
		
		@Override
		public void paintComponent(Graphics g){
			
			drawBackground(g);

			DrawUnits.draw(g,this);
			
			drawEffects(g);
			
			drawInformation(g);
		
		}
		private void drawInformation(Graphics g) {
			
	    }

		/**
		 * set all the buttons on the fight panel
		 * @see ui.button
		 */
		private void setButtons(){
			//set science buttons
			setTech();
			//set unit buttons
			setUnit();
			//setting (now including save button and return to start panel button)
			gameSet = new ButtonGameSet();
			gameSet.addMouseListener(gameSet);
			//pause and continue
			pause = new ButtonPause();
			pause.addMouseListener(pause);
			
			this.add(gameSet);
			this.add(pause);
			
		}
		
		
		private void setTech(){
			ButtonClassicScience tech1 = new ButtonClassicScience(4, 1);
			ButtonClassicScience tech2 = new ButtonClassicScience(5, 2);
			ButtonClassicScience tech3 = new ButtonClassicScience(7, 3);
			ButtonClassicScience tech4 = new ButtonClassicScience(8, 4);
			tech1.addMouseListener(tech1);
			tech2.addMouseListener(tech2);
			tech3.addMouseListener(tech3);
			tech4.addMouseListener(tech4);
			Thread t1 = new Thread(tech1);
			Thread t2 = new Thread(tech2);
			Thread t3 = new Thread(tech3);
			Thread t4 = new Thread(tech4);
			t1.start();t2.start();t3.start();t4.start();
			add(tech1);add(tech2);add(tech3);add(tech4);
			
		}
		
		private void setUnit(){
			ButtonClassicUnit butUnit = null;
			for(int i =11; i<15;i++){
				butUnit = new ButtonClassicUnit(i,0);
				butUnit.setBounds(30+(i-11)*60, 80, 55, 52);
				butUnit.addMouseListener(butUnit);
				this.add(butUnit);
			}
			for(int i =11; i<15;i++){
				butUnit = new ButtonClassicUnit(i,1);
				butUnit.setBounds(30+(i-11)*60, 245, 55, 52);
				butUnit.addMouseListener(butUnit);
				this.add(butUnit);
			}
			for(int i =11; i<15;i++){
				butUnit = new ButtonClassicUnit(i,2);
				butUnit.setBounds(30+(i-11)*60, 410, 55, 52);
				butUnit.addMouseListener(butUnit);
				this.add(butUnit);
			}
		}
		
		/**
		 * set ai
		 */
		private void setAI(){
			
		}
		
		/**
		 * set music
		 */
		private void setMusic(){
//			//close other music
//			Controller.gameframe.startPanel.musicPlay.stopmusic();
//			Controller.gameframe.startPanel.isplay = false;
//			
//			musicPlay.stopmusic();
//			
//			//new music
//			musicPlay  = new MusicThread("music/background/main.wav", true);
//			musicPlay.start();
		}
		
		/**
		 * auto save
		 */
		private void save(){
			Save sv = new Save(0);
			try {
				sv.Save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
						

		private void drawBackground(Graphics g){
			//load background image
			fightBackGround = new ImageIcon("graphics/background/fightbackground6.png").getImage();

			//money image
			Image money = new ImageIcon("graphics/info/money1.png").getImage();
			Image tech = new ImageIcon("graphics/info/tech.png").getImage();
			
			//show background image
			g.drawImage(fightBackGround, 0, 0,this.getWidth(),this.getHeight(), this);
			g.drawImage(new ImageIcon("graphics/info/life.png").getImage(), 120, 15, 240, 45, this);
			g.drawImage(new ImageIcon("graphics/info/life.png").getImage(), 605, 15, 240, 45, this);
			g.drawImage(tech, 304, 58, 130, 110, this);

			//show money
			g.drawImage(money, 355, 0,260, 80, this);
			g.setColor(Color.YELLOW);
			Font myFont = new Font("»ªÎÄÐÂÎº",Font.BOLD,24);
			g.setFont(myFont);
			g.drawString(DataBase.Money+"", 450, 65);
		}
		
		
		/**
		 * draw special effects
		 * @param graphics g
		 * @see PicturePlayer
		 */
		private void drawEffects(Graphics g){
			/*
			 * draw tech 3 effects
			 */
			if(isTech_3){
				String[] pictures = {"graphics/stunt/tech3_1.png","graphics/stunt/tech3_2.png","graphics/stunt/tech3_3.png","graphics/stunt/tech3_4.png","graphics/stunt/tech3_5.png","graphics/stunt/tech3_6.png","graphics/stunt/tech3_7.png","graphics/stunt/tech3_8.png","graphics/stunt/tech3_9.png","graphics/stunt/tech3_10.png"};
				for(int i = 0; i <enemy.size();i++){
					if(PicturePlayer.time0>=30){
						PicturePlayer pic1 = new PicturePlayer(pictures, false, 30);
						pic1.panelPlay(enemy.get(i).getX()-15, enemy.get(i).getY(), g, this,0);
					}else{
						isTech_3 = false;
						PicturePlayer.time0 = 1000;
						enemy.removeAll(enemy);
					}
				}
			}
				
			/*
			 * draw pass2 tech6 effects
			 */
			if(isTech_6){
				String[] pictures3 = {"graphics/stunt/clock1.png","graphics/stunt/clock2.png","graphics/stunt/clock3.png","graphics/stunt/clock4.png","graphics/stunt/clock5.png","graphics/stunt/clock4.png","graphics/stunt/clock3.png","graphics/stunt/clock2.png","graphics/stunt/clock1.png","graphics/stunt/clock3.png"};
				PicturePlayer pic3 = new PicturePlayer(pictures3, false, 30);
				pic3.panelPlay(400, 250, g, this, 1);
				if(PicturePlayer.time1 < 20){
					isTech_6 = false;
					PicturePlayer.time1 = 1000;
				}
			}
			
			/*
			 * draw pass2 tech7 effects
			 */
			if(isTech_7){
				String[] pictures4 = {"graphics/stunt/tech7_1.png","graphics/stunt/tech7_2.png","graphics/stunt/tech7_3.png","graphics/stunt/tech7_4.png","graphics/stunt/tech7_5.png","graphics/stunt/tech7_6.png","graphics/stunt/tech7_7.png","graphics/stunt/tech7_8.png","graphics/stunt/tech7_9.png","graphics/stunt/tech7_10.png"};
				for(int i = 1; i <DataBase.playerList.size(); i ++){
					PicturePlayer pic4 = new PicturePlayer(pictures4, false,20);
					int xchange = 0,ychange = 0;
					switch(DataBase.playerList.get(i).getType()){
					case 6:xchange = -22;ychange = 20;break;
					case 5:ychange = 18;break;
					case 4:xchange = -20;break;
					case 3:xchange = -24;ychange = -200;break;
					}
					pic4.panelPlay(DataBase.playerList.get(i).getX()+xchange, DataBase.playerList.get(i).getY()+DataBase.playerList.get(i).ran+ychange, g, this, 2);
				}
				if(PicturePlayer.time2 < 30){
					isTech_7 = false;
					PicturePlayer.time2 = 1000;
				}
			}
			
			/*
			 * draw pass2 tech8 effects
			 */
			if(isTech_8){
				String pictures5[] = {"graphics/stunt/rcastle1.png","graphics/stunt/rcastle2.png","graphics/stunt/rcastle3.png","graphics/stunt/rcastle4.png","graphics/stunt/rcastle5.png","graphics/stunt/rcastle6.png","graphics/stunt/rcastle7.png","graphics/stunt/rcastle8.png","graphics/stunt/rcastle9.png","graphics/stunt/rcastle10.png"};
				PicturePlayer pic = new PicturePlayer(pictures5, false,30);
				pic.panelPlay(-120, 160, g, this, 3);
				if(PicturePlayer.time3 < 31){
					isTech_8 = false;
					PicturePlayer.time3 = 1000;
				}
			}
		   
		}

		/**
		 * add unit castle and set location and start thread
		 * @see S_Castle
		 */
		private void setCastle(){
				S_Castle mycastle1 = new S_Castle();
				mycastle1.setKind(1);
				mycastle1.setHp(DataBase.CASTLE_HP_STG5);
				Thread t1 = new Thread(mycastle1);
				t1.start();
				DataBase.playerList.add(mycastle1);
				S_Castle mycastle2 = new S_Castle();
				mycastle2.setKind(1);
				mycastle2.setY(DataBase.START_LOC_Y_STG5+165);
				mycastle2.setHp(DataBase.CASTLE_HP_STG5);
				DataBase.playerList.add(mycastle2);
				S_Castle mycastle3 = new S_Castle();
				mycastle3.setKind(1);
				mycastle3.setY(DataBase.START_LOC_Y_STG5+330);
				mycastle3.setHp(DataBase.CASTLE_HP_STG5);
				DataBase.playerList.add(mycastle3);
				
				
				S_Castle enemycastle1 = new S_Castle();
				enemycastle1.setKind(0);
				enemycastle1.setX(DataBase.START_LOC_X_ENM_STG5);
				enemycastle1.setY(DataBase.START_LOC_Y_ENM_STG5);
				enemycastle1.setHp(DataBase.CASTLE_HP_ENM_STG5);
				S_Castle enemycastle2 = new S_Castle();
				enemycastle2.setKind(0);
				enemycastle2.setX(DataBase.START_LOC_X_ENM_STG5);
				enemycastle2.setY(DataBase.START_LOC_Y_ENM_STG5+165);
				enemycastle2.setHp(DataBase.CASTLE_HP_ENM_STG5);
				S_Castle enemycastle3 = new S_Castle();
				enemycastle3.setKind(0);
				enemycastle3.setX(DataBase.START_LOC_X_ENM_STG5);
				enemycastle3.setY(DataBase.START_LOC_Y_ENM_STG5+330);
				enemycastle3.setHp(DataBase.CASTLE_HP_ENM_STG5);
				Thread t2 = new Thread(enemycastle1);
				t2.start();
				DataBase.enemyList.add(enemycastle1);
				DataBase.enemyList.add(enemycastle2);
				DataBase.enemyList.add(enemycastle3);
		}

		/**
		 * keep refreshing the panel
		 * so you don't need to repaint 
		 */
		@Override
		public void run() {
			while(true){
				//if lose
				if(win()<0){
					DataBase.isPause = true;
					//if lose, the param is false, then you should add game over panel
					gameOverPanel = new PanelGameOver(false);
					gameOverPanel.addMouseListener(gameOverPanel);
					this.add(gameOverPanel);
					this.repaint();
					/*
					 * end loop,then next time the thread will die, and will not affect
					 * next game
					 */
					break;
				}
				if(win()>0){
					DataBase.isPause = true;
					gameOverPanel = new PanelGameOver(true);
					gameOverPanel.addMouseListener(gameOverPanel);
					this.add(gameOverPanel);
					this.repaint();
					break;
				}
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//keep refreshing every 50ms
				this.repaint();
			}
			
		}
		
		/**
		 * whether win or lose
		 * @return 1 if win; -1 if lose ; 0 neither
		 */
		public int win(){
			if(DataBase.playerList.size() < 3||((DataBase.playerList.size()>0)&&(DataBase.playerList.get(0).getType()!=100))||((DataBase.playerList.size()>0)&&(DataBase.playerList.get(1).getType()!=100))||((DataBase.playerList.size()>0)&&(DataBase.playerList.get(2).getType()!=100))){
				return -1;
			}
			if(DataBase.enemyList.size() < 3||((DataBase.enemyList.size()>0)&&(DataBase.enemyList.get(0).getType()!=100))||((DataBase.enemyList.size()>0)&&(DataBase.enemyList.get(1).getType()!=100))||((DataBase.enemyList.size()>0)&&(DataBase.enemyList.get(2).getType()!=100))){
				return 1;
			}
				
			return 0;
		}

}
