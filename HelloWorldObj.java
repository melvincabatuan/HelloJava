public class HelloWorldObj extends Object
{  
    private String greeting = "Hello, World!";

    public void greet(){  
       System.out.println( greeting );  
    }  

   /// main method
   public static void main ( String[] args)  
   {
   HelloWorldObj helloworld = new HelloWorldObj();  
   helloworld.greet();
   }
}
