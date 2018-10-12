package Relationship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Dependency extends Relationship {
	
	public Dependency(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);
		for (int i = 5; i <= 100; i += 10) {
			g2.drawLine(i, 5, i + 5, 5);
		}

		g2.drawLine(100, 0, 100, 10);
		g2.drawLine(100, 0, 105, 5);
		g2.drawLine(105, 5, 100, 10);
	}
}
