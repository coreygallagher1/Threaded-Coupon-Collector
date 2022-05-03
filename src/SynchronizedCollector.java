package src;

public class SynchronizedCollector extends Collector implements Runnable {
	static Thread t[];

	public SynchronizedCollector(int trials) {
		super(trials);
		//...
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < n; i++) {
			t[i] = new Thread(new SynchronizedCollector(1000));
			t[i].start();
		}

		long duration = System.currentTimeMillis() - startTime;
		System.out.println("Duration: " + duration);
	}

	@Override
	public void run() {
		//...
		System.out.println("Tax me");
	}

}
