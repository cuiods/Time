package ui;

import java.awt.*;

import javax.swing.*;

import ui.button.ButtonNext;

public class StoryPlayer {
          //关卡
          int pass;
      	public static Panelstory1 first = null;
    	public static Panelstory2 second = null;
    	public static Panelstory3 third = null;
          //关卡作为参数传进来
          public StoryPlayer(int pass){
        	 this.pass = pass;
        	 if(pass==1)
        	 first = new Panelstory1();
        	 second = new Panelstory2();
        	 third = new Panelstory3();
          }
          
    
       
}
