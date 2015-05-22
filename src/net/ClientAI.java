package net;
import java.io.*;
import java.net.*;

import ui.PanelClassic;
import ai.AIcommander;
import dataBase.DataBase;
public class ClientAI{
	
	public static Socket socket;
	BufferedReader reader;
	static PrintWriter writer;
	
	public ClientAI(String ip) {
		try {
			socket = new Socket(ip, 5001);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream());
			System.out.println("network set up");
			Thread t = new Thread(new IncomingReader());
			t.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void execute(String message) {
		AIcommander ai = new AIcommander();
		switch(Data.getType(message)){
		case 0:
			PanelClassic.textarea.append("receive: "+Data.getContent(message));
			break;
		case 1:
			String[] m = Data.getContent(message).split("_");
			int path = Integer.parseInt(m[0]);
			switch(Integer.parseInt(m[1])){
			case 3:ai.addMedicTeam(path);break;
			case 4:ai.addSniper(path);break;
			case 5:ai.addTruck(path);break;
			case 6:ai.addRifle(path);break;
			case 8:break;
			case 9:ai.addSpaceCarrier(path);break;
			case 10:ai.addSpaceMan(path);break;
			case 11:ai.addSpaceShip(path);break;
			case 12:ai.addDrone(path);break;
			case 13:ai.addRazerShip(path);break;
			case 14:ai.addRobotWarrior(path);break;
			case 15:ai.addSneaker(path);break;
			}
			break;
		case 2:break;
		}
		
	}
	
	public class IncomingReader implements Runnable{

		@Override
		public void run() {
			String message;
			System.out.println("listenning");
			try {
				while(DataBase.threadContinue&&(message = reader.readLine())!=null){
					System.out.println("read:"+message);
					execute(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void sendData(int type, String content){
		if(socket.isConnected()){
			System.out.println("ready to send data");
			writer.println(new Data(type, content).toString());
			System.out.println("data send");
			writer.flush();
		}
	}
	

	public static void main(String[] args){

		new ClientAI("127.0.0.1");
		while(DataBase.threadContinue){
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String message = br.readLine();
				System.out.println(message);
				writer.println(message);
				writer.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}
