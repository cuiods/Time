package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.button.ButtonNetChoose;
import ui.button.ButtonOnlineStart;
import ui.button.ButtonReturn;

public class PanelNetSet extends JPanel{

	String IP = null;
	public static JTextField textIP = null;
	public static boolean show = false;
	public PanelNetSet() {
		setLayout(null);
		
		ButtonReturn returnButton = new ButtonReturn();
	    returnButton.setType(1);
	    returnButton.addMouseListener(returnButton);
	    returnButton.setBounds(10, 500, 80, 80);
	    add(returnButton);
	    
	    ButtonNetChoose choose0 = new ButtonNetChoose(0);
	    ButtonNetChoose choose1 = new ButtonNetChoose(1);
	    choose0.addMouseListener(choose0);
	    choose1.addMouseListener(choose1);
	    add(choose0);add(choose1);
	    
	    ButtonOnlineStart start = new ButtonOnlineStart();
	    start.addMouseListener(start);
	    add(start);
	    
	    //get IP
	    try {
			IP = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	    
	    //set text field
	    textIP = new JTextField();
	    textIP.setBounds(580, 300, 100, 20);
	    add(textIP);
	    
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon("graphics/background/background.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		g.drawImage(new ImageIcon("graphics/net/netset.png").getImage(), 400,50,434,306, this);
		Font font = new Font("Î¢ÈíÑÅºÚ", Font.BOLD,20);
		g.setColor(Color.red);
		g.setFont(font);
		g.drawString(IP, 545, 285);
		
		if(!show){
			g.drawImage(new ImageIcon("graphics/net/wait.png").getImage(), 340, 400, 320, 70, this);
			g.drawImage(new ImageIcon("graphics/net/wait.gif").getImage(), 530, 400, 100, 70, this);
		}
	}
}
