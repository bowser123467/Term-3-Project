package net.game.term3;

public class Main {

	public static void main(String[] args) {
		GameServer server = GameServer.getServer();
		
		server.bind();
	}

}
