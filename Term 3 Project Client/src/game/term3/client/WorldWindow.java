package game.term3.client;

import org.newdawn.slick.tiled.TiledMap;

public class WorldWindow {

	private int x;
	private int y;
	
	private int width;
	private int height;

	public WorldWindow(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void renderTileMap(int cx, int cy, TiledMap map){
		map.render(cx, cy, x, y, width, height);
	}
	
	public void setPosition(int x, int y){
		setX(x);
		setY(y);
	}

	public void setY(int y2) {
		y = y2;
	}
	
	public void setX(int x2){
		x = x2;
	}
	
}
