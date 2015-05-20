package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import units.S_Unit;
import dataBase.DataBase;

public class Save {
	private int type;
	public String saveTime;
	public Save(int type){
		this.type = type;
	}
	public synchronized void SaveMoney(){
		try{
			File find = new File("save/Money"+type+".txt");
			if(!find.exists()){
				find.createNewFile();
			}
			FileWriter writer = new FileWriter(find);
			writer.write(DataBase.Money+"");
			writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public synchronized void RecoverMoney(){
		
		try{
			File find = new File("save/Money"+type+".txt");
			if(!find.exists()){
				find.createNewFile();
			}
			FileReader reader = new FileReader(find);
			BufferedReader BReader = new BufferedReader(reader);
			String sentence = BReader.readLine();
			DataBase.Money = Integer.parseInt(sentence);
			BReader.close();
			reader.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public synchronized void Recover() throws IOException, ClassNotFoundException{
		File findFile = new File("save");
		if(!findFile.exists()){
			findFile.mkdir();
		}
		findFile = new File("save/SaveData"+type+".ser");
		if(findFile.exists()){
			FileInputStream fileStream = new FileInputStream(findFile);
			ObjectInputStream ois = new ObjectInputStream(fileStream);
			
			DataBase.pass = ois.read();
			DataBase.passAlready = ois.read();
		//	DataBase.Castle_HP_ply = ois.read();
		//	DataBase.Castle_HP_enm = ois.read();
//			System.out.println(DataBase.Money);
			DataBase.Money_Increment = ois.read();
			DataBase.StartTime = ois.readLong();
//			System.out.println(DataBase.Money_Increment);
			
			DataBase.Tech_CannonEnable = ois.readBoolean();
			DataBase.Tech_MoneyBoom = ois.readBoolean();
			DataBase.Tech_Destroy = ois.readBoolean();
			
			DataBase.Tech_MedicEnable = ois.readBoolean();
			DataBase.Tech_TruckReinforce = ois.readBoolean();
			DataBase.Tech_LessTime = ois.readBoolean();
			DataBase.Tech_Heal = ois.readBoolean();
			DataBase.Tech_CastleReinforce = ois.readBoolean();
			
			DataBase.Tech_SecondCastle = ois.readBoolean();
			DataBase.Tech_Harper = ois.readBoolean();
			DataBase.Tech_SuperComputer = ois.readBoolean();
			DataBase.Tech_HydrogenBomb = ois.readBoolean();
			
			DataBase.Tech_Faith = ois.readBoolean();
			DataBase.Tech_FourthTechRevolution = ois.readBoolean();
			DataBase.Tech_BlackHoleProject = ois.readBoolean();
			
			DataBase.Tech_CoverProject = ois.readBoolean();
			DataBase.Tech_HaltScience = ois.readBoolean();
			DataBase.Tech_Escape = ois.readBoolean();
			
			DataBase.Tech_QINLIU = ois.readBoolean();
			DataBase.Tech_REN = ois.readBoolean();
			
			int enemyNum = ois.read();
			int playerNum = ois.read();
			while(!DataBase.enemyList.isEmpty()){
				DataBase.enemyList.remove(0);
			}
			while(!DataBase.playerList.isEmpty()){
				DataBase.playerList.remove(0);
			}
//			System.out.println("remove complete!");
			for(int i=0;i<enemyNum;i++){
				S_Unit temp = (S_Unit) ois.readObject();			
				DataBase.enemyList.add(temp);
				Thread th= new Thread(temp);
				th.start();
		//		System.out.println(temp.getType());
			}
			System.out.println("run enemy complete!");
			for(int i=0;i<playerNum;i++){
				S_Unit temp = (S_Unit) ois.readObject();			
				DataBase.playerList.add(temp);
				Thread th= new Thread(temp);
				th.start();
		//		System.out.println(temp.getType());
		//		temp.run();
			}
			ois.close();
			fileStream.close();
			RecoverMoney();
		}
		
	}
	public synchronized void Save() throws IOException{
		File find = new File("save");
		if(!find.exists()){
			find.mkdir();
		}
		find = new File("save/SaveData"+type+".ser");
		if(!find.exists()){
			find.createNewFile();
		}
		FileOutputStream fileStream = new FileOutputStream(find);
		ObjectOutputStream ops = new ObjectOutputStream(fileStream);
		
//		ops.writeChars(Time.getTimeNow());
		
		ops.write(DataBase.pass);
		ops.write(DataBase.passAlready);
	//	ops.write(DataBase.Castle_HP_ply);
	//	ops.write(DataBase.Castle_HP_enm);
//		System.out.println(DataBase.Money);
//		System.out.println(DataBase.Money_Increment);
		ops.write(DataBase.Money_Increment);
		ops.writeLong(DataBase.StartTime);

		ops.writeBoolean(DataBase.Tech_CannonEnable);
		ops.writeBoolean(DataBase.Tech_MoneyBoom);
		ops.writeBoolean(DataBase.Tech_Destroy);

		ops.writeBoolean(DataBase.Tech_MedicEnable);
		ops.writeBoolean(DataBase.Tech_TruckReinforce);
		ops.writeBoolean(DataBase.Tech_LessTime);
		ops.writeBoolean(DataBase.Tech_Heal);
		ops.writeBoolean(DataBase.Tech_CastleReinforce);

		ops.writeBoolean(DataBase.Tech_SecondCastle);
		ops.writeBoolean(DataBase.Tech_Harper);
		ops.writeBoolean(DataBase.Tech_SuperComputer);
		ops.writeBoolean(DataBase.Tech_HydrogenBomb);

		ops.writeBoolean(DataBase.Tech_Faith);
		ops.writeBoolean(DataBase.Tech_FourthTechRevolution);
		ops.writeBoolean(DataBase.Tech_BlackHoleProject);

		ops.writeBoolean(DataBase.Tech_CoverProject);
		ops.writeBoolean(DataBase.Tech_HaltScience);
		ops.writeBoolean(DataBase.Tech_Escape);

		ops.writeBoolean(DataBase.Tech_QINLIU);
		ops.writeBoolean(DataBase.Tech_REN);

		ops.write(DataBase.enemyList.size());
		ops.write(DataBase.playerList.size());
		for(int i=0;i<DataBase.enemyList.size();i++){
			ops.writeObject(DataBase.enemyList.get(i));
		}
		for(int i=0;i<DataBase.playerList.size();i++){
			ops.writeObject(DataBase.playerList.get(i));
		}
		ops.close();
		fileStream.close();
		SaveMoney();
	}
}
