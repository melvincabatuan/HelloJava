/*  
  * Captures the camera stream with OpenCV  
  * Search for the faces  
  * Display a circle around the faces  
  */  
 import java.awt.*;  
 import java.awt.image.BufferedImage;  
 import javax.swing.*;  
 import org.opencv.core.Core;  
 import org.opencv.core.Mat;  
 import org.opencv.core.MatOfRect;  
 import org.opencv.core.Point;  
 import org.opencv.core.Rect;  
 import org.opencv.core.Scalar;  
 import org.opencv.core.Size;  
 import org.opencv.highgui.VideoCapture;  
 import org.opencv.imgproc.Imgproc;  
 import org.opencv.objdetect.CascadeClassifier;  
 class My_Panel extends JPanel{  
      private static final long serialVersionUID = 1L;  
      private BufferedImage image;  
      private CascadeClassifier face_cascade;  
      // Create a constructor method  
      public My_Panel(){  
           super();   
           //String face_cascade_name = "/haarcascade_frontalface_alt.xml";  
           //String face_cascade_name = "/lbpcascade_frontalface.xml";  
           //-- 1. Load the cascades  
           //String str;  
           //str = getClass().getResource(face_cascade_name).getPath();  
           //str = str.replace("/C:","C:");  
           //face_cascade_name=str;  
           //face_cascade=new CascadeClassifier(face_cascade_name);  
           face_cascade=new CascadeClassifier("C:/USERDATA/MEDICAL/CODE/java webcam facedetect/bin/haarcascade_frontalface_alt.xml");  
           //face_cascade=new CascadeClassifier("C:/eclipse/opencv/data/haarcascades/haarcascade_frontalface_alt.xml");  
           if(face_cascade.empty())  
           {  
                System.out.println("--(!)Error loading A\n");  
                 return;  
           }  
           else  
           {  
                      System.out.println("Face classifier loooaaaaaded up");  
           }  
      }  
      private BufferedImage getimage(){  
           return image;  
      }  
      public void setimage(BufferedImage newimage){  
           image=newimage;  
           return;  
      }  
      /**  
       * Converts/writes a Mat into a BufferedImage.  
       *   
       * @param matrix Mat of type CV_8UC3 or CV_8UC1  
       * @return BufferedImage of type TYPE_3BYTE_BGR or TYPE_BYTE_GRAY  
       */  
      public BufferedImage matToBufferedImage(Mat matrix) {  
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
        BufferedImage image2 = new BufferedImage(cols, rows, type);  
        image2.getRaster().setDataElements(0, 0, cols, rows, data);  
        return image2;  
      }  
      public void paintComponent(Graphics g){  
            BufferedImage temp=getimage();  
            g.drawImage(temp,10,10,temp.getWidth(),temp.getHeight(), this);   
      }  
      public Mat detect(Mat inputframe){  
           Mat mRgba=new Mat();  
           Mat mGrey=new Mat();  
           MatOfRect faces = new MatOfRect();  
           inputframe.copyTo(mRgba);  
           inputframe.copyTo(mGrey);  
           Imgproc.cvtColor( mRgba, mGrey, Imgproc.COLOR_BGR2GRAY);  
           Imgproc.equalizeHist( mGrey, mGrey );  
           face_cascade.detectMultiScale(mGrey, faces);  
           //face_cascade.detectMultiScale(mGrey, faces, 1.1, 2, 0|Objdetect.CASCADE_SCALE_IMAGE, new Size(30, 30), new Size(200,200) );  
           //face_cascade.detectMultiScale(mGrey, faces, 1.1, 2, 2//CV_HAAR_SCALE_IMAGE,  
           //          ,new Size(30, 30), new Size(200,200) );  
           System.out.println(String.format("Detected %s faces", faces.toArray().length));  
           for(Rect rect:faces.toArray())  
           {  
                Point center= new Point(rect.x + rect.width*0.5, rect.y + rect.height*0.5 );  
                Core.ellipse( mRgba, center, new Size( rect.width*0.5, rect.height*0.5), 0, 0, 360, new Scalar( 255, 0, 255 ), 4, 8, 0 );  
           }  
           return mRgba;  
           }  
 }  
 public class window {  
      public static void main(String arg[]){  
       // Load the native library.  
       System.loadLibrary("opencv_java245");       
       String window_name = "Capture - Face detection";  
       JFrame frame = new JFrame(window_name);  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    frame.setSize(400,400);  
    My_Panel my_panel = new My_Panel();  
    frame.setContentPane(my_panel);       
    frame.setVisible(true);        
       //-- 2. Read the video stream  
    BufferedImage temp;  
        Mat webcam_image=new Mat();  
        VideoCapture capture =new VideoCapture(0);   
    if( capture.isOpened())  
           {  
            while( true )  
            {  
                 capture.read(webcam_image);  
              if( !webcam_image.empty() )  
               {   
                    frame.setSize(webcam_image.width()+40,webcam_image.height()+60);  
                    //-- 3. Apply the classifier to the captured image  
                    // At this point I was wondering where this should be done.  
                    // I put it within the panel class, but maybe one could actually  
                    // create a processor object...  
                    webcam_image=my_panel.detect(webcam_image);  
                   //-- 4. Display the image  
                    temp=my_panel.matToBufferedImage(webcam_image);  
                    my_panel.setimage(temp);  
                    my_panel.repaint();   
               }  
               else  
               {   
                    System.out.println(" --(!) No captured frame -- Break!");   
                    break;   
               }  
              }  
             }  
             return;  
      }  
 }  