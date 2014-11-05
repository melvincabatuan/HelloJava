package com.cabatuan.breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import acm.graphics.GRect;

@SuppressWarnings("serial")
public class BrickWall extends GRect {

	public BrickWall(double width, double height) {
		this(0, 0, width, height, 1, 1, 0);
	}

	public BrickWall(double x, double y, double width, double height) {
		this(x, y, width, height, 1, 1, 0);
	}

	public BrickWall(double x, double y, double width, double height,
			int _rows, int _cols, int _separation) {
		super(x, y, width, height);
		this.rows = _rows;
		this.cols = _cols;
		this.separation = _separation;
	}

	@Override
	public void paint(Graphics g) {
		Rectangle r = getAWTBounds();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (isFilled()) {
				setBrickColor(g,i);  
				g.fillRect(r.x + j * (r.width + separation), r.y + i
						* (r.height + separation), r.width, r.height);
				}
				g.drawRect(r.x + j * (r.width + separation), r.y + i
						* (r.height + separation), r.width, r.height);
			}
		}
	}

	private void setBrickColor(Graphics g, int row) {
		switch (row) {
		case 0:
		case 1:
			g.setColor(Color.RED);
			break;
		case 2:
		case 3:
			g.setColor(Color.ORANGE);
			break;
		case 4:
		case 5:
			g.setColor(Color.YELLOW);
			break;
		case 6:
		case 7:
			g.setColor(Color.GREEN);
			break;
		case 8:
		case 9:
			g.setColor(Color.CYAN);
			break;
		default:
			g.setColor(Color.BLACK);
		}
	}

	/************************* DATA FIELDS *********************************/

	private int rows;
	private int cols;
	private int separation;

}