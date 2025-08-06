package entities;

public class Player {
	
	private String name;
	private Integer points;
	
	private Vaza vaza;
	
	public Player(String name) {
		this.name = name;
		this.points = 0;
	}

	public String getName() {
		return name;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Vaza getVaza() {
		return vaza;
	}

	public void setNewVaza(Vaza vaza) {
		this.vaza = vaza;
	}
	
	public void calculatePoints() {
		this.vaza.calculatePoints();
		this.points += this.vaza.getPoints();
	}
	
	@Override
	public String toString() {
		return name + " - points: " + points + " | " + vaza;
	}
	
	
	
	
	
	
	
	
	
}
