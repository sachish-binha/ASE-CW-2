package stage2;

import java.util.concurrent.ThreadLocalRandom;

public class BagDim {
	private static BagDim instance;
	private BagDim() { }
	public int makeRan1() { // returns random r1 in the range
        int i = ThreadLocalRandom.current().nextInt(100, 175);
        return i;
	}
	public static BagDim getInstance() {
	if (instance == null)
	synchronized(BagDim.class) {
	if (instance == null)
	instance = new BagDim();
	}
	return instance;
	}
}
