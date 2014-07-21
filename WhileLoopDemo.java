
public class WhileLoopDemo {

	public static void main(String[] args) {
		String []  friends = new String [20];
		friends[0] = "Masha";                
		friends[1] = "Matilda";              
		friends[2] = "Rosa";
                friends[3] = "Rosalinda";
		friends[18] = "Hillary";
		friends[19] = "Natasha";

		int i=0;
		
		while (i<friends.length){
			   if (friends[i]==null){
				      i++;
				      continue;
			   }

			   System.out.println("I love " + friends[i]);
			       i++;    
		}
		
		System.out.println("The iteration is over");

	}
}

/* 
Sample Run:
$ javac WhileLoopDemo.java 
$ java WhileLoopDemo 
I love Masha
I love Matilda
I love Rosa
I love Rosalinda
I love Hillary
I love Natasha
The iteration is over
*/
