package ai.play.devtech.misc.primitives;

public class RLong {
	public long val;

	public RLong(long val) {
		this.val = val;
	}

	public RLong() {
	}

	public long postInc() {
		return val++;
	}

	public long preInc() {
		return ++val;
	}

	public long postDec() {
		return val--;
	}

	public long preDec() {
		return --val;
	}

	public long postInc(long inc) {
		long v = val;
		val += inc;
		return v;
	}

	public long preInc(long inc) {
		val += inc;
		return val;
	}

	public long postDec(long dec) {
		long v = val;
		val -= dec;
		return v;
	}

	public long preDec(long dec) {
		val -= dec;
		return val;
	}
	
	public long postMult(long factor) {
		long v = val;
		val *= factor;
		return v;
	}

	public long preMult(long factor) {
		val *= factor;
		return val;
	}

	public long postDiv(long divisor) {
		long v = val;
		val /= divisor;
		return v;
	}

	public long preDiv(long divisor) {
		val /= divisor;
		return val;
	}
	
	public long plus(long inc) {
		return inc+val;
	}
	
	public long minus(long dec) {
		return val-dec;
	}
	
	public long reverseMinus(long dec) {
		return dec-val;
	}
	
	public long times(long factor) {
		return factor*val;
	}
	
	public long divided(long divisor) {
		return val/divisor;
	}
	
	public long invDiv(long divisor) {
		return divisor/val;
	}
	

}
