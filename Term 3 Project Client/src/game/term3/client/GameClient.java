package game.term3.client;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class GameClient extends GameLogger{

	private static GameClient gClient;
	
	private Client client;
	private String ip;
	private int port;
	
	public GameClient(String ip, int port){
		this.ip = ip;
		this.port = port;
		client = new Client();
	}
	
	public void connect(){
		try {
			
			Kryo kryo = client.getKryo();
			
			kryo.register(PacketLoginInfo.class);
			
			Log("Registered Kryo information");
			
			client.addListener(new Listener(){

				@Override
				public void connected(Connection connection) {
					Log("Connected to "+ip+":"+port+":"+(port+1));
				}

				@Override
				public void disconnected(Connection connection) {
					Error("Disconnected with server!");
				}

				@Override
				public void received(Connection connection, Object object) {
					if(object instanceof Packet){
						Packet packet = (Packet) object;
						
						packet.onReceive(getClient());
					}
				}
				
				
				
			});
			
			client.start();
			
			client.connect(5000, ip, port, port+1);

			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void sendPacket(Packet packet) {
		if(client.isConnected()){
			client.sendTCP(packet);
			packet.onSend(getClient());
		}else{
			Warning("Skipped sending packet, not connected.");
		}
	}
	
	public static GameClient getClient(){
		
		if(gClient == null){
			gClient = new GameClient("localhost", 25565);
		}
		
		return gClient;
	}

	public boolean isConnected() {
		return client.isConnected();
	}
	
	
}
