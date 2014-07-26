public class Person {
	private String firstName; // store the first name
	private String lastName; // store the last name

	// Default constructor
	// Initialize firstName and lastName to empty string
	// Postcondition: firstName = ""; lastName = "";
	public Person() {
		firstName = "";
		lastName = "";
	}

	// Constructor with parameters
	// Set firstName and lastName according to the parameters
	// Postcondition: firstName = first; lastName = last;
	public Person(String first, String last) {
		firstName = first;
		lastName = last;
	}

	// Method to output the first name and last name
	// in the form firstName lastName
	public String toString() {
		return (firstName + " " + lastName);
	}

	// Method to set firstName and lastName according to
	// the parameters
	// Postcondition: firstName = first; lastName = last;
	public void setName(String first, String last) {
		firstName = first;
		lastName = last;
	}

	// Method to return the firstName
	// Postcondition: the value of firstName is returned
	public String getFirstName() {
		return firstName;
	}

	// Method to return the lastName
	// Postcondition: the value of lastName is returned
	public String getLastName() {
		return lastName;
	}
}