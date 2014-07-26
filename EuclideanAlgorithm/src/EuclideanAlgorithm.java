public class EuclideanAlgorithm {

	// recursive implementation
	public static int gcdR(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcdR(b, a % b);
	}

	// non-recursive implementation
	public static int gcdNR(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		int p = Integer.parseInt(args[0]);
		int q = Integer.parseInt(args[1]);
		int d = gcdR(p, q);
		int d2 = gcdNR(p, q);
		System.out.println("gcd(" + p + ", " + q + ") = " + d);
		System.out.println("gcd(" + p + ", " + q + ") = " + d2);
	}
}
