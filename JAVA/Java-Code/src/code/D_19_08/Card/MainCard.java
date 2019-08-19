package code.D_19_08.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainCard {

	static Scanner sc = new Scanner(System.in);
	static List<Card> Deck= new ArrayList<Card>(); 

	static{
		for(Suit s:Suit.values()) {
			for(Rank r:Rank.values()) {
				Deck.add(new Card(s,r));
			}
		}
	
	}
	
	public static void main(String[] args) {
		String ch="N";
//		System.out.println(Deck);
do {
	System.out.println("Enter No of hands:");
	int hands = sc.nextInt();
	System.out.println("Enter no of Cards");
	int cards = sc.nextInt();
	Collections.shuffle(Deck);
	Map<Integer,ArrayList<Card>> mp = new HashMap<Integer,ArrayList<Card>>();
//	List<Card> outCards = getCards(hands,cards);
//	System.out.println();
//	System.out.println("Cards are");
//	for(int i=0;i<hands;i++) {
//		System.out.println("Cards for Player :"+(i+1));
//		for(int j=0;j<cards;j++) {
//			System.out.println(outCards.get(i*cards+j));
//		}
//		System.out.println();
//	}
//	
	System.out.println();
	System.out.println("Cards are");
	mp = getCardsMap(hands, cards);
//	System.out.println(mp);
	for(int i=0;i<hands;i++) {
		System.out.println("Cards for Player :"+(i+1));
		for(Card c:mp.get(i)) {
			System.out.println(c);
		}
		System.out.println();
	}
	System.out.println("Do you want to continue(y/Y):");
 ch = sc.next().toString();
}while(ch =="y"||ch=="Y");
	
	}

	private static List<Card> getCards(int hands, int cards) {
		Collections.shuffle(Deck);
		List<Card> temp = new ArrayList<Card>();
		for(int i=0;i<hands;i++) {
			for(int j=0;j<cards;j++) {
				temp.add(Deck.get(i*cards+j));
//				Deck.remove(i*cards+j);
			}
		}
		return temp;
	}
	
	private static HashMap<Integer,ArrayList<Card>> getCardsMap(int hands, int cards) {
//		Collections.shuffle(Deck);
		 Map<Integer,ArrayList<Card>>  temp = new HashMap<Integer,ArrayList<Card>>();
		
		 for(int i=0;i<hands;i++) {
			 List<Card> temp1 = new ArrayList<Card>();
			 for(int j=0;j<cards;j++) {	
				temp1.add(Deck.get(i*cards+j));
				Deck.remove(i*cards+j);
			}
			temp.put(i, (ArrayList<Card>) temp1);
//			temp1.clear();
		}
		return (HashMap<Integer, ArrayList<Card>>) temp;
	}
	
}
