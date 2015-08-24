import java.awt.GraphicsEnvironment;

public class FontFamilyNames {

    public static void main(String[] args) {

   /**
    * A font family refers to a set of font faces with a related typographic design. 
    * For example, the font faces in the Lucida Sans Typewriter family are 
    * Lucida Sans Typewriter Bold, and Lucida Sans Typewriter Regular etc.
    * This example lists all available font family names in the system.
    * 
    * Note: J2SE 1.4 only supports True Type fonts
    */

  GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

  String fontNames[] = ge.getAvailableFontFamilyNames();

  // Iterate the font family names

  for (int i=0; i<fontNames.length; i++) {

     System.out.println(fontNames[i]);

  }

    }

}
