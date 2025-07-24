package entities;

public class Vaza {
	
	private int bid;
	private int victories;
		
	public Vaza(int bid) {		
		this.bid = bid;
	}

	public int getBid() {
		return bid;
	}

	public int getVictories() {
		return victories;
	}

	public void setVictories(int victories) {
		this.victories = victories;
	}

	@Override
	public String toString() {
		return "Vaza: bid: " + bid + ", victories: " + victories;
	}

	
	
	
	
}
