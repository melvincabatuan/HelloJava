/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	 * Creates a new NameSurferGraph object that displays the data.
	 */
	public NameSurferGraph() {
		addComponentListener(this);                 
		// You fill in the rest //
                update();                
	}
	
	
	/**
	 * Clears the list of name surfer entries stored inside this class.
	 */
	public void clear() {
		// You fill this in //
	}
	
	
	/* Method: addEntry(entry) */
	/**
	 * Adds a new NameSurferEntry to the list of entries on the display.
	 * Note that this method does not actually draw the graph, but
	 * simply stores the entry; the graph is drawn by calling update.
	 */
	public void addEntry(NameSurferEntry entry) {
		// You fill this in //
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
	}

        /*
         MileStone 4:
         As a first step, write the code to create the background grid for the graph, 
         which consists of the vertical line separating each decade, the horizontal lines 
         that provide space for the top and bottom borders (which are there to ensure that 
         the text labels stay within the window bounds), and the labels for the decades.
        */
        public void drawBackground(){
             int width = getWidth();
             int height = getHeight();

             /// draw vertical lines and year labels            
             for(int i = 0; i < NDECADES; i++) {
	
                        double x = i * width / NDECADES;		
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

	
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
