import java.io.PrintWriter;

public class Student extends Person {
	private int sId; // variable to store the
						// student ID
	private int numberOfCourses; // variable to store the number
									// of courses
	private boolean isTuitionPaid; // variable to indicate whether
									// the tuition is paid
	private Course[] coursesEnrolled; // array to store
										// the courses
	private char[] courseGrades; // array to store the
									// course grades

	// Default constructor
	// Postcondition: The instance variables are initialized.
	public Student() {
		super();
		numberOfCourses = 0;
		sId = 0;
		isTuitionPaid = false;

		coursesEnrolled = new Course[6];

		for (int i = 0; i < 6; i++)
			coursesEnrolled[i] = new Course();

		courseGrades = new char[6];

		for (int i = 0; i < 6; i++)
			courseGrades[i] = '*';

	}

	// Method to set a student's information
	// Postcondition: The instance variables are set according
	// to the parameters.
	public void setInfo(String fName, String lName, int ID, int nOfCourses,
			boolean isTPaid, Course[] courses, char[] cGrades) {
		int i;

		setName(fName, lName); // set the name

		sId = ID; // set the student ID
		isTuitionPaid = isTPaid; // set isTuitionPaid
		numberOfCourses = nOfCourses; // set the number of courses

		for (i = 0; i < numberOfCourses; i++) // set the array
		{
			coursesEnrolled[i].copyCourseInfo(courses[i]);
			courseGrades[i] = cGrades[i];
		}

		sortCourses(); // sort the array coursesEnrolled
	}

	// Method to set a student�s ID
	// Postcondition: sId = ID;
	public void setStudentId(int ID) {
		sId = ID;
	}

	// Method to set whether the tuition is paid
	// Postcondition: isTuitionPaid = isTPaid;
	public void setIsTuitionPaid(boolean isTPaid) {
		isTuitionPaid = isTPaid;
	}

	// Method to set the number of courses taken
	// Postcondition: numberOfCourses = nOfCourses;
	public void setNumberOfCourses(int nOfCourses) {
		numberOfCourses = nOfCourses;
	}

	// Method to set the courses enrolled
	// Postcondition: The array courses is copied into the
	// array coursesEnrolled, the array cGrades is
	// copied into the array courseGrades, and these
	// arrays are sorted.
	public void setCoursesEnrolled(Course[] courses, char[] cGrades) {
		for (int i = 0; i < numberOfCourses; i++) {
			coursesEnrolled[i].copyCourseInfo(courses[i]);
			courseGrades[i] = cGrades[i];
		}

		sortCourses();
	}

