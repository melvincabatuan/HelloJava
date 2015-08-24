/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */




import acm.util.*;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

        // 1. name: The name itself, such as "Sam" or "Samantha"
        private String name;

        // 2. rank: A list of 12 values indicating the rank of that name in each of the decades 
        // from 1900 to 2010, inclusive.
        private int[] rank = new int[NDECADES];


	/* Constructor: NameSurferEntry(line) */
	/**
	 * Creates a new NameSurferEntry from a data line as it appears
	 * in the data file.  Each line begins with the name, which is
	 * followed by integers giving the rank of that name for each
	 * decade.
	 */
	public NameSurferEntry(String line) {
		// You fill this in //
              String[] temp = line.split(" ");

              name = temp[0];

              for(int i = 1; i < temp.length ; i++){              
                    rank[i-1] = Integer.parseInt(temp[i]);      
              }
	}

	/* Method: getName() */
	/**
	 * Returns the name associated with this entry.
	 */
	public String getName() {
		// You need to turn this stub into a real implementation //
		return name;
	}

	/* Method: getRank(decade) */
	/**
	 * Returns the rank associated with an entry for a particular
	 * decade.  The decade value is an integer indicating how many
	 * decades have passed since the first year in the database,
	 * which is given by the constant START_DECADE.  If a name does
	 * not appear in a decade, the rank value is 0.
	 */
	public int getRank(int decade) {
		// You need to turn this stub into a real implementation //
             //if (decade > 0 && decade <= 12) 
                return (rank[decade - 1]);
             }


	/* Method: toString() */
	/**
	 * Returns a string that makes it easy to see the value of a
	 * NameSurferEntry.
	 */
	public String toString() {
		// You need to turn this stub into a real implementation //
                String s = name + " [";
                for(int i = 0; i < rank.length; i++){
                     s += rank[i];
                     if (i < rank.length -1)
                         s += " ";
                }
                s += "]";
		return s;
	}
}

