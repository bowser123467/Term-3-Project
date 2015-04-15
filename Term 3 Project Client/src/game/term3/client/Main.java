package game.term3.client;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) throws SlickException {
		AppGameContainer agc = new AppGameContainer(new GameProject("Term 3 Project"));
		
		agc.setUpdateOnlyWhenVisible(false);
		agc.setAlwaysRender(true);
		agc.setTargetFrameRate(60);
		
		agc.start();
	}

	
	public static boolean isDebugMode(){
		return new File("debug.txt").exists();
	}
	
}
