package Relationship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import UML.UMLClass;

public class Generalization extends Relationship {
	
	public Generalization(UMLClass uClass1, UMLClass uClass2) {
		super(uClass1, uClass2);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Rectangle bounds = super.getBounds();
		System.out.println("Bounds: " + bounds);
		
		g2.setColor(Color.BLACK);
		//g2.drawLine(bounds.x, bounds.y, bounds.width, bounds.height);
		g2.drawLine(0,  0, bounds.width, bounds.height);
	}
}
