package application;

import java.util.List;
import java.util.Scanner;

import entities.GameMatch;
import entities.Player;
import entities.Vaza;


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);					
		
		System.out.print("How many players? ");
		int HowMany = sc.nextInt();
				
		while(HowMany < 3 || HowMany > 6) {
			System.out.println("The game must have between 3 and 6 players.");
			System.out.print("How many players? ");
			HowMany = sc.nextInt();
		}
		
		GameMatch gameMatch = new GameMatch(HowMany);	
		sc.nextLine();
		
		for(int i = 1; i <= HowMany; i++) {
			
			System.out.print(i + "º player's name: ");
			String name = sc.nextLine();
			
			System.out.print("Bid: ");
			int bid = sc.nextInt();
			while(!gameMatch.validateBid(bid)) {
				System.out.println("Invalid value! Bid must be possible.");
				System.out.print("Bid: ");
				bid = sc.nextInt();
			}
			
			sc.nextLine();
			Player p = new Player(name, new Vaza(bid));
			gameMatch.setPlayer(p);
			System.out.println();
		}
		
		List<Player> gameplayers = gameMatch.getPlayers();
		
		System.out.println("Jogadores: ");
		for(Player pl : gameplayers) {
			System.out.println(pl);
		}
		
		System.out.println("Número de rodadas: " + gameMatch.getEndGame());		
		System.out.println("Round: " + gameMatch.getRound());
		
		sc.close();
	}

}
