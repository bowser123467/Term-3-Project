package game.term3.client;

public class PacketMoveRequest extends GameLogger implements Packet {

	private int x;
	private int y;
	
	@Override
	public void onSend(GameClient client) {
		Log("Requesting to move to "+x+" "+y);
	}

	@Override
	public void onReceive(GameClient client) {
		
	}

}
