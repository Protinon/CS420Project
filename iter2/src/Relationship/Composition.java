package Relationship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Composition extends Relationship {

	public Composition(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);
		g2.drawLine(5, 5, 100, 5);

		int[] arg0 = { 100, 105, 110, 105 };
		int[] arg1 = { 5, 0, 5, 10 };
		g2.drawPolygon(arg0, arg1, 4);
		g2.fillPolygon(arg0, arg1, 4);
	}
}
