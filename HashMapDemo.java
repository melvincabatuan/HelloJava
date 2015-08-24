import java.util.*;

public class HashMapDemo {

 	public static void main(String[] args) {
 	  Map<String, Integer> myMap = new HashMap<>();

          myMap.put("Melvin", 100);
          myMap.put("Nano", 100);
          myMap.put("Pico", 100);
          System.out.println(myMap); 
 
          myMap.put("Nano", 20);
          System.out.println(myMap);

          myMap.put("NanO", 300);
          System.out.println(myMap);

          myMap.remove("Nano");
          System.out.println(myMap);

          myMap.remove("NANO");
          System.out.println(myMap);

          System.out.println(myMap.get("Pico"));
          System.out.println(myMap.get("Mico"));
	}
}
