package entities;

import java.util.ArrayList;
import java.util.List;

import entities.excepitions.WizardException;

public class GameMatch {
	
	private int round;
	private int endGame;
	
	private List<Player> players = new ArrayList<>();
		
	public GameMatch(int HowManyPlayers) {		
		this.round = 1;
		this.endGame = calculateEndGame(HowManyPlayers);		
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
	
}
