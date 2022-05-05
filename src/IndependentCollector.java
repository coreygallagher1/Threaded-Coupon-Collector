package src;

public class IndependentCollector extends Collector implements Runnable {
	static Thread[] threads;
	Object lock = new Object();

	public IndependentCollector(int trials) {
		super(trials);
	}

	public static void main(String[] args) {
		int n = 4;
		int t = TOTALTRIALS / n;					// number of trials
		threads = new Thread[n];

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
		
		
	}

}
