public class Exponent {
    public static void main(String[] args) {
    // Uppercase and lowercase ‘e’ are the same:
    float expFloat1 = 1.39e-43f;
    float expFloat2 = 1.39E-43f;
     System.out.println("expFloat1 = " + expFloat1);
     System.out.println("expFloat2 = " + expFloat2);

     double expDouble1 = 47e47d; // ‘d’ is optional
     double expDouble2 = 47e47; // Automatically double
     System.out.println("expDouble1 = " + expDouble1);
     System.out.println("expDouble2 = " + expDouble2);
  }
}
