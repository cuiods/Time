package tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import units.Soldier;
import units.Unit;
import dataBase.DataBase;

public class Save {
	public synchronized void SaveMoney(){
		try{
			FileWriter writer = new FileWriter("Money.txt");
			writer.write(DataBase.Money+"");
			writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public synchronized void RecoverMoney(){
		
		try{
			FileReader reader = new FileReader("Money.txt");
			BufferedReader BReader = new BufferedReader(reader);
			String sentence = BReader.readLine();
			DataBase.Money = Integer.parseInt(sentence);
			reader.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public synchronized void Recover() throws IOException, ClassNotFoundException{
		FileInputStream fileStream = new FileInputStream("SaveData.ser");
		ObjectInputStream ois = new ObjectInputStream(fileStream);
		DataBase.pass = ois.read();
		DataBase.passAlready = ois.read();
	//	DataBase.Castle_HP_ply = ois.read();
	//	DataBase.Castle_HP_enm = ois.read();
		System.out.println(DataBase.Money);
		DataBase.Money_Increment = ois.read();
		System.out.println(DataBase.Money_Increment);
		DataBase.Tech_1 = ois.readBoolean();
		DataBase.Tech_2 = ois.readBoolean();
		DataBase.Tech_3 = ois.readBoolean();
		int enemyNum = ois.read();
		int playerNum = ois.read();
		while(!DataBase.enemyList.isEmpty()){
			DataBase.enemyList.remove(0);
		}
		while(!DataBase.playerList.isEmpty()){
			DataBase.playerList.remove(0);
		}
//		System.out.println("remove complete!");
		for(int i=0;i<enemyNum;i++){
			Unit temp = (Unit) ois.readObject();			
			DataBase.enemyList.add(temp);
			Thread th= new Thread(temp);
			th.start();
	//		System.out.println(temp.getType());
		}
		System.out.println("run enemy complete!");
		for(int i=0;i<playerNum;i++){
			Unit temp = (Unit) ois.readObject();			
			DataBase.playerList.add(temp);
			Thread th= new Thread(temp);
			th.start();
	//		System.out.println(temp.getType());
	//		temp.run();
		}
		ois.close();
		RecoverMoney();
	}
	public synchronized void Save() throws IOException{
		FileOutputStream fileStream = new FileOutputStream("SaveData.ser");
		ObjectOutputStream ops = new ObjectOutputStream(fileStream);
		ops.write(DataBase.pass);
		ops.write(DataBase.passAlready);
	//	ops.write(DataBase.Castle_HP_ply);
	//	ops.write(DataBase.Castle_HP_enm);
		System.out.println(DataBase.Money);
		System.out.println(DataBase.Money_Increment);
		ops.write(DataBase.Money_Increment);
		ops.writeBoolean(DataBase.Tech_1);
		ops.writeBoolean(DataBase.Tech_2);
		ops.writeBoolean(DataBase.Tech_3);
		ops.write(DataBase.enemyList.size());
		ops.write(DataBase.playerList.size());
		for(int i=0;i<DataBase.enemyList.size();i++){
			ops.writeObject(DataBase.enemyList.get(i));
		}
		for(int i=0;i<DataBase.playerList.size();i++){
			ops.writeObject(DataBase.playerList.get(i));
		}
		ops.close();
		SaveMoney();
	}
}
