class TestFile{     
 /* Test the file */
      public static void main(String[] args){ 
           CreateFileDemo myFile = new CreateFileDemo();
           myFile.openFile();
           myFile.addRecord();
           myFile.closeFile();
      }
}
