/**
* Illustrate the Constructor method
● Constructor name == the class name
● No return type – never returns anything
● Usually initialize fields
● All classes need at least one constructor
– If you don’t write one, defaults to
 CLASSNAME(){
} 
*/

public class Car
{
	String make;
	String model;
	int numDoors;

        // Constructor
	Car(String make, String model)
	{
	    this(make, model, 4);
	}

	Car(String make, String model, int nDoors)
	{
	   this.make = make;
	   this.model = model;
	   numDoors = nDoors;
	}

        void printDetails()
	{
	   System.out.println("Make = " + make);
	   System.out.println("Model = " + model);
	   System.out.println("Number of doors = " + numDoors);
	   System.out.println();
	}

    public static void main(String[] args)
    {
	Car myCar = new Car("Toyota", "Camry");
        Car yourCar = new Car("Mazda", "RX-8", 2);

        System.out.println("My car :");
        myCar.printDetails();
        System.out.println("Your car :");
        yourCar.printDetails();
    }
}
