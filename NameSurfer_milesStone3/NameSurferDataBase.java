/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class NameSurferDataBase implements NameSurferConstants {

         private Map<String, NameSurferEntry> map = new TreeMap<String, NameSurferEntry>(String.CASE_INSENSITIVE_ORDER);
	
	/* Constructor: NameSurferDataBase(filename) */
	/**
	 * Creates a new NameSurferDataBase and initializes it using the
	 * data in the specified file.  The constructor throws an error
	 * exception if the requested file does not exist or if an error
	 * occurs as the file is being read.
	 */
	public NameSurferDataBase(String filename) {
		// You fill this in //
              try {
			BufferedReader namesData = new BufferedReader(new FileReader(filename));
			while(true) {
				String line = namesData.readLine();

				if(line == null) break;

                                NameSurferEntry nse = new NameSurferEntry(line);
				map.put(nse.getName(), nse);
			}			
			namesData.close();

		} catch (IOException ex) {
			System.err.println("IOException:" + ex.getMessage());
		}

	}
	
	/* Method: findEntry(name) */
	/**
	 * Returns the NameSurferEntry associated with this name, if one
	 * exists.  If the name does not appear in the database, this
	 * method returns null.
	 */
	public NameSurferEntry findEntry(String name) {
		// You need to turn this stub into a real implementation //
                if(map.containsKey(name))
		     return map.get(name);
                else
                     return null;
	}
}

