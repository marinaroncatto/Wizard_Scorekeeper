package entities;

public class Vaza {
	
	private int bid;
	private int victories;
	private int points;
	
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

	public int getPoints() {
		return points;
	}
	
	public void calculatePoints() {
		if(this.bid == this.victories) 
			this.points += 20 + 10 * this.victories;
		else 
			this.points += -10 * Math.abs(this.bid - this.victories);			
	}
	
	@Override
	public String toString() {
		return "Vaza: bid: " + bid;
	}

	
	
	
	
}
