package entities;

public class Vaza {
	
	private int bid;
	private int victories;
	private int round;
	
	public Vaza(int bid, int victories, int round) {		
		this.bid = bid;
		this.victories = victories;
		this.round = round;
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

	public int getRound() {
		return round;
	}

	@Override
	public String toString() {
		return "Vaza: bid=" + bid + ", victories=" + victories + ", round=" + round;
	}

	
	
	
	
}
