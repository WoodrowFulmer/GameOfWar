package bin;

import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import java.io.IOException;

public class GameOfWar {
	private static LinkedList<Card> prizepool;
	private static List<Collection<Card>> playerList;
	private static Deck deck;
	
	private static boolean STANDARD_MODE;
	private static boolean FAST_MODE;
	private static boolean INSTANT_MODE;
	
	public static void main(String[] args) throws IOException {
		System.out.println("\nWelcome to the Game of War!");
		
		//Set mode
		if(args.length < 1) { //STANDARD mode pauses the console after every turn
			STANDARD_MODE = true;
			FAST_MODE = false;
			INSTANT_MODE = false;
			System.out.println("Game mode set to: STANDARD\n");
		}
		else if(args[0].equals("-f")) { //FAST mode pauses the console every 10 turns
			STANDARD_MODE = false;
			FAST_MODE = true;
			INSTANT_MODE = false;
			System.out.println("Game mode set to: FAST\n");
		}
		else if(args[0].equals("-i")) { //INSTANT mode never pauses the console
			STANDARD_MODE = false;
			FAST_MODE = false;
			INSTANT_MODE = true;
			System.out.println("Game mode set to: INSTANT\n");
		}
		
		//Initilize Objects
		LinkedList<Card> player1 = new LinkedList<>();
		LinkedList<Card> player2 = new LinkedList<>();
		deck = new Deck();
		prizepool = new LinkedList<>();
		
		playerList = new LinkedList<>();
		playerList.add(player1);
		playerList.add(player2);
		
		//Deal cards
		deck.shuffle();
		deck.deal(playerList);
		
		int turnCounter = 1;
		//GAME LOOP
		while(player1.size() > 0 && player2.size() > 0) {
			System.out.println("Round " + turnCounter);
			//Get top card from each player
			Card p1Card = player1.remove();
			Card p2Card = player2.remove();
			System.out.println("Player 1 plays a " + p1Card);
			System.out.println("Player 2 plays a " + p2Card);
			prizepool.add(p1Card);
			prizepool.add(p2Card);
			
			//Compare and give cards to winner
			if(p1Card.compareTo(p2Card) > 0) { //Player 1 has higher card
				int winnings = awardCards(player1);
				System.out.println("Player 1 wins " + winnings + " cards!\n");
			}
			else if(p1Card.compareTo(p2Card) < 0) { //Player 2 has higher card
				int winnings = awardCards(player2);
				System.out.println("Player 2 wins " + winnings + " cards!\n");
			}
			else { //If tied, war
				System.out.println("\n\nWar!!!");
				if(player1.size() == 0 || player2.size() == 0) {
					break;
				}
				prizepool.add(player1.remove());
				prizepool.add(player2.remove());
				System.out.println("Each player adds a card to the pile. \nAnd...\n");
			}
			
			//Report totals after 10 turns
			if(turnCounter++ % 10 == 0) {
				System.out.println("Player 1 has " + player1.size() + " cards.");
				System.out.println("Player 2 has " + player2.size() + " cards.");
				if(FAST_MODE) {
					System.in.read();
				}
			}
			if(STANDARD_MODE) {
				System.in.read();
			}
		}
		
		if(player1.size() == 0) {
			System.out.println("\nPlayer 1 has no remaining cards.\nPlayer 2 wins!!!!!!\n");
		}
		else if(player2.size() == 0) {
			System.out.println("\nPlayer 2 has no remaining cards.\nPlayer 1 wins!!!!!!\n");
		}
		else {
			System.out.println("\nERROR: Game loop exitted while players have cards remaining\n");
		}
	}
	
	/**
	 * Give cards from the static prizepool to the winning player (given)
	 *
	 * @param player 	A list of cards in a player's hand
	 * @return			A count of how many cards were added to the player's hand
	 */
	private static int awardCards(LinkedList<Card> player) {
		int counter = 0;
		while(prizepool.size() > 0) {
			counter++;
			player.add(prizepool.remove());
		}
		return counter;
	}
}