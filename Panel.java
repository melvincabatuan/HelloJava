// Import the basic graphics classes.  
 // The problem here is that we read the image with OpenCV into a Mat object.  
 // But OpenCV for java doesn't have the method "imshow", so, we got to use  
 // java for that (drawImage) that uses Image or BufferedImage (?)  
 // So, how to go from one the other...  
 import java.awt.*;  
 import java.awt.image.BufferedImage;  
 import javax.swing.*;  
 //import org.opencv.core.Core;  
 import org.opencv.core.Mat;  
 import org.opencv.highgui.Highgui;  
 public class Panel extends JPanel{  
   private static final long serialVersionUID = 1L;  
   String pic_name="resources/DSC01638.jpg";  
   Mat picture;  
   BufferedImage image;  
   /**  
    * Converts/writes a Mat into a BufferedImage.  
    *  
    * @param matrix Mat of type CV_8UC3 or CV_8UC1  
    * @return BufferedImage of type TYPE_3BYTE_BGR or TYPE_BYTE_GRAY  
    */  
   public static BufferedImage matToBufferedImage(Mat matrix) {  
     int cols = matrix.cols();  
     int rows = matrix.rows();  
     int elemSize = (int)matrix.elemSize();  
     byte[] data = new byte[cols * rows * elemSize];  
     int type;  
     matrix.get(0, 0, data);  
     switch (matrix.channels()) {  
       case 1:  
         type = BufferedImage.TYPE_BYTE_GRAY;  
         break;  
       case 3:  
         type = BufferedImage.TYPE_3BYTE_BGR;  
         // bgr to rgb  
         byte b;  
         for(int i=0; i<data.length; i=i+3) {  
           b = data[i];  
           data[i] = data[i+2];  
           data[i+2] = b;  
         }  
         break;  
       default:  
         return null;  
     }  
     BufferedImage image = new BufferedImage(cols, rows, type);  
     image.getRaster().setDataElements(0, 0, cols, rows, data);  
     return image;  
   }  
   // Create a constructor method  
   public Panel(){  
     super(); // Calls the parent constructor  
     picture = Highgui.imread(pic_name);  
     // Got to cast picture into Image  
     image=matToBufferedImage(picture);  
   }  
   public void paintComponent(Graphics g){  
      g.drawImage(image,50,10,400,400, this);  
   }  
   public static void main(String arg[]){  
    // Load the native library.  
    System.loadLibrary("opencv_java245");    
    JFrame frame = new JFrame("BasicPanel");  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    frame.setSize(400,400);  
    Panel panel = new Panel();  
    frame.setContentPane(panel);       
    frame.setVisible(true);           
  }  
 }  