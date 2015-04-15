package net.game.term3;

public class GameLogger {

	public void Log(String info){
		Class<? extends GameLogger> clazz = getClass();
		
		System.out.println("["+clazz.getSimpleName()+"] "+info);
	}
	
	public void Error(String error){
		Log("[Error] "+error);
	}
	
	public void Warning(String warning){
		Log("[Warning] "+warning);
	}
	
}
