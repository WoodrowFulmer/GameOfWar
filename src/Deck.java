package bin;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

/**
 * A support object for the Card class. Handles a standard 52-card deck and the randomization of drawing a card.
 */
public class Deck {
	private static final int NUMBER_OF_SUITS = 4;
	private static final int NUMBER_OF_VALUES = 13;
	
	private ArrayList<Card> cards;
	private Random rand;
	private boolean shuffled;
	
	/**
	 * Initializer
	 */
	public Deck() {
		rand = new Random(System.currentTimeMillis());
		cards = new ArrayList<>();
		shuffled = false;
	}

	/**
	 * Populates this deck with all 52 cards.
	 */
	public void shuffle() {
		if(false == shuffled){
			cards.clear();
			for(int suit = 0; suit < NUMBER_OF_SUITS; suit++) {
				for(int value = 0; value < NUMBER_OF_VALUES; value++) {
					cards.add(new Card(value, suit));
				}
			}
		}
	}
	
	/**
	 * Draws a card from this deck.
	 *
	 * @return 	The card drawn randomly from the deck
	 */
	public Card draw() {
		if(cards.size() > 0) {
			shuffled = false;
			int index = rand.nextInt(cards.size());
			return cards.remove(index);
		}
		System.err.println("Cannot draw a card. Deck empty.");
		return null;
	}
	
	/**
	 * Shuffles this deck and deals out all the cards to the players.
	 *
	 * @param players	A list of the players' hands to deal cards to
	 */
	public void deal(List<Collection<Card>> players) {
		this.shuffle();
		for(int i = 0; i < NUMBER_OF_VALUES * NUMBER_OF_SUITS; i++) {
			players.get(i % players.size()).add(this.draw());
		}
	}
}