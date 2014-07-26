
public class Main {
   public static void main(String [] args){
        Person baby = new Person("Joanna");	  
        System.out.println("baby.getName() = " + baby.getName());
        
        Professor x = new Professor("Xavier", Professor.Rank.ASSOC);
        System.out.println(x);
        System.out.println("x.getName() = " + x.getName());
   }
}
