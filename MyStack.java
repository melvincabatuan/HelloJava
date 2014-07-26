public class MyStack implements StackInterface {
   private int maxSize;
   private long[] stackArray;
   private int top;
   private int counter; 

   public MyStack(int s) {
      maxSize = s;
      stackArray = new long[maxSize];
      top = -1;
      counter=0;
   }

   public void push(long j) {
      stackArray[++top] = j;
      counter++;
   }

   public long pop() {
      counter--;
      return stackArray[top--];
   }

   public long peek() {
      return stackArray[top];
   }

   public boolean isEmpty() {
      return (top == -1);
   }

   public boolean isFull() {
      return (top == maxSize - 1);
   }
 
   public int size() {
      return counter;
   }
  
   public void printElements(MyStack s) {
      int limit = s.size();       
      for(int i = 0; i < limit; i++)
	  System.out.println( s.pop()); 
   }


   public static void main(String[] args) {
      MyStack theStack = new MyStack(10); 
      //theStack.push(10);
      //theStack.push(20);
      //theStack.push(30);
      //theStack.push(40);
      //theStack.push(50);      
        

      for(int i = 0; i < 7; i++)
	     theStack.push( i );
  
 
     
     theStack.printElements(theStack);
     theStack.printElements(theStack);
     System.out.print("\n");
   }
}
