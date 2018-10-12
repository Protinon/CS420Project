package Relationship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Generalization extends Relationship {
	
	public Generalization(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);
		g2.drawLine(5, 5, 100, 5);
		g2.drawLine(100, 0, 100, 10);
		g2.drawLine(100, 0, 105, 5);
		g2.drawLine(105, 5, 100, 10);
	}
}
