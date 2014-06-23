/**
* Prints the Divisibility Matrix Relation
* @author mkc
Usage:
 $ javac DivisorPattern.java
 $ java DivisorPattern <Size>
Ex.
$ java DivisorPattern 6

  1 2 3 4 5 6 
1 1 1 1 1 1 1 
2 1 1 0 1 0 1 
3 1 0 1 0 0 1 
4 1 1 0 1 0 0 
5 1 0 0 0 1 0 
6 1 1 1 0 0 1

*/

public class DivisorPattern {

    public static void main(String[] args) { 
        int N = Integer.parseInt(args[0]);

        /** Header */
        System.out.print("  ");
        for (int i = 1; i <= N; i++)
             System.out.print(i + " ");
        System.out.println();

        for (int i = 1; i <= N; i++) {
            System.out.print(i +" ");
            for (int j = 1; j <= N; j++) {            
                if (i % j == 0 || j % i == 0) {
                    System.out.print("1 "); 
                }
                else {
                    System.out.print("0 "); 
                }
            }
            System.out.println();
        }
    }
}

