package application;

import java.util.List;
import java.util.Scanner;

import entities.GameMatch;
import entities.Player;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		GameMatch gameMatch = UI.startGame(sc);
		System.out.println();
		List<Player> players = UI.enterPlayers(gameMatch, sc);
		while (gameMatch.getRound() <= gameMatch.getEndGame()){		
			System.out.println();
			UI.inputVictories(players, sc);
			UI.printFinishVaza(players, gameMatch);
			System.out.println();
			UI.ranking(gameMatch);
			System.out.println();
			gameMatch.increaseRound();
			UI.startNewRound(players, gameMatch, sc);
		}
				
		sc.close();
	}

}
