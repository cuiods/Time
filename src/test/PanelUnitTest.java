package test;

import javax.swing.JFrame;

import ui.PanelUnit;

public class PanelUnitTest extends JFrame{

	public static void main(String[] args){
		new PanelUnitTest();
	}
	
	public PanelUnitTest(){
		PanelUnit unit = new PanelUnit();
		this.setLayout(null);
		this.add(unit);
		this.setVisible(true);
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
