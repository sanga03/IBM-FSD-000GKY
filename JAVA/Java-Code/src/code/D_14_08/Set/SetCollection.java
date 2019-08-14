package code.D_14_08.Set;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SetCollection {

	static Scanner sc = new Scanner(System.in);
	private Set<String> setCollection;
	private String str[];

	public SetCollection() {
		System.out.println("enter no of elements");
		int ln = sc.nextInt();
		for (int i = 0; i < ln; i++) {
			if (!setCollection.add(sc.next().toString().toLowerCase())) {
				System.out.println("Sorry cannot be added");
			}
		}
	}

	public void displaySet() {
		Iterator<String> it = setCollection.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
