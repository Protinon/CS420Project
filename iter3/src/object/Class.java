
package object;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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
	private String attributesText = "+ Attributes";
	private String operationsText = "- Operations";

	private boolean parentRelated = false;
	private boolean childRelated = false;

	private ArrayList<Class> child = new ArrayList<Class>();
	private ArrayList<Class> parent = new ArrayList<Class>();
	
	Canvas rightPane;
	JPanel j;

	/**
	 * Initialize class box's left-hand corner x/y coordinates.
	 * 
	 * @author Bri Long
	 * @param x1 will be used as this classbox's left hand corner x coordinate
	 * @param y1 will be used as this class box's left hand corner y coordinate
	 **/
	public Class(int x1, int y1, Canvas rightPane) {
		this.x = x1;
		this.y = y1;
		this.rightPane = rightPane;
		
		name = new JTextArea(nameText);
		attributes = new JTextArea(attributesText);
		operations = new JTextArea(operationsText);
		j = new JPanel();
		
		rightPane.setLayout(null);
		
		j.setLayout(null);
		j.setBounds(x, y, width, height - 10);
		
		name.setBounds(0, 0, width, 18);
		name.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		attributes.setBounds(name.getX(), name.getY() + name.getHeight(), width, 18);
		attributes.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));

		operations.setBounds(attributes.getX(), attributes.getY() + attributes.getHeight(), width, 18);
		operations.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		
		j.add(name);
		j.add(attributes);
		j.add(operations);
		
		rightPane.add(j);


		name.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					name.setBounds(name.getX(), name.getY(), name.getWidth(), name.getHeight() + nameBoxSize);
					attributes.setBounds(attributes.getX(), name.getY() + name.getHeight(), attributes.getWidth(),
							attributes.getHeight());
					operations.setBounds(operations.getX(), attributes.getY() + attributes.getHeight(),
							operations.getWidth(), operations.getHeight());
					j.setSize(new Dimension(j.getWidth(), name.getHeight() + attributes.getHeight() + operations.getHeight()));
					height = j.getHeight() + 10 + 10;
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
					j.setSize(new Dimension(j.getWidth(),name.getHeight() + attributes.getHeight() + operations.getHeight()));
					height = j.getHeight() + 10;
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
		if(name != null) {
			nameText = name.getText();
		}
		return nameText;
	}

	/**
	 * Get this class box's attributes
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return this class box's attributes
	 **/
	public String getAttributes() {
		if(attributes!= null) {
		attributesText =  attributes.getText();
	}
		return attributesText;
	}

	/**
	 * Get this class box's operations
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return this class box's operations
	 **/
	public String getOperations() {
		if(operations != null) {
			operationsText = operations.getText();
		}
		return operationsText;
	}

	public void setName(String name) {
		nameText = name;
		this.name.setText(nameText);
	}

	public void setAttributes(String attributes) {
		attributesText = attributes;
		this.attributes.setText("+ " + attributesText);
	}

	public void setOperations(String operations) {
		operationsText = operations;
		this.operations.setText("- " + operationsText);
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
		return (child.size() != 0);
	}

	public boolean isAChild() {
		return (parent.size() != 0);
	}

	public void setParentRelated() {
		this.parentRelated = (child.size() != 0);
	}

	public void setChildRelated() {
		this.childRelated = (parent.size() != 0);
	}

	public ArrayList<Class> getChildren() {
		return child;
	}

	public ArrayList<Class> getParents() {
		return parent;
	}

	public void setChild(Class child) {
		this.child.add(child);
	}

	public void setParent(Class parent) {
		this.parent.add(parent);
	}
	
	public void removeChild(Class ch) {
		this.child.remove(ch);
	}
	
	public void removeParent(Class p) {
		this.parent.remove(p);
	}

	public void delete() {
		nameText = name.getText();
		name = null;
		attributesText = attributes.getText();
		attributes = null;
		operationsText = operations.getText();
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
		
		g.setColor(Color.BLACK);
	}
	
	public JTextArea getNameTextBox() {
		return name;
	}
	
	public JTextArea getAttributesTextBox() {
		return attributes;
	}
	
	public JTextArea getOperationsTextBox() {
		return operations;
	}
}