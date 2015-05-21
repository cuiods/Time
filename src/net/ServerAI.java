package net;

import java.net.*;
import java.io.*;

import dataBase.DataBase;

public class ServerAI{

	public class ClientHander implements Runnable{

		BufferedReader reader;
		Socket socket;
		
		public ClientHander(Socket client) {
			socket = client;
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			String message;
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
	
	public ServerAI() {
		try {
			ServerSocket server = new ServerSocket(5000);
			Socket client = server.accept();
			
			Thread t = new Thread(new ClientHander(client));
			t.start();
			
			System.out.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void execute(String message){
		switch(Data.getType(message)){
		case 0:break;
		case 1:break;
		case 2:break;
		}
	}
	
	public static void main(String[] args){
		new ServerAI();
	}

}
