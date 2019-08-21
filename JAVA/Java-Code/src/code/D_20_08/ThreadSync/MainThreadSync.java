package code.D_20_08.ThreadSync;

public class MainThreadSync {
	
	public static void main(String[] args) {
	final StackData stackData = new StackData();
	ProducerStack ps = new ProducerStack(stackData);
	ConsumerStack cs = new ConsumerStack(stackData);
	Thread Producer = new Thread(ps,"Producer");
	Thread Consumer = new Thread(cs,"Consumer");
	Producer.start();
	Consumer.start();
	
	}

}
