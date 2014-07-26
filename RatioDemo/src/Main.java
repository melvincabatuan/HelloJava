
public class Main {
      public static void main(String [] args){
    	  Ratio fraction = new Ratio(1,2);
    	  Ratio myFraction = new Ratio(1,2);
    	  
    	  System.out.println("fraction = "+ fraction);
    	 // System.out.println("fraction.num = " + fraction.num );
    	  System.out.println("fraction.getNum() = " + fraction.getNum() );
    	  
    	 // System.out.println("fraction.den = " + fraction.den );
    	  System.out.println("fraction.getDen() = " + fraction.getDen() );
    	  
    	  System.out.println("fraction.value() = " + fraction.value() );
    	  
    	  System.out.println("fraction.equals(myFraction) = " + fraction.equals(myFraction) );
      }
}
