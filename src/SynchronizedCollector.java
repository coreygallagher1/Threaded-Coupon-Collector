package src;

public class SynchronizedCollector extends Collector implements Runnable {
	static Thread t[]= new Thread[n];
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


		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < n; i++) {
			t[i] = new Thread(new SynchronizedCollector(1000));
			t[i].start();
		}

		for(int i = 0; i < n; i++){
			try{
				t[i].join();
			}
			catch(InterruptedException e){
				System.out.println("Interrupted Exception Error");
			}
		}

		long duration = System.currentTimeMillis() - startTime;
		//System.out.println("Sum of frequencies: " + sumFreq);
		System.out.println("Number of threads: " + n);
		System.out.println("Execution time: " + duration);
	}

	@Override
	public void run() {
		int f = 0;

		while(!addcoupon(drawCoupon())) {
			f++;
		}
		synchronized (lock) { // only one thread at a time will be able to run this 

			//update shared data
			freq[f]++;
		}
	}

}
