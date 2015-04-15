package game.term3.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameProject extends StateBasedGame {

	private static GameProject instance;
	
	public static final int PLAYING_STATE = 1;
	public static final int MENU_STATE = 0;
	
	public GameProject(String name) {
		super(name);
		instance = this;
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new MenuState());
		addState(new PlayingState());
	}

	public static GameProject getInstance() {
		return instance;
	}

}
