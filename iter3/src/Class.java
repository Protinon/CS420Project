
package object;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Class extends JComponent {

	private int x, y;
	private int width = 150;
	private int height = 72;
	private int nameBoxSize = 24;
	private int attsBoxSize = 24;
	private int opsBoxSize = 24;
	private int stringMax = 21;

	private String name = "Name";
	private String attributes = "Attributes";
	private String attributes2 = "";
	private String attributes3 = "";

	private String operations = "Operations";
	private String operations2 = "";
	private String operations3 = "";

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
		return nameBoxSize + attsBoxSize + opsBoxSize;
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
		int index = 0;
		for (int i = 0; i < newName.length(); ++i) {
			index = index + 1;
			if (index > stringMax * 2) {
				break;
			} else {
				if (i == newName.length() - 1) {
					if (index <= stringMax) {
						name = newName;
					} else {
						name = newName.substring(0, stringMax);
					}
				}
			}
		}

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
		int index = 0;
		for (int i = 0; i < newAtts.length(); ++i) {
			index = index + 1;
			if (index > stringMax * 3) {
				break;
			} else {
				if (i == newAtts.length() - 1) {
					if (index <= stringMax) {
						attributes = newAtts;
						attributes2 = "";
						attributes3 = "";
					} else if (index <= stringMax * 2) {
						attributes = newAtts.substring(0, stringMax);
						attributes2 = newAtts.substring(stringMax);
						attributes3 = "";
						attsBoxSize = nameBoxSize * 2;
					} else if (index <= stringMax * 3) {
						attributes = newAtts.substring(0, stringMax);
						attributes2 = newAtts.substring(stringMax, stringMax * 2);
						attributes3 = newAtts.substring(stringMax * 2);
						attsBoxSize = nameBoxSize * 3;
					}
				}
			}
		}
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
		int index = 0;
		for (int i = 0; i < newOps.length(); ++i) {
			index = index + 1;
			if (index > stringMax * 3) {
				break;
			} else {
				if (i == newOps.length() - 1) {
					if (index <= stringMax) {
						operations = newOps;
						operations2 = "";
						operations3 = "";
					} else if (index <= stringMax * 2) {
						operations = newOps.substring(0, stringMax);
						operations2 = newOps.substring(stringMax);
						opsBoxSize = nameBoxSize * 2;
						operations3 = "";
					} else if (index <= stringMax * 3) {
						operations = newOps.substring(0, stringMax);
						operations2 = newOps.substring(stringMax, stringMax * 2);
						operations3 = newOps.substring(stringMax * 2);
						opsBoxSize = nameBoxSize * 3;
					}
				}
			}
		}
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

		g.drawString(name, x + 2, y + nameBoxSize - 6);
		g.drawRect(x, y, width, nameBoxSize);
		
		if (attsBoxSize == nameBoxSize ) {
			g.drawString(attributes, x + 2, y + nameBoxSize + attsBoxSize - 6);
		}
		
		if (attsBoxSize == nameBoxSize * 2) {
			g.drawString(attributes, x + 2, y + nameBoxSize + nameBoxSize - 6);
			g.drawString(attributes2, x + 2, y + nameBoxSize + attsBoxSize - 6);
		}
		
		if (attsBoxSize == nameBoxSize*3) {
			g.drawString(attributes, x+2, y + nameBoxSize + nameBoxSize - 6);
			g.drawString(attributes2, x + 2, y + nameBoxSize + nameBoxSize + nameBoxSize - 6);
			g.drawString(attributes3, x + 2, y + nameBoxSize + nameBoxSize + nameBoxSize + nameBoxSize- 6);
		}
		
		g.drawRect(x, y + nameBoxSize, width, attsBoxSize);
		
		if (opsBoxSize == nameBoxSize ) {
			g.drawString(operations, x + 2, y + nameBoxSize + attsBoxSize + opsBoxSize - 6);
		}
		
		if (opsBoxSize == nameBoxSize * 2) {
			g.drawString(operations, x + 2, y + nameBoxSize + attsBoxSize + nameBoxSize - 6);
			g.drawString(operations2, x + 2, y + nameBoxSize + attsBoxSize + nameBoxSize + nameBoxSize- 6);
		}
		
		if (opsBoxSize == nameBoxSize*3) {
			g.drawString(operations, x+2, y + nameBoxSize + attsBoxSize + nameBoxSize - 6);
			g.drawString(operations2, x + 2, y + nameBoxSize + attsBoxSize + nameBoxSize + nameBoxSize - 6);
			g.drawString(operations3, x + 2, y + nameBoxSize + attsBoxSize + nameBoxSize + nameBoxSize + nameBoxSize- 6);
		}
		
		g.drawRect(x, y + nameBoxSize + attsBoxSize, width, opsBoxSize);

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