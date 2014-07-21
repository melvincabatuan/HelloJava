public class StudentObj {

   /** Private member variables */
   private String name;
   private String address;

   /** Courses taken and grades for the courses are kept in 2 arrays of the same length */
   private String[] courses;
   private int[] grades;     // A grade is between 0 to 100
   private int numCourses;   // Number of courses taken so far
   private static final int MAX_COURSES = 30;  // maximum courses
 
   /** Constructor 
   @param name Student name
   @param address Student address 
   */
   public StudentObj(String name, String address) {
      this.name = name;
      this.address = address;
      courses = new String[MAX_COURSES];   
      grades = new int[MAX_COURSES];
      numCourses = 0;                      
   }
 
   /**  Public getter for private variable name
   @return name Student name 
   */
   public String getName() {
      return name;
   }
 
   /** Public getter for private variable address
   @return address Student address 
   */
   public String getAddress() {
      return address;
   }
 
   /** Public setter for private variable address
   @param address Student address
   */
   public void setAddress(String address) {
      this.address = address;
   }
 
   /**
   @return String
   */
   public String toString() {
      return name + " of " + address + " Kingdom!";
   }
 
   /** Add a course and grade
   @param course course taken
   @param grade grade per course 
   */   
   public void addCourseGrade(String course, int grade) {
      courses[numCourses] = course;
      grades[numCourses] = grade;
      ++numCourses;
   }
 
   /** Print all courses taken and their grades
    */
   public void printGrades() {
      System.out.print(this);   // toString()
      for (int i = 0; i < numCourses; ++i) {
         System.out.print(" " + courses[i] + ":" + grades[i]);
      }
      System.out.println();
   }
 
   /** Compute the average grade
   @return average
   */
   public double getAverageGrade() {
      int sum = 0;
      for (int i = 0; i < numCourses; ++i) {
         sum += grades[i];
      }
      return (double)sum/numCourses;
   }

   /// main() Method
   public static void main(String[] args) {
      StudentObj toothLess = new StudentObj("Tooth Less", "Sovengarde");
      toothLess.addCourseGrade("FLY101", 89);
      toothLess.addCourseGrade("DIVE102", 90);
      toothLess.addCourseGrade("RUN103", 95);
      toothLess.printGrades();
      System.out.printf("The average grade is %.2f.\n", toothLess.getAverageGrade());
   }
   

}
