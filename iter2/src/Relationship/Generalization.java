package Relationship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import UML.UMLClass;

@SuppressWarnings("serial")
public class Generalization extends Relationship {
	
	public Generalization(UMLClass uClass1, UMLClass uClass2) {
		super(uClass1, uClass2);
	}

	@Override
	protected void paintLine(Graphics2D g2, int x1, int y1, int x2, int y2) {
		g2.setColor(Color.BLUE);
		g2.drawLine(x1, y1, x2, y2);
		g2.setColor(Color.BLACK);
	}
}