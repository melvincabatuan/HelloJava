/**
* Compute 1 + 2 + ... + 100
* @author mkc
*/
class SumDemo{

  public static void main(String[] arguments){
    int sum = 0;
    for(int i = 1; i <= 100; i++)
        sum += i;
    System.out.println("The sum 1 + 2 + ... + 100 is equal to " + sum +".");
  }
}
