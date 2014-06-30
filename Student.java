public class Student implements Cloneable
{
   String name;
   int id;

   Student(String name, int id)
   {
   this.name = name;
   this.id = id;
   }

   public static void main(String[] args) throws CloneNotSupportedException
   {
     Student eng1 = new Student("Melvin Cabatuan", 11191031);
     Student eng2 = (Student) eng1.clone();
     System.out.println("eng1 == eng2 results to " + (eng1 == eng2)); // Output: false
     System.out.println("eng1.name == eng2.name results to " + (eng1.name == eng2.name)); // Output: true
   }
}
