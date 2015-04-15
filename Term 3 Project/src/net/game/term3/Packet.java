package net.game.term3;

public interface Packet {

	public void onSend(GameServer client, ActiveConnection connection);
	public void onReceive(GameServer client, ActiveConnection connection);
	
}
