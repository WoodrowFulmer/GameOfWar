package bin;

public class Card {
	private int value;
	private int suit;
	
	public Card(int v, int s) {
		this.value = v;
		this.suit = s;
	}
	
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
		switch(suit) {
			case 0:
				sb.append("Spades");
				break;
			case 1:
				sb.append("Hearts");
				break;
			case 2:
				sb.append("Clubs");
				break;
			case 3:
				sb.append("Diamonds");
				break;
			default:
				return "Error with card suit: " + suit;
		}
		return sb.toString();
	}
	
	public int getValue() {
		return value;
	}
	
	public int getSuit() {
		return suit;
	}
}