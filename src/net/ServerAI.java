package net;

import java.net.*;
import java.io.*;

import ui.PanelClassic;
import ai.AIcommander;
import dataBase.DataBase;

public class ServerAI{
	
	BufferedReader reader;
	public static Socket socket;
	public static PrintWriter writer;
	
	public class ClientHander implements Runnable{
		
		public ClientHander(Socket client) {
			socket = client;
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			String message;
			try {
				System.out.println("listenning");
				while(DataBase.threadContinue&&(message = reader.readLine())!=null){
					System.out.println("read:"+message);
					execute(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public ServerAI() {
		try {
			ServerSocket server = new ServerSocket(5001);
			Socket client = server.accept();
			
			Thread t = new Thread(new ClientHander(client));
			t.start();
			
			System.out.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void execute(String message){
		AIcommander ai = new AIcommander();
		switch(Data.getType(message)){
		case 0:
			PanelClassic.textarea.append("receive: "+Data.getContent(message)+"\n");
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
	
	public static void sendData(int type, String content){
		if(socket.isConnected()){
			System.out.println("ready to send data");
			writer.println(new Data(type, content).toString());
			System.out.println("data send");
			writer.flush();
		}
	}
	
	public static void main(String[] args){
		new ServerAI();
	}

}