	// Method to print a student's grade report
	// Postcondition: If the instance variable isTuitionPaid
	// is true, the grades are shown; otherwise three
	// stars are printed.
	public void print(double tuitionRate) {
		int i;

		System.out.println("Student Name: " + super.toString()); // Step 1

		System.out.println("Student ID: " + sId); // Step 2

		System.out.println("Number of courses enrolled: " + numberOfCourses); // Step
																				// 3
		System.out.printf("%-12s%-15s%-8s%-6s%n", "Course No", "Course Name",
				"Credits", "Grade"); // Step 4

		for (i = 0; i < numberOfCourses; i++) // Step 5
		{
			coursesEnrolled[i].print();

			if (isTuitionPaid)
				System.out.printf("%8s%n", courseGrades[i]);
			else
				System.out.printf("%8s%n", "***");
		}

		System.out.println();

		System.out.println("Total number of credit hours: "
				+ getHoursEnrolled()); // Step 6

		if (isTuitionPaid) // Step 7
			System.out.printf("Midsemester GPA: %.2f%n", getGpa());
		else {
			System.out.println("*** Grades are being held for "
					+ "not paying the tuition. ***");
			System.out
					.printf("Amount Due: $%.2f%n", billingAmount(tuitionRate));
		}

		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-"
				+ "*-*-*-*-*-*-*-*-*-*-\n");
	}

	// Method to print a student's grade report
	// The output is stored in a file specified by the
	// parameter outp.
	// Postcondition: If the instance variable isTuitionPaid
	// is true, the grades are shown; otherwise three
	// stars are printed.
	public void print(PrintWriter outp, double tuitionRate) {
		int i;

		outp.println("Student Name: " + super.toString()); // Step 1

		outp.println("Student ID: " + sId); // Step 2

		outp.println("Number of courses enrolled: " + numberOfCourses); // Step
																		// 3
		outp.printf("%-12s%-15s%-8s%-6s%n", "Course No", "Course Name",
				"Credits", "Grade"); // Step 4

		for (i = 0; i < numberOfCourses; i++) // Step 5
		{
			coursesEnrolled[i].print(outp);

			if (isTuitionPaid)
				outp.printf("%8s%n", courseGrades[i]);
			else
				outp.printf("%8s%n", "***");
		}

		outp.println();

		outp.println("Total number of credit hours: " + getHoursEnrolled()); // Step
																				// 6

		if (isTuitionPaid) // Step 7
			outp.printf("Midsemester GPA: %.2f%n", getGpa());
		else {
			outp.println("*** Grades are being held for "
					+ "not paying the tuition. ***");
			outp.printf("Amount Due: $%.2f%n", billingAmount(tuitionRate));
		}

		outp.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-" + "*-*-*-*-*-*-*-*-*-*-\n");
	}

	// Method to get a student�s ID
	// Postcondition: The value of sId is returned.
	public int getStudentId() {
		return sId;
	}

	// Method to return whether the tuition is paid
	// Postcondition: The value of isTuitionPaid is returned.
	public boolean getIsTuitionPaid() {
		return isTuitionPaid;
	}

	// Method to get the number of courses taken
	// Postcondition: The value of numberOfCourses is returned.
	public int getNumberOfCourses() {
		return numberOfCourses;
	}

	// Method to get a copy of a course taken
	// Postcondition: A copy of coursesEnrolled[i]
	// is returned.
	public Course getCourse(int i) {
		Course temp = new Course();

		temp.copyCourseInfo(coursesEnrolled[i]);

		return temp;
	}

	// Method to return a course grade
	// Postcondition: The value of courseGrades[i] is returned.
	public char getGrade(int i) {
		return courseGrades[i];
	}

	// Method to return the credit hours in which a
	// student is enrolled
	// Postcondition: The total credits are calculated
	// and returned
	public int getHoursEnrolled() {
		int totalCredits = 0;
		int i;

		for (i = 0; i < numberOfCourses; i++)
			totalCredits += coursesEnrolled[i].getCredits();

		return totalCredits;
	}

	// Method to return the grade point average
	// Postcondition: The GPA is calculated and returned
	public double getGpa() {
		int i;
		double sum = 0.0;

		for (i = 0; i < numberOfCourses; i++) {
			switch (courseGrades[i]) {
			case 'A':
				sum += coursesEnrolled[i].getCredits() * 4;
				break;

			case 'B':
				sum += coursesEnrolled[i].getCredits() * 3;
				break;

			case 'C':
				sum += coursesEnrolled[i].getCredits() * 2;
				break;

			case 'D':
				sum += coursesEnrolled[i].getCredits() * 1;
				break;

			case 'F':
				sum += coursesEnrolled[i].getCredits() * 0;
				break;

			default:
				System.out.println("Invalid Course Grade");
			}
		}

		return sum / getHoursEnrolled();
	}

	// Method to return the tuition fees
	// Postcondition: The billing amount is calculated
	// and returned.
	public double billingAmount(double tuitionRate) {
		return tuitionRate * getHoursEnrolled();
	}

	// Method to sort the courses
	// Postcondition: The array coursesEnrolled is sorted.
	// The grades for each course, in the
	// array courseGrades, are also reorganized.
	private void sortCourses() {
		int i, j;
		int minIndex;
		Course temp = new Course(); // variable to swap data
		String course1;
		String course2;

		char tempGrade;

		for (i = 0; i < numberOfCourses - 1; i++) {
			minIndex = i;

			for (j = i + 1; j < numberOfCourses; j++) {
				// get course numbers
				course1 = coursesEnrolled[minIndex].getCourseNumber();
				course2 = coursesEnrolled[j].getCourseNumber();

				if (course1.compareTo(course2) > 0)
					minIndex = j;
			}// end for

			temp.copyCourseInfo(coursesEnrolled[minIndex]);
			coursesEnrolled[minIndex].copyCourseInfo(coursesEnrolled[i]);
			coursesEnrolled[i].copyCourseInfo(temp);

			tempGrade = courseGrades[minIndex];
			courseGrades[minIndex] = courseGrades[i];
			courseGrades[i] = tempGrade;
		}// end for
	}// end sortCourses
}
