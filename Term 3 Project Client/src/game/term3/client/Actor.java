package game.term3.client;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.Path.Step;

public class Actor extends GameLogger implements Mover{

	private int x;
	private int y;
	protected World world;
	
	private int targetX;
	private int targetY;
	private boolean hasPath;
	
	public Actor(World world){
		this.world = world;
		setTarget(0, 0);
		hasPath = false;
	}
	
	public Actor(World world, int x, int y){
		this(world);
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getTileX(){
		return x / world.getTileWidth();
	}
	
	public int getTileY(){
		return y / world.getTileHeight();
	}
	
	public void moveUp(){
		
	}

	public void update(int delta) {
		if(hasPath){
			AStarPathFinder pf = new AStarPathFinder(world, 100, false);
			
			Path path = pf.findPath(this, getTileX(), getTileY(), targetX, targetY);
			
			if(path != null){
				if(path.getLength() > 0){
					Step step = path.getStep(1);
					x = step.getX() * 16;
					y = step.getY() * 16;
				}
			}
			
			if(getTileX() == targetX && getTileY() == targetY){
				hasPath = false;
			}
			
		}
	}

	public void render(Graphics g) {
		
	}
	
	public void setTarget(int x, int y){
		targetX = x;
		targetY = y;
		hasPath = true;
	}
	
}
