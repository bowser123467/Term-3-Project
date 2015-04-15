package game.term3.client;

public interface Packet {

	public void onSend(GameClient client);
	public void onReceive(GameClient client);
	
}
