package code.Assesments.CharChart;

import java.util.TreeMap;

public class LetterSequence {
	private String Sentence;
	private TreeMap<Character,Integer> treeMap;
	public LetterSequence(String sentence) {
		super();
		treeMap=new TreeMap<Character,Integer>();
		Sentence = sentence;
	}

	public void computeFrequency(){
		
		char[] arr= Sentence.toCharArray();
		for(Character a:arr) {
			if(a!=' ' && a!='\n')
			if(treeMap.containsKey(a)) {
			treeMap.put(a, treeMap.get(a)+1);
			}else
				treeMap.put(a,1);
		}
//	return treeMap;
	}
	
	
	public void displayLetterFrequency() {
	
		System.out.println("Chart");
		for(Character c:treeMap.keySet()) {
			System.out.println(c+"--"+treeMap.get(c));
		}
}
}
