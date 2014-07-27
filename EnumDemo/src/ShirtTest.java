
public class ShirtTest {
   public static void main(String [] args){
	   Shirt myUniqlo = new Shirt();
	   Shirt myMarkSpencer = new Shirt();
	   myUniqlo.size = Shirt.ShirtSize.MEDUIM;
	   myMarkSpencer.size = Shirt.ShirtSize.SMALL;
	   
	   System.out.println("myUniqlo:");
	   System.out.println(myUniqlo.size);
	   
	   System.out.println("myMarcSpencer:");
	   System.out.println(myMarkSpencer.size);	                
   }
}
