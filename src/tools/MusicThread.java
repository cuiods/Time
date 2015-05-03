package tools;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicThread extends Thread{

	String filepath;
	boolean loop;
	MusicPlayer mp = new MusicPlayer();
	public MusicThread(String filepath,boolean loop) {
		this.filepath = filepath;
		this.loop = loop;
	}

	@Override
	public void run() {
		try {
			mp.play(filepath, loop);
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void stopmusic(){
		mp.stop = true;
	}
}
