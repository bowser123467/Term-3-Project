package game.term3.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PlayingState extends BasicGameState {

	private World world;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		world = new World("maptest.tmx");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		world.render(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		world.update(delta);
	}

	@Override
	public int getID() {
		return GameProject.PLAYING_STATE;
	}

}
