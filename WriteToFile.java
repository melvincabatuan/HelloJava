import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;


public class WriteToFile {
    public static void main(String[] args) throws IOException {
        File file = new File("HighScores.txt");
        if (file.exists()){
           System.out.println("File already exists");
           System.exit(1);
        }
        PrintWriter output = new PrintWriter(file);
        output.println("Me " + " 100");
        output.println("You " + " 200");
        output.close();
   } 
}
