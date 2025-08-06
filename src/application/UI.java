package application;

import java.util.List;
import java.util.Scanner;

import entities.GameMatch;
import entities.Player;
import entities.Vaza;

public abstract class UI {

	public static GameMatch startGame(Scanner sc) {
		System.out.println("=== Welcome to Wizard Scorekeeper! ===");
		System.out.println();
		System.out.print("How many players? ");
		int HowMany = sc.nextInt();

		while (HowMany < 3 || HowMany > 6) {
			System.out.println("The game must have between 3 and 6 players.");
			System.out.print("How many players? ");
			HowMany = sc.nextInt();
		}
		GameMatch gameMatch = new GameMatch(HowMany);
		sc.nextLine();		
		return gameMatch;
	}

	public static void enterPlayers(GameMatch gameMatch, Scanner sc) {
		int n = gameMatch.getHowManyPlayers();
		for (int i = 1; i <= n; i++) {

			System.out.print(i + "º player's name: ");
			String name = sc.nextLine();
			name = (name.length() < 3) ? nameTreatment(name) : name.substring(0, 3);			
			name = name.substring(0,1).toUpperCase().concat(name.substring(1).toLowerCase());

			Player p = new Player(name);
			gameMatch.setPlayer(p);
			System.out.println();
		}
		printRound(gameMatch);		
	}
	
	private static String nameTreatment(String name) {
		String newName = "";
		while(newName.length() < 3) {					
			if(!name.isEmpty() && newName.isEmpty()) {
				if(name.length() == 1) 
					newName +=  name.substring(0, 1);
				else {
					for(int i = 1; i <= name.length(); i++) 														
						newName +=  name.substring(i -1 , i);						
				}	
			}			
			newName +="_";
		}
		
		return newName;
	}
	
	public static void startNewRound(GameMatch gameMatch, Scanner sc) {							
		for (int i = 0; i < gameMatch.getPlayers().size(); i++) {
			System.out.print(gameMatch.getPlayers().get(i).getName()+ "'s bid: ");
			int bid = sc.nextInt();
			while (!gameMatch.validateBid(bid)) {
				System.out.println("Invalid value! Bid must be possible.");
				System.out.print("Bid: ");
				bid = sc.nextInt();
			}		
			gameMatch.getPlayers().get(i).setNewVaza(new Vaza(bid));						
		}		
	}
		
	private static void printRound(GameMatch gameMatch) {
		System.out.println("=== Players: ===");
		for(Player pl : gameMatch.getPlayers()) {
			System.out.println(pl);
		}
		System.out.println();
		System.out.println("Número de rodadas: " + gameMatch.getEndGame());		
		System.out.println("Round: " + gameMatch.getRound());
	}
	
	public static void inputVictories(List<Player> players, Scanner sc) {	
		for(int i = 0; i < players.size(); i++) {
			System.out.print("Enter "+players.get(i).getName()+"'s victories: ");
			players.get(i).getVaza().setVictories(sc.nextInt());
			System.out.println();
		}
	}
	
	public static void printFinishVaza(GameMatch gameMatch) {

		System.out.println("=== "+ gameMatch.getRound()+"º round result: ===");
		for(Player pl : gameMatch.getPlayers()) {
			pl.calculatePoints();
			System.out.println(pl.getName() + " | victories: " + pl.getVaza().getVictories() + " | bid: " + pl.getVaza().getBid() + " - points: "+ pl.getVaza().getPoints());
		}
									
	}

	public static void showRanking (GameMatch gameMatch) {		
		gameMatch.orderRanking ();
		gameMatch.printRanking ();
	}

	public static void whoWins(GameMatch gameMatch) {
		gameMatch.setWinner();
		if(gameMatch.getWinner().size() > 1) 
			System.out.println("** === TIE === **");
		else
			System.out.println("** === THE WINNER IS: === **");
		for(Player pl : gameMatch.getWinner()) 
			System.out.println(pl.getName() + " - points: " + pl.getPoints());
			
	}
	
}

