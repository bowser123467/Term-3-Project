package net.game.term3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class GameServer extends GameLogger {

	private static GameServer gServer;
	
	private Server server;
	private int port;
	private List<ActiveConnection> connections;
	
	public GameServer(int port){
		server = new Server();
		this.port = port;
		connections = new ArrayList<>();
	}
	
	public void bind(){
		try {
			
			Kryo kryo = server.getKryo();
			
			kryo.register(PacketLoginInfo.class);
			
			server.addListener(new Listener() {

				@Override
				public void connected(Connection connection) {
					connections.add(new ActiveConnection(connection.getID()));
					Log("Connection from "+connection.getRemoteAddressTCP().getAddress()+" assigned ID "+connection.getID());
				}

				@Override
				public void disconnected(Connection connection) {
					Log("Disconnection!");
					
					ActiveConnection ac = getActiveConnectionById(connection.getID());
					
					connections.remove(ac);
				}

				@Override
				public void received(Connection connection, Object object) {
					if(object instanceof Packet){
						Packet packet = (Packet) object;
						packet.onReceive(getServer(), getActiveConnectionById(connection.getID()));
					}
				}
				
				
			});

			server.start();
			
			server.bind(port, port+1);
			
			
			Log("Bound to ports "+port+" and "+(port+1));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getKryoConnectionById(int id){
		for(Connection c : server.getConnections()){
			if(c.getID() == id){
				return c;
			}
		}
		
		return null;
	}
	
	public ActiveConnection getActiveConnectionById(int id){
		for(ActiveConnection c : connections){
			if(c.getId() == id){
				return c;
			}
		}
		
		return null;
	}
	
	public static GameServer getServer(){
		
		if(gServer == null)
			gServer = new GameServer(25565);
		
		return gServer;
	}
	
}
