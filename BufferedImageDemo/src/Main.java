import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

	public void paint(Graphics g) {
		Image img = createImageWithText();
		g.drawImage(img, 20, 20, this);
	}

	/// In Java , BufferedImage class is used to handle images. 
	private Image createImageWithText() {
		BufferedImage bufferedImage = new BufferedImage(110, 90,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();

		g.drawString("Hello, hello! ", 20, 20);
		g.drawString("Hello Don, ", 20, 40);
		g.drawString("Hello Peg! ", 20, 60);
		g.drawString("Hello, hello!", 20, 80);
		return bufferedImage;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Main());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

}