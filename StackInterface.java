public interface StackInterface {
  

/** Add o to the top of this Stack.
 * Precondition: the stack is not full.
 * @param o The object to be pushed.
 */
 void push(long o);


 
/** Remove and return the top element of this Stack.
 * Precondition: the stack is not empty.
 * @return the formerly top element of the stack.
 */
long pop();


/** Returns the top element. */
long peek();


 /** Return whether the stack is empty. */
 boolean isEmpty();


 
 /** Return whether this Stack can hold any more items. */
 boolean isFull();

}
