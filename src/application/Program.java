package application;

import java.util.Scanner;

import entities.GameMatch;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		GameMatch gameMatch = UI.startGame(sc);
		System.out.println();
		UI.enterPlayers(gameMatch, sc);
		while (gameMatch.getRound() <= gameMatch.getEndGame()){		
			System.out.println();
			UI.inputVictories(gameMatch.getPlayers(), sc);
			UI.printFinishVaza(gameMatch);
			System.out.println();
			UI.showRanking(gameMatch);
			System.out.println();
			gameMatch.increaseRound();
			UI.startNewRound(gameMatch, sc);
		}
		System.out.println();
		UI.whoWins(gameMatch);		
		sc.close();
	}

}
