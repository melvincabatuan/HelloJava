public class ForEachLoopDemo {

	public static void main(String[] args) {
		String []  friends = new String [20]; 
		friends[0] = "Masha";                 
		friends[1] = "Matilda";               
		friends[2] = "Rosa";
                friends[3] = "Rosalinda";
		friends[18] = "Hillary";
		friends[19] = "Natasha";
		 
		for (String girl: friends){
		   System.out.println("I love  " + girl);
		}		
		System.out.println("The iteration is over");
                System.out.println("The third girl's name is " + friends[2]);
		System.out.println("The twentieth girl's name is " + friends[19]);
	}
}
