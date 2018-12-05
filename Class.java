
package object;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Class extends JComponent {

	private int x, y;
	private int width = 130;
	private int nameBoxSize = 16;
	private int height = 64;

	private JTextArea name;
	private JTextArea attributes;
	private JTextArea operations;

	private String nameText = "Name";
	private String attributesText = "+ Attrributes";
	private String operationsText = "- Operations";

	private boolean parentRelated = false;
	private boolean childRelated = false;

	private Class child = null;
	private Class parent = null;
	
	Canvas rightPane;
	JPanel j = new JPanel();

	/**
	 * Initialize class box's left-hand corner x/y coordinates.
	 * 
	 * @author Bri Long
	 * @param x1 will be used as this classbox's left hand corner x coordinate
	 * @param y1 will be used as this class box's left hand corner y coordinate
	 **/
	public Class(int x1, int y1, Canvas rightPane) {
		x = x1;
		y = y1;
		this.rightPane = rightPane;
		rightPane.setLayout(null);
		name = new JTextArea(nameText);
		j.setLayout(null);
		j.setBackground(Color.RED);
		j.setBounds(x, y, width, height - 10);
		name.setBounds(0, 0, width, 18);
		name.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		attributes = new JTextArea(attributesText);
		attributes.setBounds(name.getX(), name.getY() + name.getHeight(), width, 18);
		attributes.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));

		operations = new JTextArea(operationsText);
		operations.setBounds(attributes.getX(), attributes.getY() + attributes.getHeight(), width, 18);
		operations.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		j.add(name);
		j.add(attributes);
		j.add(operations);

		name.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					name.setBounds(name.getX(), name.getY(), name.getWidth(), name.getHeight() + nameBoxSize);
					attributes.setBounds(attributes.getX(), name.getY() + name.getHeight(), attributes.getWidth(),
							attributes.getHeight());
					operations.setBounds(operations.getX(), attributes.getY() + attributes.getHeight(),
							operations.getWidth(), operations.getHeight());
					j.setSize(new Dimension(j.getWidth(), j.getHeight() + 16));
					height += 16;
					repaint();
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		attributes.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					attributes.setBounds(attributes.getX(), attributes.getY(), attributes.getWidth(),
							attributes.getHeight() + nameBoxSize);
					attributes.append("+ ");

					operations.setBounds(operations.getX(), attributes.getY() + attributes.getHeight(),
							operations.getWidth(), operations.getHeight());
					j.setSize(new Dimension(j.getWidth(), j.getHeight() + 16));
					height+=16;
					repaint();
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		operations.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					operations.setBounds(operations.getX(), operations.getY(), operations.getWidth(),
							operations.getHeight() + nameBoxSize);
					operations.append("- ");
					j.setSize(new Dimension(j.getWidth(), j.getHeight() + 16));
					height += 16;
					repaint();
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		rightPane.add(j);
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
		return name.getText();
	}

	/**
	 * Get this class box's attributes
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return this class box's attributes
	 **/
	public String getAttributes() {
		return attributes.getText();
	}

	/**
	 * Get this class box's operations
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return this class box's operations
	 **/
	public String getOperations() {
		return operations.getText();
	}

	public void setName(String name) {
		nameText = name;
		this.name.setText(nameText);
	}

	public void setAttributes(String attributes) {
		attributesText = attributes;
		this.attributes.setText(attributesText);
	}

	public void setOperations(String operations) {
		operationsText = operations;
		this.operations.setText(operationsText);
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
	 * Returns this class box's location.
	 * 
	 * @author Bri Long
	 * @return Point - location of left hand corner of this class box
	 **/
	public Point getLocation() {
		return new Point(x, y);
	}

	public void setLocation(int i, int z) {
		x = i;
		y = z;
		j.setLocation(x, y);
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

	public void delete() {
		name = null;
		attributes = null;
		operations = null;
		rightPane.remove(j);
		
	}
	public void paintClass(Graphics g) {
		super.paintComponent(g);

		g.drawRect(x, y + j.getHeight(), width - 1,
				height - name.getHeight() - attributes.getHeight() - operations.getHeight());
		g.setColor(Color.GRAY);
		g.fillRect(x, y + name.getHeight() + attributes.getHeight() + operations.getHeight(), width - 1,
				height - name.getHeight() - attributes.getHeight() - operations.getHeight());
	}

}