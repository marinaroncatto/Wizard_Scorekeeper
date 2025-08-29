package application;

import java.util.List;
import java.util.Scanner;

import entities.GameMatch;
import entities.Player;
import entities.Vaza;

public abstract class UI {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static GameMatch startGame(Scanner sc) {	
		System.out.println("===  "+ANSI_YELLOW_BACKGROUND + ANSI_BLACK+ " Welcome to Wizard Scorekeeper! " + ANSI_RESET +  "  ===");
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
			name = name.substring(0, 1).toUpperCase().concat(name.substring(1).toLowerCase());

			Player p = new Player(name);
			gameMatch.setPlayer(p);
			System.out.println();
		}
		
	}

	private static String nameTreatment(String name) {
		String newName = "";
		while (newName.length() < 3) {
			if (!name.isEmpty() && newName.isEmpty()) {
				if (name.length() == 1)
					newName += name.substring(0, 1);
				else {
					for (int i = 1; i <= name.length(); i++)
						newName += name.substring(i - 1, i);
				}
			}
			newName += "_";
		}

		return newName;
	}
	
	public static void pressToContinue(Scanner sc) {
		System.out.println();		
		System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " Press enter to continue " + ANSI_RESET);		
		sc.nextLine();	
	}
	
	
	public static void startNewRound(GameMatch gameMatch, Scanner sc) {
		
		printRound(gameMatch);
		System.out.println();
		
		for (int i = 0; i < gameMatch.getPlayers().size(); i++) {
			System.out.print(gameMatch.getPlayers().get(i).getName() + "'s bid: ");
			int bid = sc.nextInt();
			while (!gameMatch.validateBid(bid)) {
				System.out.println("Invalid value! Bid must be possible.");
				System.out.print("Bid: ");
				bid = sc.nextInt();				
			}
			gameMatch.getPlayers().get(i).setNewVaza(new Vaza(bid));
			System.out.println();			
		}
		sc.nextLine();
		System.out.print("Type 'R' to rewrite bids or ENTER to go ahead: ");
		String option = sc.nextLine().toUpperCase();
		char op = (option.trim() != "") ? option.charAt(0) : 'N';
		if(op == 'R'){
			clearScreen();
			startNewRound(gameMatch, sc);
		}
	}

	private static void printRound(GameMatch gameMatch) {		
		System.out.println();
		System.out.println("Número de rodadas: " + gameMatch.getEndGame());
		System.out.println("Round: " + gameMatch.getRound());
	}

	public static void inputVictories(List<Player> players, Scanner sc) {
		for (int i = 0; i < players.size(); i++) {
			System.out.print("Enter " + players.get(i).getName() + "'s victories: ");
			players.get(i).getVaza().setVictories(sc.nextInt());
			System.out.println();
		}
		sc.nextLine();
		System.out.print("Type 'R' to rewrite victories or ENTER to go ahead: ");
		String option = sc.nextLine().toUpperCase();
		char op = (option.trim() != "") ? option.charAt(0) : 'N';
		if(op == 'R'){
			clearScreen();
			inputVictories(players, sc);
		}
	}

	public static void printFinishVaza(GameMatch gameMatch) {

		System.out.println("=== " + gameMatch.getRound() + "º round result: ===");
		for (Player pl : gameMatch.getPlayers()) {
			pl.calculatePoints();
			System.out.println(pl.getName() + " | victories: " + pl.getVaza().getVictories() + " | bid: "
					+ pl.getVaza().getBid() + " - points: " + pl.getVaza().getPoints());
		}

	}

	public static void showRanking(GameMatch gameMatch) {
		gameMatch.orderRanking();
		gameMatch.printRanking();
	}

	public static void whoWins(GameMatch gameMatch) {
		gameMatch.setWinner();
		if (gameMatch.getWinner().size() > 1) {			
			System.out.println("** ===  "+ANSI_YELLOW_BACKGROUND + ANSI_BLACK+ " TIE " + ANSI_RESET + "  === **");
			System.out.println();
		}
		else {			
			System.out.println("** ===  "+ANSI_YELLOW_BACKGROUND + ANSI_BLACK+ " THE WINNER IS: " + ANSI_RESET + "  === **");
			System.out.println();		
		}	
		for (Player pl : gameMatch.getWinner())
			System.out.println(pl.getName() + " - points: " + pl.getPoints());
	}

}
