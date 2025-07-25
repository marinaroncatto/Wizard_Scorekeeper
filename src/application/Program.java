package application;

import java.util.List;
import java.util.Scanner;

import entities.GameMatch;
import entities.Player;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		GameMatch gameMatch = UI.startGame(sc);
		List<Player> players = UI.enterPlayers(gameMatch, sc);
		UI.printRound(players, gameMatch);
		System.out.println();
		UI.printFinishVaza(players, gameMatch);
		
		sc.close();
	}

}
