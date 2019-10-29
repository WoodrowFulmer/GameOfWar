package bin;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Deck {
	private static final int NUMBER_OF_SUITS = 4;
	private static final int NUMBER_OF_VALUES = 13;
	
	private ArrayList<Card> cards;
	private Random rand;
	private boolean shuffled;
	
	public Deck() {
		rand = new Random(System.currentTimeMillis());
		cards = new ArrayList<>();
		shuffled = true;
	}

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
	
	public Card draw() {
		shuffled = false;
		int index = rand.nextInt(cards.size());
		return cards.remove(index);
	}
	
	public void deal(List<Collection> players) {
		this.shuffle();
		for(int i = 0; i < NUMBER_OF_VALUES * NUMBER_OF_SUITS; i++) {
			players.get(i % players.size()).add(this.draw());
		}
	}
}