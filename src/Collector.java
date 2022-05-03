package src;
import java.util.*;

public class Collector {
	
	protected static final int TOTALTRIALS = 10000000;
	protected static final int MAXFREQ = 600;
	protected static int n = 2;
	protected static int trials;
	protected static int sumFreq;
	
	// HashMap where the key is the coupon and the value is the number of occurrences
	private HashMap<Integer, Integer> seenCoupons = new HashMap<>();
	
	
	
	
	public Collector(int trials) {
		this.trials = trials;
		
	}
	
	protected int drawCoupon() { // returns random integer 0-15

		Random rand = new Random();
		int upperbound = 16;
		int int_random = rand.nextInt(upperbound);
		
		return int_random;
	}
	
	protected boolean addcoupon(int coupon) {
		
		// update value if coupon seen
		if(seenCoupons.containsKey(coupon)) { 
			seenCoupons.put(coupon, seenCoupons.get(coupon) + 1); 
		}
		// add coupon to hash map if not seen yet
		else { 
			seenCoupons.put(coupon, 1);
		}
		
		// true iff every coupon has been drawn
		if(seenCoupons.size() == 16)
			return true;
		else
			return false;
	}
}
