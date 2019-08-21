package code.D_20_08.ThreadSync;

public class ConsumerStack implements Runnable {

	private StackData stackData;

	public ConsumerStack(StackData st) {
		// TODO Auto-generated constructor stub
		stackData = st;
	}

	@Override

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 26; i++) {
			try {
				System.out.println(stackData.pop());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
