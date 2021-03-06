import java.util.*;

public class FacePamphletProfileTest{

     public static void main(String[] args){

           FacePamphletProfile fpp= new FacePamphletProfile("Melvin");
         
           System.out.println(fpp);

           System.out.println(fpp.getName());

           System.out.println("fpp.getStatus() = " + fpp.getStatus());
           fpp.setStatus("coding...");

           System.out.println("fpp.getStatus() = " + fpp.getStatus());

           fpp.addFriend("Jay");
           System.out.println(fpp);

           fpp.addFriend("Malen");
           fpp.addFriend("Lydia");
           fpp.addFriend("Ilia");
           System.out.println(fpp);
           
           fpp.addFriend("Lydia");
           System.out.println(fpp); // Nothing happens

           fpp.addFriend("LydiA");
           System.out.println(fpp); // New name added

           fpp.removeFriend("Malen");
           System.out.println(fpp);
     }

}
