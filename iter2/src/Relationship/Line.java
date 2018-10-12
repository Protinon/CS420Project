package Relationship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Relationship {
	
	public Line(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
   
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
   
        g2.setColor(Color.BLACK);
        g2.drawLine(0, 0, getWidth(), getHeight());
    }
}
