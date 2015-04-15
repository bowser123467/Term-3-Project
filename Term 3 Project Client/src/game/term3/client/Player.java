package game.term3.client;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Player extends Actor {

	public Player(World world) {
		super(world);
	}
	
	public void update(int delta){
		Input i = GameProject.getInstance().getContainer().getInput();
		
		int mx = i.getMouseX();
		int my = i.getMouseY();
		
		int tmx = mx / world.getTileMap().getTileWidth();
		int tmy = my / world.getTileMap().getTileHeight();
		
		if(i.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			if(!(tmx > world.getTileMap().getWidth() || tmx < 0 || tmy > world.getTileMap().getHeight() || tmy < 0)){
				setTarget(tmx, tmy);
			}
		}
		
		super.update(delta);
	}
	
	public void render(Graphics g){

		Input i = GameProject.getInstance().getContainer().getInput();
		
		int mx = i.getMouseX();
		int my = i.getMouseY();
		
		int tmx = mx / world.getTileMap().getTileWidth();
		int tmy = my / world.getTileMap().getTileHeight();
		
		
		g.setColor(Color.red);
		g.drawOval(getX(), getY(), 5, 5);
		g.setColor(Color.white);
		g.fillRect(tmx * world.getTileMap().getTileWidth(), tmy * world.getTileMap().getTileHeight(), world.getTileMap().getTileWidth(), world.getTileMap().getTileHeight());
	}
	

}
