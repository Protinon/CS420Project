package Relationship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Aggregation extends Relationship {
	
	public Aggregation(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);
		g2.drawLine(5, 5, 100, 5);
		g2.drawLine(100, 5, 105, 0);
		g2.drawLine(105, 0, 110, 5);
		g2.drawLine(110, 5, 105, 10);
		g2.drawLine(105, 10, 100, 5);
	}
}
