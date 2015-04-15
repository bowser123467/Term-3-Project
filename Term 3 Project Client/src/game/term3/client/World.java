package game.term3.client;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class World implements TileBasedMap{

	private TiledMap loadedMap;
	private WorldWindow window;
	private List<Actor> actors;
	private Player player;
	
	public World(String str){
		try {
			
			InputStream input = World.class.getResourceAsStream("/res/"+str);
			
			loadedMap = new TiledMap(input);
			window = new WorldWindow(0, 0, 16, 16);
			player = new Player(this);
			actors = new ArrayList<>();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void render(Graphics g){
		window.renderTileMap(0, 0, loadedMap);
		
		for(Actor a : actors){
			a.render(g);
		}
		
		player.render(g);
	}
	
	public void update(int delta){
		for(Actor a : actors){
			a.update(delta);
		}
		
		player.update(delta);
	}
	
	public int getTileId(int x, int y){
		return loadedMap.getTileId(x, y, 0);
	}
	
	public boolean isVacant(int x, int y){
		
		int tileId = getTileId(x, y);
		
		if(loadedMap.getTileProperty(tileId, "solid", "no").equals("yes")){
			return false;
		}
		
		for(Actor actor : actors){
			if(actor.getX() == x && actor.getY() == y){
				return false;
			}
		}
		
		return true;
	}

	public TiledMap getTileMap() {
		return loadedMap;
	}
	
	public int getTileWidth(){
		return loadedMap.getTileWidth();
	}
	
	public int getTileHeight(){
		return loadedMap.getTileHeight();
	}

	@Override
	public boolean blocked(PathFindingContext context, int tx, int ty) {
		return !isVacant(tx, ty);
	}

	@Override
	public float getCost(PathFindingContext context, int tx, int ty) {
		return 0;
	}

	@Override
	public int getHeightInTiles() {
		return loadedMap.getHeight();
	}

	@Override
	public int getWidthInTiles() {
		return loadedMap.getWidth();
	}

	@Override
	public void pathFinderVisited(int x, int y) {
		
	}
}
