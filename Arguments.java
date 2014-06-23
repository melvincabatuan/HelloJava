/**
 Illustrate the String arguments
 @author mkc

$ javac Arguments.java 
$ java Arguments Old Mc Donald Had A Farm
arguments.length = 6
arguments[0] = Old
arguments[1] = Mc
arguments[2] = Donald
arguments[3] = Had
arguments[4] = A
arguments[5] = Farm

*/

class Arguments{
  public static void main(String[] arguments){

       System.out.println("arguments.length = " + arguments.length);
       for(int i = 0; i < arguments.length; i++)
            System.out.println("arguments[" + i +"] = " + arguments[i]);
  }//ENDMAIN
}//ENDCLASS
