package ai.play.devtech.util.math;

public class CastMath {

	public static long twoIntsToLong(final int x, final int y) {
		return (((long)x) << 32) | (y & 0xffffffffL);
	}
	
	private CastMath() {throw new UnsupportedOperationException("Static class...");}

}
