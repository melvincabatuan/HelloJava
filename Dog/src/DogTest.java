
public class DogTest {

	public static void main(String[] args) {
		 Dog balto = new Dog();
		 
		 balto.age = 5;
		 balto.breed = "Pitbull";
         balto.color = "Black";
         balto.name = "Balto \" The POLICE \" ";
         
         System.out.println("My dog is: ");
         System.out.println(balto.name);
         System.out.println(balto.breed);
         System.out.println(balto.color);
         System.out.println(balto.age + " years old.");
         
	}

}
