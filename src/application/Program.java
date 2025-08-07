package application;

import java.util.Scanner;

import entities.GameMatch;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		GameMatch gameMatch = UI.startGame(sc);
		System.out.println();
		UI.enterPlayers(gameMatch, sc);
		while (gameMatch.getRound() <= gameMatch.getEndGame()){	
			UI.clearScreen();
			UI.startNewRound(gameMatch, sc);
			UI.pressToContinue(sc);
			UI.inputVictories(gameMatch.getPlayers(), sc);
			UI.printFinishVaza(gameMatch);	
			System.out.println();
			UI.showRanking(gameMatch);			
			gameMatch.increaseRound();	
			gameMatch.bidRotation();
			UI.pressToContinue(sc);
		}
		UI.clearScreen();
		System.out.println();
		UI.whoWins(gameMatch);		
		sc.close();
	}

}
