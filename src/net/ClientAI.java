package net;
import java.io.*;
import java.net.*;

import dataBase.DataBase;
public class ClientAI{
	
	static Socket socket;
	BufferedReader reader;
	static PrintWriter writer;
	
	public ClientAI(String ip) {
		try {
			socket = new Socket(ip, 5000);
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
		switch(Data.getType(message)){
		case 0:break;
		case 1:break;
		case 2:break;
		}
		
	}
	
	public class IncomingReader implements Runnable{

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
