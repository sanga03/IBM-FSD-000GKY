package code.D_20_08.ThreadSync;

public class StackData {

	private int index =-1;
	private final int MAX = 26;
	private char[] items= new char[MAX];
	
	public synchronized void push(char ch) throws InterruptedException {
		if(index==MAX) {
			System.out.println("Over flow!!");
			wait();
		}
		
		System.out.println("Producer produced:"+ch);
		Thread.sleep(400);
		items[++index]=ch;
		notify();
	}
	
	public synchronized char pop() throws InterruptedException {
		if(index <1) {
			System.out.println("Under flow");
			wait();
		}
		notify();
		System.out.println("Consumer consumed"+items[index]);
		Thread.sleep(400);
		return items[--index];
	}

}

