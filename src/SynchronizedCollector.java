package src;

public class SynchronizedCollector extends Collector implements Runnable {
	static Thread[] threads;
	Object lock = new Object();

	public SynchronizedCollector(int trials) {
		super(trials);
		//...
	}

	public static void main(String[] args) {
		//-> both main methods should be very similar
		//create thread objects
		//start all threads
		//join all threads
		//printing -> the independent version will be different

		//int n = Integer.parseInt(args[0]);		// n taken from args (user input)
		int n = 4;
		int t = TOTALTRIALS / n;					// number of trials
		threads = new Thread[n];

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


			while(!drawn) {
				f++;
				coupon = drawCoupon();
				drawn = addcoupon(coupon);
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
