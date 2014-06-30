/**
* A Simple Java Program for inheritance demo
*  
*/
class Person{

   public void cheer(){
      System.out.println("Mabuhay!");
   }
}

class Lasallista extends Person{

   public void cheer(){
      System.out.println("Animo! La Salle!");
   }
}

public class TestLasallista{

   public static void main(String args[]){
      Person x = new Person(); // Person reference and object
      Person y = new Lasallista(); // Person reference but Lasallista object

      x.cheer();// runs the method in Person class

      y.cheer();//Runs the method in Lasallista class
   }
}
