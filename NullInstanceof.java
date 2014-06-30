class NullInstanceof {

    public static void main(String []args) {

	String str = null;

	if(str instanceof Object) // NULLCHK
	   System.out.println("str is Object");
	else
	   System.out.println("str is not Object");
    }
}
