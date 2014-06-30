 public class NestedDemo {
 	private int m = 22;

 	public NestedDemo() {
 		Nested nested = new Nested();
 		System.out.println("Outside of Nested; nested.n = " + nested.n);
 		nested.f();
 	}

 	public static void main(String[] args) {
 		new NestedDemo();
 	}

 	private class Nested {
 		private int n = 44;

 		private void f() {
 		System.out.println("Inside of Nested; m = " + m);
 		}
 	}
}
