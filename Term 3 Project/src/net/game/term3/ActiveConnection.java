package net.game.term3;

public class ActiveConnection {

	private final int id;
	
	private String name;
	
	public ActiveConnection(int id){
		this.id = id;
		name = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof ActiveConnection){
			if(((ActiveConnection)obj).id == getId()){
				return true;
			}
		}
		
		return false;
	}
	
}
