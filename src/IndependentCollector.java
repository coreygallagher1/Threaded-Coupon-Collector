package src;

public class IndependentCollector extends Collector implements Runnable {

	public IndependentCollector(int trials) {
		super(trials);
	}

	public static void main(String[] args) {
		

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
