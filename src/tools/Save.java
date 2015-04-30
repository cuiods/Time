package tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import units.Unit;
import dataBase.DataBase;

public class Save {
	public void Recover() throws IOException, ClassNotFoundException{
		FileInputStream fileStream = new FileInputStream("SaveData.ser");
		ObjectInputStream os = new ObjectInputStream(fileStream);
		DataBase.pass = os.read();
		DataBase.passAlready = os.read();
		DataBase.Money = os.read();
		DataBase.Money_Increment = os.read();
		DataBase.Tech_1 = os.readBoolean();
		DataBase.Tech_2 = os.readBoolean();
		DataBase.Tech_3 = os.readBoolean();
		int enemyNum = os.read();
		int playerNum = os.read();
		for(int i=0;i<enemyNum;i++){
			DataBase.enemyList.add((Unit) os.readObject());
		}
		for(int i=0;i<playerNum;i++){
			DataBase.playerList.add((Unit) os.readObject());
		}
	}
	public void Save() throws IOException{
		FileOutputStream fileStream = new FileOutputStream("SaveData.ser");
		ObjectOutputStream os = new ObjectOutputStream(fileStream);
		os.write(DataBase.pass);
		os.write(DataBase.passAlready);
		os.write(DataBase.Money);
		os.write(DataBase.Money_Increment);
		os.writeBoolean(DataBase.Tech_1);
		os.writeBoolean(DataBase.Tech_2);
		os.writeBoolean(DataBase.Tech_3);
		os.write(DataBase.enemyList.size());
		os.write(DataBase.playerList.size());
		for(int i=0;i<DataBase.enemyList.size();i++){
			os.writeObject(DataBase.enemyList.get(i));
		}
		for(int i=0;i<DataBase.playerList.size();i++){
			os.writeObject(DataBase.playerList.get(i));
		}
		
	}
}
