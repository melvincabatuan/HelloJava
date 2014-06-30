public class NullDemo
{
   public static void main(String[] args)
   {
      Boolean b = null;
      System.out.println(b ? true : false); //Exception in thread "main" java.lang.NullPointerException
   }
}
