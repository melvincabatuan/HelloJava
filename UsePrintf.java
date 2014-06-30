class UsePrintf{
   public static void main(String []args) {
       int c = 'a';
       float f = 10;
       long ell = 100L;
       System.out.printf("char val is %c, float val is %f, long int val is %ld \n", c, f, ell);
       //Exception in thread "main" java.util.UnknownFormatConversionException: Conversion = 'l'
   }
}
