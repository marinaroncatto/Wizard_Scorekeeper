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

	public void upgradeVaza(Vaza vaza) {
		this.vaza = vaza;
	}

	@Override
	public String toString() {
		return name + " - points: " + points + " | " + vaza;
	}
	
	
	
	
	
	
	
	
	
}
