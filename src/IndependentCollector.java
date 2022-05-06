package src;

import java.util.ArrayList;

public class IndependentCollector extends Collector implements Runnable {
	static Thread[] threads;
	Object lock = new Object();
	static ArrayList<int[]> freqCollection= new ArrayList<int[]>();

	public IndependentCollector(int trials) {
		super(trials);
	}

	public static void main(String[] args) {
		int n = Integer.valueOf(args[0]);

		int t = TOTALTRIALS / n;					// number of trials
		threads = new Thread[n];
		System.out.println("Starting IndependentCollector");
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < n; i++) {
			threads[i] = new Thread(new IndependentCollector(t));
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

		// Adding all of the arrays in freqCollection to freq
		for(int i = 0; i < freqCollection.size(); i++) {
			addToFreq(freqCollection.get(i));
		}
		
		long duration = System.currentTimeMillis() - startTime;
		printHist(freq);
		System.out.println("Sum of frequencies: " + sumFreq(freq));
		System.out.println("Number of threads: " + n);
		System.out.println("Execution time: " + duration + "ms");
	}

	public static void addToFreq(int f[]) {
		for(int i = 0; i < f.length; i++) {
			freq[i] += f[i];
		}
	}

	@Override
	public void run() {
		
		int f = 0;
		int threadFreq[] = new int[MAXFREQ];


		for(int i = 0; i < trials; i++) {
			seenCoupons.clear();

			while(!addcoupon(drawCoupon())) {
				f++;
			}

			threadFreq[f]++;
			seenCoupons.clear();
			f = 0;
		}
		freqCollection.add(threadFreq);
	}

}
