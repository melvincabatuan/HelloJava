import java.util.*;

public class PrivateAccessDemo
{
  private int x;

  PrivateAccessDemo(int x)
  {
  this.x = x;
  }

  boolean equalTo(PrivateAccessDemo pa)
  {
  return pa.x == x;
  }

  public static void main(String[] args)
  {
  PrivateAccessDemo pa1 = new PrivateAccessDemo(10);
  PrivateAccessDemo pa2 = new PrivateAccessDemo(20);
  PrivateAccessDemo pa3 = new PrivateAccessDemo(10);

  System.out.println("pa1 equal to pa2: " + pa1.equalTo(pa2));
  System.out.println("pa2 equal to pa3: " + pa2.equalTo(pa3));
  System.out.println("pa1 equal to pa3: " + pa1.equalTo(pa3));
  System.out.println(pa2.x);
  }
}
