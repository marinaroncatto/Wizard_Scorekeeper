package entities;

import java.util.ArrayList;
import java.util.List;

import entities.excepitions.WizardException;

public class GameMatch {
	
	private int round;
	private int endGame;
	private int howManyPlayers;
	
	private List<Player> players = new ArrayList<>();
	private List<Player> ranking = new ArrayList<>();
		
	public GameMatch(int howManyPlayers) {		
		this.round = 1;
		this.howManyPlayers = howManyPlayers;
		this.endGame = calculateEndGame(howManyPlayers);		
	}
	
	public int getRound() {
		return round;
	}

	public void increaseRound() {
		this.round ++;
	}
	public int getEndGame() {
		return endGame;
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayer(Player player) {
		this.players.add(player);
	}
		
	public int getHowManyPlayers() {
		return howManyPlayers;
	}

	public void setHowManyPlayers(int howManyPlayers) {
		this.howManyPlayers = howManyPlayers;
	}
	
	public List<Player> getRanking() {
		return ranking;
	}

	public void setRanking(List<Player> ranking) {
		this.ranking = ranking;
	}

	public boolean validateBid(int bid) {
		return bid >= 0 && bid <= this.round;
	}

	private int calculateEndGame(int howManyPlayers) {
		int endGame = 0;
		switch(howManyPlayers) {
		case 3 -> endGame = 20;
		case 4 -> endGame = 15;
		case 5 -> endGame = 12;
		case 6 -> endGame = 10;
		default -> throw new WizardException("The game must have between 3 and 6 players.");
		}
		return endGame;
	}

	public void orderRanking() {
		this.ranking.sort((a, b) -> b.getPoints().compareTo(a.getPoints()));
	}
	
	public void printRanking() {
		System.out.println("=== Ranking: ===");
		for(Player p : ranking) {
			System.out.println(p.getName() + " - Points: " + p.getPoints());
		}
	}
	
	
}
