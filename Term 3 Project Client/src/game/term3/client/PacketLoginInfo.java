package game.term3.client;

public class PacketLoginInfo extends GameLogger implements Packet{

	private String name;
	
	public PacketLoginInfo(){
		name = "";
	}
	
	public PacketLoginInfo(String name){
		this.name = name;
	}
	
	@Override
	public void onSend(GameClient client) {
		Log("Sent name packet with name '"+name+"'");
	}

	@Override
	public void onReceive(GameClient client) {
		
	}

}
