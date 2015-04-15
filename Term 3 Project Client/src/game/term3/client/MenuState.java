package game.term3.client;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState {

	private String name;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		name = "";
		GameClient.getClient().connect();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {

		g.drawString("Enter your characters name: (Min 6, Max 12) ", 100, 100);
		
		g.setColor(!isValidName(name) ? Color.red : Color.white);
		g.drawString("'"+name+"'", 100, 125);	
		g.setColor(Color.white);
		
		if(Main.isDebugMode()){
			g.drawString("Debug Mode", 100, 150);
			g.drawString(String.format("Connected: %b", GameClient.getClient().isConnected()), 100, 175);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
	}
	
	public boolean isValidName(String name){
		if(name.length() < 5){
			return false;
		}
		if(name.length() > 12){
			return false;
		}
		
		return true;
	}
	
	public void keyPressed(int key, char c){
		
		if(key == Input.KEY_BACK){
			
			if(name.length() == 0)
				return;
			
			name = name.substring(0, name.length()-1);
		}else if(key == Input.KEY_ENTER){
			if(!isValidName(name))
				return;
			
			PacketLoginInfo info = new PacketLoginInfo(name);
			
			GameClient.getClient().sendPacket(info);
			
			if(!GameClient.getClient().isConnected()){
				GameProject.getInstance().enterState(GameProject.PLAYING_STATE);
			}
			
		}else{
			
			if(name.length() > 11)
				return;
			
			if(Character.isAlphabetic(c)){
				name += c;
			}

		}
	}

	@Override
	public int getID() {
		return GameProject.MENU_STATE;
	}

}
