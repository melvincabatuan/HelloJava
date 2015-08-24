import java.util.*;

public class HashSetDemo2{

    public static void main(String[] args){

        Set<String> friends = new HashSet<>();
         
        friends.add("Mike");
        friends.add("Malen");
        friends.add("Merlin");
        friends.add("Mac");

        System.out.println(friends);     
        System.out.println("friends.size() = " + friends.size());
        System.out.println("friends.contains(\"Mike\") = " + friends.contains("Mike"));    
        System.out.println("!friends.contains(\"Melvin\") = " + !friends.contains("Melvin"));
    } 

}
