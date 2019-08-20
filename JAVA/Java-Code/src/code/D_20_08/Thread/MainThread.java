package code.D_20_08.Thread;

public class MainThread implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainThread mt =new  MainThread();
		Thread t1=new Thread(mt);
		Thread t2=new Thread(mt);
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.printf("\n-->>%d",i);
			if(i%7==0)
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

}
