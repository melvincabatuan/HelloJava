import java.io.File;

class FileDemo{
 
    public static void main(String[] args){

      File myFile = new File("./README");

      if(!myFile.exists()){
        System.out.println("File NOT found.");
        System.out.println("Please provide a file.");
       }
       else {
         System.out.println("File found.");
         System.out.println("What process would you like to perform?");
       }  
    }
}
