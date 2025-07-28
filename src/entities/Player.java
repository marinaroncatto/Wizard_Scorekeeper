package entities;

public class Player {
	
	private String name;
	private int points;
	
	private Vaza vaza;

	public Player(String name, Vaza vaza) {
		this.name = name;		
		this.vaza = vaza;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Vaza getVaza() {
		return vaza;
	}

	public void setNewVaza(Vaza vaza) {
		this.vaza = vaza;
	}
	
	public void calculatePoints() {
		if(vaza.getBid() == vaza.getVictories()) 
			this.points += 20 + 10 * vaza.getVictories();
		else 
			this.points += -10 * Math.abs(vaza.getBid() - vaza.getVictories());			
	}
	
	@Override
	public String toString() {
		return name + " - points: " + points + " | " + vaza;
	}
	
	
	
	
	
	
	
	
	
}
