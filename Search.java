import java.util.*;

public class Search {
 public static void main(String[] args) {
 int[] a = {22, 33, 44, 55, 66, 77, 88, 99};
 print(a);
 
 System.out.println("a.toList() = " + a.toList());

 System.out.println("linearSearch(a, 44): " + linearSearch(a, 44));
 System.out.println("binarySearch(a, 44): " + binarySearch(a, 44));

 System.out.println("linearSearch(a, 50): " + linearSearch(a, 50));
 System.out.println("binarySearch(a, 50): " + binarySearch(a, 50));

 System.out.println("linearSearch(a, 77): " + linearSearch(a, 77));
 System.out.println("binarySearch(a, 77): " + binarySearch(a, 77));

 System.out.println("linearSearch(a, 100): " + linearSearch(a, 100));
 System.out.println("binarySearch(a, 100): " + binarySearch(a, 100));

 }

 public static int linearSearch(int[] a, int x) {
 // POSTCONDITIONS: returns an integer i;
 // if i >= 0, then a[i] == x; otherwise x is not in a[];
 for (int i=0; i<a.length; i++) { // step 1: Iterate thru elements
  // step 2: If found, return index
     if (a[i] == x) { // step 3
        return i;
 }
 }
 return -1; // step 4 else if NOT found, return -1
}


   public static int binarySearch(int[] a, int x) {
   // POSTCONDITIONS: returns i;
 // if i >= 0, then a[i] == x; otherwise i == -1;
 int lo = 0;
 int hi = a.length;

 while (lo < hi) { // step 1
 // INVARIANT: if a[j]==x then lo <= j < hi; // step 3
   int i = (lo + hi)/2; // step 4
   if (a[i] == x) {
       return i; // step 5
   } else if (a[i] < x) {
       lo = i+1; // step 6
   } else {
       hi = i; // step 7
 }
 }
 return -1; // step 2
 }
 


 public static void print(int[] a) {
		System.out.printf("{%d", a[0]);
		for (int i = 1; i < a.length; i++) {
			System.out.printf(", %d", a[i]);
		}
		 System.out.println("}");
	}
 
	public static void print(Object[] a) {
	System.out.printf("{%s", a[0]);
	for (int i = 1; i < a.length; i++) {
		System.out.printf(", %s", a[i]);
	}
	System.out.println("}");
	}
}
