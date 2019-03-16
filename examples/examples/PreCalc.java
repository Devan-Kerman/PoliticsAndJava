package examples;

import java.util.LinkedList;
import java.util.List;

public class PreCalc {
	public static void main(String[] args) {
		System.out.println(new TComplex(4, 90).nthRoot(2));
	}

}

class TComplex {
	double theta;
	double r;

	TComplex(double r, double theta) {
		this.theta = theta;
		this.r = r;
	}

	public List<TComplex> nthRoot(int rooth) {
		List<TComplex> roots = new LinkedList<>();
		for (int x = 0; x < rooth; x++)
			roots.add(new TComplex(Math.pow(r, 1.0d / rooth), (theta + 360 * x)/rooth));
		return roots;
	}
	
	@Override
	public String toString() {
		return String.format("%.2fcis(%.2f)", r, theta);
	}
}
