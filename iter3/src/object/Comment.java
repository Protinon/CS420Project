package object;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Comment extends JComponent{
	private int x, y;
	private int width = 150, height = 25;

	private JTextArea data;

	private String dataString = "Comment";

	private JPanel j = new JPanel();
	private Canvas rightPane;

	/**
	 * Initialize this comment's left hand corner to the (x,y) coordinate formed by
	 * parameters.
	 * 
	 * @author Bri Long
	 * @param x1 will be used as x in (x,y) coordinate to initialize object
	 * @param y1 will be used as y in (x,y) coordinate to initialize object
	 **/
	public Comment(int x1, int y1, Canvas rightPane) {
		this.x = x1;
		this.y = y1;
		this.rightPane = rightPane;
		j.setLayout(null);
		j.setBounds(x, y, width - 25, height);
		rightPane.setLayout(null);
		data = new JTextArea(dataString);
		data.setLineWrap(true);
		data.setWrapStyleWord(true);
		
		data.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					data.setBounds(data.getX(), data.getY(), data.getWidth() - 25, data.getHeight() + 16);
					j.setSize(new Dimension(j.getWidth() -25, j.getHeight() + 16));
					height += 16;
					repaint();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

 
		data.setBounds(0, 0, width - 25, height);
		data.setOpaque(false);
		j.setOpaque(false);
		j.add(data);
		rightPane.add(j);
		repaint();
	}

	/**
	 * Sets this comment object's data.
	 * 
	 * @author Bri Long
	 * @param
	 * @return void
	 **/
	public void setData(String data) {
		dataString = data;
		this.data.setText(dataString);
	}

	/**
	 * Returns this comment object's width.
	 * 
	 * @author Bri Long
	 * @return int - the length of the comment object
	 **/
	public int getWidth() {
		return width;
	}

	/**
	 * Returns this comment object's height.
	 * 
	 * @author Bri Long
	 * @return int - the height of the comment object
	 **/
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
		Rectangle r = new Rectangle(x, y, width, height);
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
		super.paintComponent(g);
		g.drawLine(x, y, x, y + height);
		g.drawLine(x, y, x + (width - 10), y);
		g.drawLine(x, y + height, x + width, y + height);
		g.drawLine(x + width, y + height, x + width, y + 10);
		g.drawLine(x + (width - 10), y, x + width, y + 10);
		g.drawLine(x + (width - 10), y + 10, x + (width - 10), y);
		g.drawLine(x + width, y + 10, x + (width - 10), y + 10);
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
	public void setLocation(int i, int z) {
		x = i;
		y = z;
		j.setLocation(new Point(x,y));
	}
}
