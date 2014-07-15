class SLLDemo
{
  static class Node
  {
    String name;
    Node next;
  }

  public static void main (String [] args)
  {
 
  Node top = new Node ();
  top.name = "SALLE!";
  top.next = null;

  Node temp = new Node ();
  temp.name = "LA";
  temp.next = top;
  top = temp;
  temp = new Node ();
  temp.name = "ANIMO";
  temp.next = top;
  top = temp;
  temp = new Node ();
  temp.name = "DLSU!";
  temp.next = top;
  top = temp;
  display("Initial singly-linked list", top);

  // 1. Delete the first node
  top = top.next;
  display("After first node deletion", top);
  temp = new Node ();
  temp.name = "STC!";
  temp.next = top;
  top = temp;

  // 2. Delete any node but the first node
  temp = top;
  
    while (temp.name.equals("ANIMO") == false)
         temp = temp.next;
    temp.next = temp.next.next;
    display("After node deletion", top);
 }

static void display(String msg, Node topNode){
  System.out.print (msg + " ");
 
  while (topNode != null)
  {
    System.out.print (topNode.name + " ");
    topNode = topNode.next;
  }
   System.out.println ();
 }
}
