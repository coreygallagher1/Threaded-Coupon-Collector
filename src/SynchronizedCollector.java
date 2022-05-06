package src;

public class SynchronizedCollector extends Collector implements Runnable {
	static Thread[] threads;
	Object lock = new Object();

	public SynchronizedCollector(int trials) {
		super(trials);
		//...
	}

	public static void main(String[] args) {
		
		int n = Integer.valueOf(args[0]);
		int t = TOTALTRIALS / n;				
		threads = new Thread[n];
		System.out.println("Starting Synchronized Collector");
		long startTime = System.currentTimeMillis();

		for(int i = 0; i < n; i++) {
			threads[i] = new Thread(new SynchronizedCollector(t));
			threads[i].start();
		}

		for(int i = 0; i < n; i++){
			try{
				threads[i].join();
			}
			catch(InterruptedException e){
				System.out.println("Interrupted Exception Error");
			}
		}

		long duration = System.currentTimeMillis() - startTime;
		printHist(freq);
		System.out.println("Sum of frequencies: " + sumFreq(freq));
		System.out.println("Number of threads: " + n);
		System.out.println("Execution time: " + duration + "ms");
	}

	@Override
	public void run() {
		int f = 0;

		for(int i = 0; i < trials; i++) {
			seenCoupons.clear();
			while(!addcoupon(drawCoupon())) {
				f++;
			}

			synchronized (lock) { // only one thread at a time will be able to run this
				//update shared data
				freq[f]++;
			}

			seenCoupons.clear();
			f = 0;
		}
	}

}
