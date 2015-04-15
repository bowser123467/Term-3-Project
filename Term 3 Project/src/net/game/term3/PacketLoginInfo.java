package net.game.term3;

public class PacketLoginInfo extends GameLogger implements Packet{

	private String name;
	
	public PacketLoginInfo(){
		name = "";
	}
	
	public PacketLoginInfo(String name){
		this.name = name;
	}

	@Override
	public void onSend(GameServer client, ActiveConnection connection) {
		connection.setName(name);
	}

	@Override
	public void onReceive(GameServer client, ActiveConnection connection) {
		
		Log("Client "+connection.getId()+" changed name from '"+connection.getName()+"' to '"+name+"'");
		connection.setName(name);
	}

}
