package code.D_19_08.Card;

import java.util.ArrayList;
import java.util.List;

public class MainCard {
	
	static List<Card> Deck= new ArrayList<Card>(); 

	static{
		for(Suit s:Suit.values()) {
			for(Rank r:Rank.values()) {
				Deck.add(new Card(s,r));
			}
		}
	
	}
	
	public static void main(String[] args) {
	
		System.out.println(Deck);
	}
}
