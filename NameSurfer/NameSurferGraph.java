/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

        private ArrayList<NameSurferEntry> nameTrend;
        private ArrayList<Color> graphColor;

	/**
	 * Creates a new NameSurferGraph object that displays the data.
	 */
	public NameSurferGraph() {
		addComponentListener(this);                 
		// You fill in the rest //
                nameTrend = new ArrayList<NameSurferEntry>();
                graphColor = new  ArrayList<Color>();
                update();                
	}
	
	
	/**
	 * Clears the list of name surfer entries stored inside this class.
	 */
	public void clear() {
		// You fill this in //
             nameTrend.clear();             
	}
	
	
	/* Method: addEntry(entry) */
	/**
	 * Adds a new NameSurferEntry to the list of entries on the display.
	 * Note that this method does not actually draw the graph, but
	 * simply stores the entry; the graph is drawn by calling update.
	 */
	public void addEntry(NameSurferEntry entry) {
		// You fill this in //                 
               nameTrend.add(entry);
	}
	
	
	/**
	 * Updates the display image by deleting all the graphical objects
	 * from the canvas and then reassembling the display according to
	 * the list of entries. Your application must call update after
	 * calling either clear or addEntry; update is also called whenever
	 * the size of the canvas changes.
	 */
	public void update() {
             // You fill this in //

             /// delete any existing GObjects from the canvas
             removeAll();
     
             /// draw vertical and horizontal lines, with year labels
             drawBackground();  

             /// plot name surfer entries
             plotNameTrend(); 
	}

        /*
         MileStone 4:
         As a first step, write the code to create the background grid for the graph, 
         which consists of the vertical line separating each decade, the horizontal lines 
         that provide space for the top and bottom borders (which are there to ensure that 
         the text labels stay within the window bounds), and the labels for the decades.
        */
        private void drawBackground(){

             int width = getWidth();
             int height = getHeight();

             /// draw vertical lines and year labels            
             for(int i = 0; i < NDECADES; i++) {
	
                        int x = i * width / NDECADES;		
			GLine line = new GLine(x, 0, x, height);
			add(line);

                        GLabel year = new GLabel("" + (START_DECADE + 10 * i));
                        year.setFont("SansSerif-BOLD-18");
                        add(year, x, height);
	     }

             /// draw horizontal lines
             GLine topLine = new GLine(0, GRAPH_MARGIN_SIZE, width, GRAPH_MARGIN_SIZE);
             add(topLine);

             int y = height - GRAPH_MARGIN_SIZE;
             GLine bottomLine = new GLine(0, y, width, y);
	     add(bottomLine);
        }

       
        private void plotNameTrend(){
  
           RandomGenerator rgen = new RandomGenerator(); // For random colors
           double x1, x2, y1, y2;
           for(int i = 0; i < nameTrend.size(); i++){

              graphColor.add(rgen.nextColor());

               for(int j = 0;j < NDECADES - 1; j++){
                    x1 = j * getWidth() / NDECADES;
                    x2 = (j + 1) * getWidth() / NDECADES;
                    y1 = getPlotHeight(nameTrend.get(i).getRank(j + 1));
                    y2 = getPlotHeight(nameTrend.get(i).getRank(j + 2));
		
	            GLine line = new GLine(x1, y1, x2, y2);
                    
                     if (i % 4 == 1)  
                        line.setColor(Color.BLUE);
                     else if (i % 4 == 2)
                        line.setColor(Color.RED);
                     else
                        line.setColor(graphColor.get(i)); 

		    add(line);  

                    /// draw labels of name trends                 
                    addLabel(i, j + 1, x1, y1);    

                    /// draw the last label
                    if (j == NDECADES - 2){
                        addLabel(i, j + 2, x2, y2);
                    }
               } 
           }

        }


         /*
         Note: If rank is 1, y is GRAPH_MARGIN_SIZE; and if rank is 1000, y is getHeight() - GRAPH_MARGIN_SIZE - 1
               Finally, if rank is 0, y is getHeight() - GRAPH_MARGIN_SIZE.
         */
         private double getPlotHeight(int rank){
             double y_min = GRAPH_MARGIN_SIZE;
             double y_max = getHeight() - GRAPH_MARGIN_SIZE;
             if (rank == 0)
                return y_max;
             else
                return (GRAPH_MARGIN_SIZE + (y_max - y_min)*(rank - 1)/MAX_RANK);
         }





        private void addLabel(int nthName, int nthRank, double x, double y){

        GLabel popularity;
        int rank = nameTrend.get(nthName).getRank(nthRank);

        if (rank == 0) 
            popularity = new GLabel(nameTrend.get(nthName).getName() + " *");
        else
            popularity = new GLabel(nameTrend.get(nthName).getName() + " " + nameTrend.get(nthName).getRank(nthRank));

         popularity.setFont("SansSerif-10");

        if (nthName % 4 == 1) 
                        popularity.setColor(Color.BLUE);
        else if (nthName % 4 == 2)
                        popularity.setColor(Color.RED);
   
        else 
                        popularity.setColor(graphColor.get(nthName)); 
       

         add(popularity, x, y);
         }


         public void notFound(String name) {
            if(getElementAt(getWidth()/2, getHeight()/2) != null)
                remove(getElementAt(getWidth()/2, getHeight()/2));
            GLabel label = new GLabel("" + name + " is not found in top 1000!");
            label.setFont("Serif-bold-28");
            label.setColor(Color.RED);
            add(label, (getWidth() - label.getWidth())/2,(getHeight() - label.getHeight())/2);
         }

	
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
