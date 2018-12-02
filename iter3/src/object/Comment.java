package object;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Comment {
	private int x, y;
	private int width = 125, height = 50;

	/**
	 * Initialize this comment's left hand corner to the (x,y) coordinate formed by
	 * parameters.
	 * 
	 * @author Bri Long
	 * @param x1 will be used as x in (x,y) coordinate to initialize object
	 * @param y1 will be used as y in (x,y) coordinate to initialize object
	 **/
	public Comment(int x1, int y1) {
		this.x = x1;
		this.y = y1;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	/**
	 * Returns this comment object's location.
	 * 
	 * @author Bri Long
	 * @return Point - location of left hand corner of this comment object
	 **/
	public Point getLocation() {
		return new Point(x, y);
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
	public boolean contains(Point p) {
		Rectangle r = new Rectangle(x, y, 125, 50);
		if (r.contains(p.x, p.y)) {
			return true;
		}
		return false;
	}

	/**
	 * Paint method for this comment object, overwrites paintComponent.
	 * 
	 * @author Bri Long
	 * @param g Graphics object
	 * @return void
	 **/
	public void paintComment(Graphics g) {
		g.drawLine(x, y, x, y + height);
		g.drawLine(x, y, x + (width - (height - 25)), y);
		g.drawLine(x, y + height, x + width, y + height);
		g.drawLine(x + width, y + height, x + width, y + (height - 25));
		g.drawLine(x + (width - (height - 25)), y, x + width, y + (height - 25));
		g.drawLine(x + (width - (height - 25)), y + (height - 25), x + (width - (height - 25)), y);
		g.drawLine(x + width, y + (height - 25), x + (width - (height - 25)), y + (height - 25));
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
}
