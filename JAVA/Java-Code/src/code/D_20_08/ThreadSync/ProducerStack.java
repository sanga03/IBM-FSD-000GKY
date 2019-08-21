package code.D_20_08.ThreadSync;

public class ProducerStack implements Runnable {

	private  StackData stackData ;
	public ProducerStack(StackData st) {
		stackData =st;
		
	}
	@Override
	public void run() {
		for(int i=0;i<26;i++) {
			try {
				
				stackData.push((char)((int)'A'+i));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
