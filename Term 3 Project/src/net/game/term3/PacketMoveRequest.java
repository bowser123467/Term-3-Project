package net.game.term3;

public class PacketMoveRequest extends GameLogger implements Packet {

	private int x;
	private int y;

	@Override
	public void onSend(GameServer client, ActiveConnection connection) {
		
	}

	@Override
	public void onReceive(GameServer client, ActiveConnection connection) {
		
	}

}
