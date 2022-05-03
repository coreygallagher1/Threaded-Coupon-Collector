package src;

public class SynchronizedCollector extends Collector implements Runnable {
	static long startTime;
	public SynchronizedCollector(int trials) {
		super(trials);
		//...
	}

	public static void main(String[] args) {
		startTime = System.currentTimeMillis();
		
		Thread testThread = new Thread(new SynchronizedCollector(1000));
		testThread.start();

		long duration = System.currentTimeMillis() - startTime;
		System.out.println("Duration: " + duration);
	}

	@Override
	public void run() {
		//...
		System.out.println("Tax me");
	}

}
