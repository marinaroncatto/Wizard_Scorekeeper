package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.GameMatch;


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		GameMatch gameMatch;
		List<String> players = new ArrayList<>();
		
		System.out.print("How many players? ");
		int n = sc.nextInt();
				
		while(n < 3 || n > 6) {
			System.out.println("The game must have between 3 and 6 players.");
			System.out.print("How many players? ");
			n = sc.nextInt();
		}
			
		sc.nextLine();
		
		for(int i = 1; i <= n; i++) {
			
			System.out.print(i + "º player's name: ");
			players.add(sc.nextLine());
		}
		
		gameMatch = new GameMatch(players);
		
		List<String > gameplayers = gameMatch.getPlayers();
		
		System.out.println("Jogadores: ");
		for(String pl : gameplayers) {
			System.out.println(pl);
		}
		
		System.out.println("Número de rodadas: " + gameMatch.getEndGame());		
		System.out.println("Round: " + gameMatch.getRound());
		
		sc.close();
	}

}
