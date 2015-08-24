public class NameSurferEntryTest{

  public static void main(String[] args){
      NameSurferEntry nse = new NameSurferEntry("Sam 58 69 99 131 168 236 278 380 467 408 466 997");

      /// Test getName() method
      System.out.println("nse.getName() = " + nse.getName());

      /// Test getRank() method
      for (int i = 0; i < 12; i++)
           System.out.println("nse.getRank(" + (i+1) + ") = " + nse.getRank(i+1));


      /// Test toString() method
      System.out.println(nse);
  }

}
