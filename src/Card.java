package bin;

/**
 * Class to describe the function and structure of a standard playing card.
 */
public class Card implements Comparable<Card>{
	/*
		2 = value of 0
		10 = value of 8
		J = value of 9
		Q = value of 10
		K = value of 11
		A = value of 12
		
		Spades = suit of 0
		Hearts = suit of 1
		Clubs = suit of 2
		Diamonds = suit of 3
	*/
	private int value;
	private int suit;
	
	/**
	 * Constructor for Card class
	 */
	public Card(int v, int s) {
		this.value = v;
		this.suit = s;
	}
	
	/**
	 * Converts this card into a String for output purposes
	 *
	 * @return 		The string representation of this card
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		switch(value) {
			case 0:
				sb.append("Two");
				break;
			case 1:
				sb.append("Three");
				break;
			case 2:
				sb.append("Four");
				break;
			case 3:
				sb.append("Five");
				break;
			case 4:
				sb.append("Six");
				break;
			case 5:
				sb.append("Seven");
				break;
			case 6:
				sb.append("Eight");
				break;
			case 7:
				sb.append("Nine");
				break;
			case 8:
				sb.append("Ten");
				break;
			case 9:
				sb.append("Jack");
				break;
			case 10:
				sb.append("Queen");
				break;
			case 11:
				sb.append("King");
				break;
			case 12:
				sb.append("Ace");
				break;
			default:
				return "Error with card value: " + value;
		}
		sb.append(" of ");
		sb.append(this.getSuitString());
		return sb.toString();
	}
	
	/**
	 * Returns the integer value of this card. The value is not the number displayed
	 * on that card, but rather a sacle to evaluate the power of the card in standard 
	 * gameplay. As such, a card that reads Two of Hearts would actually have a value of 3
	 * and would of lesser relative power than a King of Spades which has a value of 11.
	 *
	 * @return 		The integer value of this card (see above comment for details)
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Returns the integer representation of the suit of this card. A spade is
	 * represented with a value of 1, a heart with a 2, a club with 3, and a 
	 * diamond with 4.
	 *
	 * @return		The integer value of the suit
	 */
	public int getSuit() {
		return suit;
	}
	
	/**
	 * Return the string value of this card's suit.
	 *
	 * @return		The string of the suit
	 */
	public String getSuitString() {
		switch(this.suit) {
			case 0:
				return "Spades";
			case 1:
				return "Hearts";
			case 2:
				return "Clubs";
			case 3:
				return "Diamonds";
			default:
				return "Error with card suit: " + suit;
		}
	}
	
	/**
	 * Compares to cards to determine which is greater in value.
	 *
	 * @param c		The card to compare against
	 * @return 		1 if this card is greater, or -1 if this card is lesser in value
	 */
	@Override
	public int compareTo(Card c) {
		if(this.value == c.getValue()) {
			return 0;
		}
		else if(this.value > c.getValue()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	/**
	 * Evaluates the equality of this Card and another object.  
	 * Returns true if object is a card and both share the same suit and value.
	 *
	 * @param o		The object to evalutate
	 * @return 		boolean containing the equality
	 */
	public boolean equals(Object o) {
		if(o instanceof Card) {
			Card c = (Card)o;
			if(c.getValue() == this.value && c.getSuit() == this.suit) {
				return true;
			}
		}
		return false;
	}
}