import javax.imageio.*;

import java.io.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

/**
 * A class demonstrating manipulation of image pixels.
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten for BufferedImage, Winter 2014
 */
public class ImageProcessing {
	private DrawingFrame gui;			// handles the image display
	private BufferedImage original;		// the unprocessed image, as read from a file
	private BufferedImage current;		// the version that's been processed

	/**
	 * @param image		the original
	 */
	public ImageProcessing(String filename) {
		// Create a GUI element to display the image.
		gui = new DrawingFrame("Image Processing", filename);

		// Hold on to a copy of the image (so can mess it up).
		current = gui.getImage();
		original = new BufferedImage(gui.getImage().getColorModel(), gui.getImage().copyData(null), gui.getImage().getColorModel().isAlphaPremultiplied(), null);

		// Listen to key presses (will discuss this next time)
		gui.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				process(e.getKeyChar());
			}
		});
	}

	/**
	 * Dispatches on user input as to how to modify the image.
	 * Note that there are some magic numbers here that you can play with.
	 * While that's generally bad practice, it's just for simplicity in this hodge-podge of examples.
	 */
	public void process(char op) {
		System.out.println("Processing key '"+op+"'");
		if (op=='a') { // average
			average(1);
		}
		else if (op=='b') { // brighten
			brighten();
		}
		else if (op=='c') { // funky color scaling
			scaleColor(1.25, 1.0, 0.75);
		}
		else if (op=='d') { // dim
			dim();
		}
		else if (op=='f') { // flip
			flip();
		}
		else if (op=='g') { // gray
			gray();
		}
		else if (op=='h') { // sharpen
			sharpen(3);
		}
		else if (op=='m') { // scramble
			scramble(5);
		}
		else if (op=='n') { // noise
			noise(20);
		}
		else if (op=='o') { // revert to original
			current = new BufferedImage(original.getColorModel(), original.copyData(null), original.getColorModel().isAlphaPremultiplied(), null);
		}
		else if (op=='s') { // save a snapshot
			try {
				ImageIO.write(current, "jpg", new File("pictures/snapshot.jpg"));
				System.out.println("Saved a snapshot");
			}
			catch (Exception e) {
				System.err.println("Couldn't save snapshot.");
			}
		}
		else {
			System.out.println("Unknown operation");
		}
		gui.setImage(current);
	}

	/**
	 * Returns a value that is one of val (if it's between min or max) or min or max (if it's outside that range).
	 * @param val
	 * @param min
	 * @param max
	 * @return constrained value
	 */
	private static double constrain(double val, double min, double max) {
		if (val < min) {
			return min;
		}
		else if (val > max) {
			return max;
		}
		return val;
	}

	/**
	 * Blurs the current image by setting each pixel's values to the average of those in a radius-sized box around it.
	 * Use a smallish box (e.g., 1) unless the image is small or you're willing to wait a while.
	 * @param radius		size of box; e.g., 1 indicates +-1 around the pixel
	 */
	private void average(int radius) {
		// Create a new image into which the resulting pixels will be stored.
		BufferedImage result = new BufferedImage(current.getWidth(), current.getHeight(), current.getType());
		// Nested loop over every pixel
		for (int y = 0; y < current.getHeight(); y++) {
			for (int x = 0; x < current.getWidth(); x++) {
				int sumR = 0, sumG = 0, sumB = 0;
				int n = 0;
				// Nested loop over neighbors
				// but be careful not to go outside image (max, min stuff).
				for (int ny = Math.max(0, y - radius); 
						ny < Math.min(current.getHeight(), y + 1 + radius); 
						ny++) {
					for (int nx = Math.max(0, x - radius); 
							nx < Math.min(current.getWidth(), x + 1 + radius);
							nx++) {
						// Add all the neighbors (& self) to the running totals
						Color c = new Color(current.getRGB(nx, ny));
						sumR += c.getRed();
						sumG += c.getGreen();
						sumB += c.getBlue();
						n++;
					}
				}
				Color newColor = new Color(sumR/n, sumG/n, sumB/n);
				result.setRGB(x, y, newColor.getRGB());
			}
		}
		// Make the current image be this new image.
		current = result;
	}

	/**
	 * Brightens the current image by scaling up pixel values (but not exceeding 255).
	 */
	private void brighten() {
		// Nested loop over every pixel
		for (int y = 0; y < current.getHeight(); y++) {
			for (int x = 0; x < current.getWidth(); x++) {
				// Get current color; scale each channel
				Color color = new Color(current.getRGB(x, y));
				int red = Math.min(255, color.getRed()*4/3);
				int green = Math.min(255, color.getGreen()*4/3);
				int blue = Math.min(255, color.getBlue()*4/3);
				// Put new color
				Color newColor = new Color(red, green, blue);
				current.setRGB(x, y, newColor.getRGB());
			}
		}
	}

	/**
	 * Dims the current image by scaling down pixel values.
	 */
	private void dim() {
		// Nested loop over every pixel
		for (int y = 0; y < current.getHeight(); y++) {
			for (int x = 0; x < current.getWidth(); x++) {
				// Get current color; scale each channel
				Color color = new Color(current.getRGB(x, y));
				int red = color.getRed()*3/4;
				int green = color.getGreen()*3/4;
				int blue = color.getBlue()*3/4;
				// Put new color
				Color newColor = new Color(red, green, blue);
				current.setRGB(x, y, newColor.getRGB());
			}
		}
	}

	/**
	 * Dims/brightens the current image by scaling each pixel value by the specified amount.
	 * @param scale		how much to scale the pixel values
	 */
	private void scaleColor(double scaleR, double scaleG, double scaleB) {
		// Nested loop over every pixel
		for (int y = 0; y < current.getHeight(); y++) {
			for (int x = 0; x < current.getWidth(); x++) {
				// Get current color; scale each channel
				Color color = new Color(current.getRGB(x, y));
				int red = (int)(Math.min(255, color.getRed()*scaleR));
				int green = (int)(Math.min(255, color.getGreen()*scaleG));
				int blue = (int)(Math.min(255, color.getBlue()*scaleB));
				// Put new color
				Color newColor = new Color(red, green, blue);
				current.setRGB(x, y, newColor.getRGB());
			}
		}
	}

	/**
	 * Flips the current image upside down.
	 */
	private void flip() {
		// Create a new image into which the resulting pixels will be stored.
		BufferedImage result = new BufferedImage(current.getWidth(), current.getHeight(), current.getType());
		// Nested loop over every pixel
		for (int y = 0; y < current.getHeight(); y++) {
			for (int x = 0; x < current.getWidth(); x++) {
				int y2 = current.getHeight() - 1 - y; // note that indices go 0..height-1
				result.setRGB(x, y2, current.getRGB(x, y));
			}
		}
		// Make the current image be this new image.
		current = result;
	}

	/**
	 * Computes the luminosity of an rgb value by one standard formula.
	 * @param r		red value (0-255)
	 * @param g		green value (0-255)
	 * @param b		blue value (0-255)
	 * @return		luminosity (0-255)
	 */
	private static int luminosity(int r, int g, int b) {
		return (int)(0.299 * r + 0.587 * g + 0.114 * b);
	}

	/**
	 * Makes the current image look grayscale (though still represented as RGB).
	 */
	private void gray() {
		// Nested loop over every pixel
		for (int y = 0; y < current.getHeight(); y++) {
			for (int x = 0; x < current.getWidth(); x++) {
				// Get current color; set each channel to luminosity
				Color color = new Color(current.getRGB(x, y));
				int gray = luminosity(color.getRed(), color.getGreen(), color.getBlue());
				// Put new color
				Color newColor = new Color(gray, gray, gray);
				current.setRGB(x, y, newColor.getRGB());
			}
		}
	}

	/**
	 * Sharpens the current image by setting each pixel's values to subtract out those in a radius-sized box around it.
	 * Use a smallish box (e.g., 1) unless the image is small or you're willing to wait a while.
	 * @param radius		size of box; e.g., 1 indicates +-1 around the pixel
	 */
	private void sharpen(int radius) {
		// Create a new image into which the resulting pixels will be stored.
		BufferedImage result = new BufferedImage(current.getWidth(), current.getHeight(), current.getType());
		// Nested loop over every pixel
		for (int y = 0; y < current.getHeight(); y++) {
			for (int x = 0; x < current.getWidth(); x++) {
				int sumR = 0, sumG = 0, sumB = 0;
				int n = 0;
				// Nested loop over neighbors
				// but be careful not to go outside image (max, min stuff).
				for (int ny = Math.max(0, y - radius); 
						ny < Math.min(current.getHeight(), y + 1 + radius); 
						ny++) {
					for (int nx = Math.max(0, x - radius); 
							nx < Math.min(current.getWidth(), x + 1 + radius);
							nx++) {
						// Add all the neighbors (but not self) to the running totals
						if (nx != x || ny != y) {
							Color c = new Color(current.getRGB(nx, ny));
							sumR += c.getRed();
							sumG += c.getGreen();
							sumB += c.getBlue();
							n++;
						}
					}
				}
				// Weighted center pixel minus sum of neighbors
				Color c = new Color(current.getRGB(x, y));
				int red = (int)constrain(c.getRed()*(n+1) - sumR, 0, 255);
				int green = (int)constrain(c.getGreen()*(n+1) - sumG, 0, 255);
				int blue = (int)constrain(c.getBlue()*(n+1) - sumB, 0, 255);
				Color newColor = new Color(red, green, blue);
				result.setRGB(x, y, newColor.getRGB());
			}
		}
		// Make the current image be this new image.
		current = result;
	}

	/**
	 * Adds random noise to each pixel.
	 * @param scale		maximum value of the noise to be added
	 */
	private void noise(double scale) {
		// Nested loop over every pixel
		for (int y = 0; y < current.getHeight(); y++) {
			for (int x = 0; x < current.getWidth(); x++) {
				// Get current color; add noise to each channel
				Color color = new Color(current.getRGB(x, y));
				int red = (int)(constrain(color.getRed() + scale * (2*Math.random() - 1), 0, 255));
				int green = (int)(constrain(color.getGreen() + scale * (2*Math.random() - 1), 0, 255));
				int blue = (int)(constrain(color.getBlue() + scale * (2*Math.random() - 1), 0, 255));
				// Put new color
				Color newColor = new Color(red, green, blue);
				current.setRGB(x, y, newColor.getRGB());
			}
		}
	}

	/**
	 * Scrambles the current image by setting each pixel from some nearby pixel.
	 * @param radius		maximum distance (+- that amount in x and y) of "nearby"
	 */
	private void scramble(int radius) {
		// Create a new image into which the resulting pixels will be stored.
		BufferedImage result = new BufferedImage(current.getWidth(), current.getHeight(), current.getType());
		// Nested loop over every pixel
		for (int y = 0; y < current.getHeight(); y++) {
			for (int x = 0; x < current.getWidth(); x++) {
				// Random neighbors in x and y; constrain to image size
				int nx = (int) constrain(x + radius * (2*Math.random() - 1), 0, current.getWidth() - 1);
				int ny = (int) constrain(y + radius * (2*Math.random() - 1), 0, current.getHeight() - 1);
				result.setRGB(x, y, current.getRGB(nx, ny));
			}
		}
		// Make the current image be this new image.
		current = result;
	}

	/**
	 * Main method for the application
	 * @param args		command-line arguments (ignored)
	 */
	public static void main(String[] args) { 
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Create an image processing object for the image.
				ImageProcessing proc = new ImageProcessing("pictures/baker.jpg");
			}
		});
	}
}
