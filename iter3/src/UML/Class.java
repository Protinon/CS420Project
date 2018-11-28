
package UML;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Class extends JComponent {

	private int x, y;
	private int width = 126;
	private int height = 72;
	private int nameBoxSize = 24;
	private int attsBoxSize = 24;
	private int opsBoxSize = 24;
	private int stringMax = 18;
	
	private String name = "Name";
	private String attributes = "Attributes";
	private String operations = "Operations";
	
	private boolean parentRelated = false;
	private boolean childRelated = false;
		
	private Class child = null;
	private Class parent = null;

	/**
	 * Initialize class box's left-hand corner x/y coordinates.
	 * 
	 * @author Bri Long
	 * @param x1 will be used as this classbox's left hand corner x coordinate
	 * @param y1 will be used as this class box's left hand corner y coordinate
	 **/
	public Class(int x1, int y1) {
		x = x1;
		y = y1;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	/**
	 * Get this class box's name
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return this class box's name
	 **/
	public String getName() {
		return name;
	}

	/**
	 * Get this class box's attributes
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return this class box's attributes
	 **/
	public String getAttributes() {
		return attributes;
	}

	/**
	 * Get this class box's operations
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return this class box's operations
	 **/
	public String getOperations() {
		return operations;
	}

	/**
	 * Change this class box's name to a string of max length - 25.
	 * 
	 * @author Bri Long
	 * @param newName will be class box's new name
	 * @return void
	 **/
	public void setName(String newName) {
		if (newName.length() > stringMax) {
			newName = newName.substring(0, stringMax);
		}
		name = newName;
		repaint();
	}

	/**
	 * Change this class box's attributes to a string of max length - 25.
	 * 
	 * @author Bri Long
	 * @param newAtts will be class box's new attributes
	 * @return void
	 **/
	public void setAttributes(String newAtts) {
		if (newAtts.length() > stringMax) {
			newAtts = newAtts.substring(0, stringMax);
		}
		name = newAtts;
		repaint();
	}

	/**
	 * Change this class box's operations to a string of max length - 25.
	 * 
	 * @author Bri Long
	 * @param newOps will be class box's new operations
	 * @return void
	 **/
	public void setOperations(String newOps) {
		if (newOps.length() > stringMax) {
			newOps = newOps.substring(0, stringMax);
		}
		operations = newOps;
		repaint();
	}

	/**
	 * Check to see if this object contains the (x,y) coordinate formed from
	 * parameters.
	 * 
	 * @author Bri Long
	 * @param x2 will be used as x in (x,y) coordinate to be checked if contained in
	 *           this object
	 * @param y2 will be used as y in (x,y) coordinate to be checked if contained in
	 *           this object
	 * @return boolean true if the (x,y) coordinate is contained within the bounds
	 *         of this object, otherwise false
	 **/
	public boolean contains(int x2, int y2) {
		Rectangle r = new Rectangle(x, y, width, height);
		if (r.contains(x2, y2)) {
			return true;
		}
		return false;
	}

	/**
	 * Updates this class box's location so that the left-hand corner is now at the
	 * (x,y) coordinate givem by parameters.
	 * 
	 * @author Bri Long
	 * @param i will be used as x in (x,y) coordinate for object's left-hand corner
	 *          to be moved too
	 * @param j will be used as y in (x,y) coordinate for object's left hand corner
	 *          to be moved too
	 * @return void
	 **/
	public void setLocation(int i, int j) {
		x = i;
		y = j;
	}

	/**
	 * Returns this class box's location.
	 * 
	 * @author Bri Long
	 * @return Point - location of left hand corner of this class box
	 **/
	public Point getLocation() {
		return new Point(x, y);
	}

	/**
	 * Paint method for this class box, overwrites paintComponent.
	 * 
	 * @author Bri Long
	 * @param g Graphics object
	 * @return void
	 **/
	protected void paintClass(Graphics g) {
		super.paintComponent(g);

		// draw title box
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, nameBoxSize);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, nameBoxSize);
		g.drawString(name, x + 2, y + nameBoxSize - 6);

		// draw attributes box
		g.setColor(Color.WHITE);
		g.fillRect(x, y + (attsBoxSize * 2), width, height - (attsBoxSize * 2));
		g.setColor(Color.BLACK);
		g.drawRect(x, y + (attsBoxSize * 2), width, height - (attsBoxSize * 2));
		g.drawString(attributes, x + 2, y + attsBoxSize + attsBoxSize - 6);

			// draw operations box
		g.setColor(Color.WHITE);
		g.fillRect(x, y + (opsBoxSize * 2), width, height - (opsBoxSize * 2));
		g.setColor(Color.BLACK);
		g.drawRect(x, y + (opsBoxSize * 2), width, height - (opsBoxSize * 2));
		g.drawString(operations, x + 2, y + opsBoxSize + opsBoxSize + opsBoxSize - 6);

		// draw box around 3 subboxes ^^
		g.drawRect(x, y, width, height);
	}
	
	public boolean isAParent() {
		return parentRelated;
	}
	
	public boolean isAChild() {
		return childRelated;
	}
	
	public void setParentRelated(boolean related) {
		this.parentRelated = related;
	}
	
	public void setChildRelated(boolean related) {
		this.childRelated = related;
	}
	
	public Class getChild() {
		return child;
	}
	
	public Class getParent() {
		return parent;
	}
	
	public void setChild(Class child) {
		this.child = child;
	}
	
	public void setParent(Class parent) {
		this.parent = parent;
	}
}