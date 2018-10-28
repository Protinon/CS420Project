package UML;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Relationship.Relationship;
import Relationship.Generalization;

public class Controllerish extends JPanel {
	private static final long serialVersionUID = 1L;
	
	MouseAdapter currentListener = null;

	JButton selectButton = new JButton("Select");
	JButton pointButton = new JButton("Point");
	JButton deleteButton = new JButton("Delete");
	JButton commentButton = new JButton("Comment");
	JButton classButton = new JButton("Class");
	JButton aggregationButton = new JButton("Aggregation");
	JButton dependencyButton = new JButton("Dependency");
	JButton generalizationButton = new JButton("Generalization");
	JButton associationButton = new JButton("Association");
	JButton compositionButton = new JButton("Composition");
	
	ArrayList<UMLClass> uClasses;
	ArrayList<Relationship> relations;

	ArrayList<Rectangle> pointRects;
	ArrayList<Rectangle> classBoxes;
	ArrayList<Rectangle> commentBoxes;
	ArrayList<Rectangle> associatedPoints;
	ArrayList<Rectangle> associatedClasses;
	ArrayList<Rectangle> aggregatedPoints;
	ArrayList<Rectangle> aggregatedClasses;
	ArrayList<Rectangle> dependedPoints;
	ArrayList<Rectangle> dependedClasses;
	ArrayList<Rectangle> generalizedPoints;
	ArrayList<Rectangle> generalizedClasses;
	ArrayList<Rectangle> compositedPoints;
	ArrayList<Rectangle> compositedClasses;

	int pointLimit = 50;
	int classBoxLimit = 20;
	int commentBoxLimit = 20;

	public Controllerish(JPanel left) {
		
		uClasses = new ArrayList<UMLClass>();
		relations = new ArrayList<Relationship>();

		generalizedClasses = new ArrayList<Rectangle>();
		classBoxes = new ArrayList<Rectangle>();
		commentBoxes = new ArrayList<Rectangle>();
		associatedPoints = new ArrayList<Rectangle>();
		associatedClasses = new ArrayList<Rectangle>();
		pointRects = new ArrayList<Rectangle>();
		generalizedPoints = new ArrayList<Rectangle>();
		dependedPoints = new ArrayList<Rectangle>();
		dependedClasses = new ArrayList<Rectangle>();
		aggregatedPoints = new ArrayList<Rectangle>();
		aggregatedClasses = new ArrayList<Rectangle>();
		aggregatedPoints = new ArrayList<Rectangle>();
		compositedPoints = new ArrayList<Rectangle>();
		compositedClasses = new ArrayList<Rectangle>();

		setBackground(Color.WHITE);

		pointButton.setBounds(0, 0, 150, 25);
		classButton.setBounds(0, 25, 150, 25);
		associationButton.setBounds(0, 50, 150, 25);
		generalizationButton.setBounds(0, 75, 150, 25);
		dependencyButton.setBounds(0, 100, 150, 25);
		aggregationButton.setBounds(0, 125, 150, 25);
		compositionButton.setBounds(0, 150, 150, 25);
		commentButton.setBounds(0, 175, 150, 25);
		deleteButton.setBounds(0, 200, 150, 25);
		selectButton.setBounds(0, 225, 150, 25);

		left.add(pointButton);
		left.add(classButton);
		left.add(associationButton);
		left.add(generalizationButton);
		left.add(dependencyButton);
		left.add(aggregationButton);
		left.add(compositionButton);
		left.add(commentButton);
		left.add(deleteButton);
		left.add(selectButton);
		
		addMouseMotionListener(new MouseAdapter() {
			
			@Override
		    public void mouseDragged(MouseEvent e) {
		        repaint();
		    }
		});

		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				
				UMLMouseListener listener = new UMLMouseListener();
				uClasses.get(0).addMouseListener(listener);
				uClasses.get(0).addMouseMotionListener(listener);
				
				/*
				MouseAdapter listener = new MouseAdapter() {
					
					Rectangle selectedShape;
					
					@Override
					public void mousePressed(MouseEvent e) {
						System.out.println("Pressed");
						Point p1 = new Point(e.getX(), e.getY());
						
						for (Rectangle p : pointRects) 
						{
							if (p.contains(p1)) 
							{
								selectedShape = p;
							}
						}
						for (Rectangle r : classBoxes) 
						{
							if (r.contains(p1)) 
							{
								selectedShape = r;
							}
						}

						for (Rectangle p : commentBoxes) 
						{
							if (p.contains(p1.x, p1.y)) 
							{
								selectedShape = p;
							}
						}
					}
					
					@Override
					public void mouseDragged(MouseEvent e) {
						if (selectedShape.contains(e.getX(), e.getY())) {
							System.out.println("dragged");
							int dx = e.getX() - p1.x;
							int dy = e.getY() - p1.y;
							selectedShape.setLocation(selectedShape.x + dx, selectedShape.y + dy);
							p1 = e.getPoint();
							repaint();
						}
					}
				};

				
				//removeMouseMotionListener(currentMotionListener);
				removeMouseListener(currentListener);
				//addMouseMotionListener(motionListener);
				addMouseListener(listener);
				//currentMotionListener = motionListener;
				currentListener = listener;
				*/
			}
		});

		pointButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				MouseAdapter listener = new MouseAdapter() {
					
					@Override
					public void mousePressed(MouseEvent e) {
						Point p1 = new Point(e.getX(), e.getY());
						
						if (pointRects.size() < pointLimit) 
						{
							pointRects.add(new Rectangle(p1.x, p1.y, 5, 5));
							repaint();
						}
					}
				};
				removeMouseListener(currentListener);
				addMouseListener(listener);
				currentListener = listener;
			}
		});

		classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MouseAdapter listener = new MouseAdapter() {
					
					@Override
					public void mousePressed(MouseEvent e) {
						Point p1 = new Point(e.getX(), e.getY());
						
						if (pointRects.size() < pointLimit) 
						{
							if (classBoxes.size() < classBoxLimit) 
							{
								UMLClass c = new UMLClass(p1.x, p1.y);
								String title = JOptionPane.showInputDialog("Set title", "Title");
						        String att = JOptionPane.showInputDialog("Set attributes", "Attributes");
						        c.setInfo(title,  att);
								uClasses.add(c);
								Controllerish.this.add(c);
								repaint();
							}
						}
					}
				};
				removeMouseListener(currentListener);
				addMouseListener(listener);
				currentListener = listener;
			}
		});

		commentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MouseAdapter listener = new MouseAdapter() {
					
					@Override
					public void mousePressed(MouseEvent e) {
						Point p1 = new Point(e.getX(), e.getY());
						
						if (commentBoxes.size() < commentBoxLimit) 
						{
							commentBoxes.add(new Rectangle(p1.x, p1.y, 125, 50));
							repaint();
						}
					}
				};
				removeMouseListener(currentListener);
				addMouseListener(listener);
				currentListener = listener;
			}
		});

		aggregationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MouseAdapter listener = new MouseAdapter() {
					
					@Override
					public void mousePressed(MouseEvent e) {
						Point p1 = new Point(e.getX(), e.getY());
						
						for (Rectangle p2 : pointRects) 
						{
							if (p2.contains(p1)) 
							{
								aggregatedPoints.add(p2);
								repaint();
							}
						}
					}
				};
				removeMouseListener(currentListener);
				addMouseListener(listener);
				currentListener = listener;
			}
		});

		generalizationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MouseAdapter listener = new MouseAdapter() {
					
					UMLClass c1 = null;
					
					@Override
					public void mousePressed(MouseEvent e) {
						Point p1 = new Point(e.getX(), e.getY());
						
						for (UMLClass c : uClasses) 
						{
							if (c.getBounds().contains(p1.x, p1.y)) 
							{
								if (c1 == null) {
									c1 = c;
								}
								else {
									Generalization gen = new Generalization(c1, c);
									relations.add(gen);
									Controllerish.this.add(gen);
									c1 = null;
								}
								repaint();
							}
						}
						
						/*
						for (Rectangle p2 : pointRects) 
						{
							if (p2.contains(p1.x, p1.y)) 
							{
								associatedPoints.add(p2);
								repaint();
							}
						}
						
						for (Rectangle p3 : classBoxes) 
						{
							if (p3.contains(p1.x, p1.y)) 
							{
								generalizedClasses.add(p3);
								repaint();
							}
						}
						*/
					}
				};
				removeMouseListener(currentListener);
				addMouseListener(listener);
				currentListener = listener;
			}
		});

		dependencyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MouseAdapter listener = new MouseAdapter() {
					
					@Override
					public void mousePressed(MouseEvent e) {
						Point p1 = new Point(e.getX(), e.getY());
						
						for (Rectangle p2 : pointRects) 
						{
							if (p2.contains(p1)) 
							{
								dependedPoints.add(p2);
								repaint();
							}
						}
					}
				};
				removeMouseListener(currentListener);
				addMouseListener(listener);
				currentListener = listener;
			}
		});

		associationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MouseAdapter listener = new MouseAdapter() {
					
					@Override
					public void mousePressed(MouseEvent e) {
						Point p1 = new Point(e.getX(), e.getY());
						
						for (Rectangle p2 : pointRects) 
						{
							if (p2.contains(p1.x, p1.y)) 
							{
								associatedPoints.add(p2);
								repaint();
							}
						}
						for (Rectangle p3 : classBoxes) 
						{
							if (p3.contains(p1.x, p1.y)) 
							{
								associatedClasses.add(p3);
								repaint();
							}
						}
					}
				};
				removeMouseListener(currentListener);
				addMouseListener(listener);
				currentListener = listener;
			}
		});

		compositionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MouseAdapter listener = new MouseAdapter() {
					
					@Override
					public void mousePressed(MouseEvent e) {
						Point p1 = new Point(e.getX(), e.getY());
						
						for (Rectangle p2 : pointRects) 
						{
							if (p2.contains(p1)) 
							{
								compositedPoints.add(p2);
								repaint();
							}
						}
					}
				};
				removeMouseListener(currentListener);
				addMouseListener(listener);
				currentListener = listener;
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				MouseAdapter listener = new MouseAdapter() {
					
					@Override
					public void mousePressed(MouseEvent e) {
						
						Rectangle remover = null;
						Rectangle remover2 = null;
						Rectangle remover3 = null;
						
						Point p1 = new Point(e.getX(), e.getY());
						
						for (Rectangle r : pointRects) 
						{
							if (r.contains(p1.x, p1.y)) 
							{
								remover = r;
							}
						}

						for (int i = associatedPoints.size() - 1; i >= 0; --i) 
						{
							if (associatedPoints.size() % 2 != 0) 
							{
								associatedPoints.remove(associatedPoints.size() - 1);
							}

							if (associatedPoints.get(i).contains(p1.x, p1.y)) 
							{
								if (i % 2 == 0) 
								{
									associatedPoints.remove(i + 1);
									associatedPoints.remove(i);
								} else 
								{
									associatedPoints.remove(i);
									associatedPoints.remove(i - 1);
									i--;
								}
							}
						}

						for (Rectangle r : classBoxes) 
						{
							if (r.contains(p1.x, p1.y)) 
							{
								remover2 = r;
							}
						}

						for (int i = associatedClasses.size() - 1; i >= 0; --i) 
						{
							if (associatedClasses.size() % 2 != 0) 
							{
								associatedClasses.remove(associatedClasses.size() - 1);
							}
							if (associatedClasses.get(i).contains(p1.x, p1.y))
							{
								if (i % 2 == 0) 
								{
									associatedClasses.remove(i + 1);
									associatedClasses.remove(i);
								} else 
								{
									associatedClasses.remove(i);
									associatedClasses.remove(i - 1);
									i--;
								}
							}
						}

						for (Rectangle r : commentBoxes) {
							if (r.contains(p1.x, p1.y)) {
								remover3 = r;
							}
						}
						
						pointRects.remove(remover);
						classBoxes.remove(remover2);
						commentBoxes.remove(remover3);
						repaint();
					}
				};
				removeMouseListener(currentListener);
				addMouseListener(listener);
				currentListener = listener;
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLACK);
		
		//for (UMLClass x : uClasses) {
		//	x.paintComponent(g);
		//}
		
		//for (Relationship x : relations) {
		//	Generalization y = (Generalization)x;
		//	y.paintComponent(g);
		//}
		
/*
		if (associatedClasses.size() > 1) 
		{
			for (int i = 0; i < associatedClasses.size() - 1; i += 2) 
			{
				if ((associatedClasses.get(i).x < associatedClasses.get(i + 1).x
						&& associatedClasses.get(i).x + 200 > associatedClasses.get(i + 1).x)
						|| (associatedClasses.get(i).x > associatedClasses.get(i + 1).x
								&& associatedClasses.get(i + 1).x + 200 > associatedClasses.get(i).x)) 
				{
				
					if (associatedClasses.get(i).y > associatedClasses.get(i + 1).y) 
					{
						g2.drawLine(associatedClasses.get(i).x + 100, associatedClasses.get(i).y,
								associatedClasses.get(i + 1).x + 100, associatedClasses.get(i + 1).y + 200);
					} else 
					{
						g2.drawLine(associatedClasses.get(i).x + 100, associatedClasses.get(i).y + 200,
								associatedClasses.get(i + 1).x + 100, associatedClasses.get(i + 1).y);
					}
				}
				
				if (associatedClasses.get(i).x < associatedClasses.get(i + 1).x
						&& associatedClasses.get(i).x + 200 < associatedClasses.get(i + 1).x) 
				{
					g2.drawLine(associatedClasses.get(i).x + 200, associatedClasses.get(i).y + 100,
							associatedClasses.get(i + 1).x, associatedClasses.get(i + 1).y + 100);
				}
				
				if (associatedClasses.get(i).x > associatedClasses.get(i + 1).x
						&& associatedClasses.get(i + 1).x + 200 < associatedClasses.get(i).x) 
				{
					g2.drawLine(associatedClasses.get(i).x, associatedClasses.get(i).y + 100,
							associatedClasses.get(i + 1).x + 200, associatedClasses.get(i + 1).y + 100);

				}
			}
		}

		if (generalizedClasses.size() > 1) 
		{
			for (int i = 0; i < generalizedClasses.size() - 1; i += 2) 
			{
				if ((generalizedClasses.get(i).x < generalizedClasses.get(i + 1).x
						&& generalizedClasses.get(i).x + 200 > generalizedClasses.get(i + 1).x)
						|| (generalizedClasses.get(i).x > generalizedClasses.get(i + 1).x
								&& generalizedClasses.get(i + 1).x + 200 > generalizedClasses.get(i).x)) 
				{
					if (generalizedClasses.get(i).y > generalizedClasses.get(i + 1).y) 
					{
						g2.drawLine(generalizedClasses.get(i).x + 100, generalizedClasses.get(i).y,
								generalizedClasses.get(i + 1).x + 100, generalizedClasses.get(i + 1).y + 210);

					} else 
					{
						g2.drawLine(generalizedClasses.get(i).x + 100, generalizedClasses.get(i).y + 200,
								generalizedClasses.get(i + 1).x + 100, generalizedClasses.get(i + 1).y);

					}
				}
				
				if (generalizedClasses.get(i).x < generalizedClasses.get(i + 1).x
						&& generalizedClasses.get(i).x + 200 < generalizedClasses.get(i + 1).x) {
					g2.drawLine(generalizedClasses.get(i).x + 200, generalizedClasses.get(i).y + 100,
							generalizedClasses.get(i + 1).x, generalizedClasses.get(i + 1).y + 100);
				}
				
				if (generalizedClasses.get(i).x > generalizedClasses.get(i + 1).x
						&& generalizedClasses.get(i + 1).x + 200 < generalizedClasses.get(i).x) 
				{
					g2.drawLine(generalizedClasses.get(i).x, generalizedClasses.get(i).y + 100,
							generalizedClasses.get(i + 1).x + 200, generalizedClasses.get(i + 1).y + 100);

				}
			}
		}

		if (associatedPoints.size() > 1) 
		{
			for (int i = 0; i < associatedPoints.size() - 1; i += 2) 
			{
				g2.drawLine((int) associatedPoints.get(i).getCenterX(), (int) associatedPoints.get(i).getCenterY(),
						(int) associatedPoints.get(i + 1).getCenterX(), (int) associatedPoints.get(i + 1).getCenterY());
			}

		}

		for (Rectangle point : pointRects) 
		{
			g2.fillOval(point.x, point.y, 5, 5);
		}

		for (Rectangle r : classBoxes) 
		{
			g2.setColor(Color.WHITE);
			g2.fill(r);
			g2.setColor(Color.BLACK);
			g2.draw(r);
		}

		for (Rectangle point : commentBoxes) 
		{
			g2.setStroke(new BasicStroke(3));
			g2.drawLine(point.x, point.y, point.x, point.y + 50);
			g2.drawLine(point.x, point.y, point.x + 100, point.y);
			g2.setStroke(new BasicStroke(2));
			g2.drawLine(point.x, point.y + 50, point.x + 125, point.y + 50);
			g2.drawLine(point.x + 125, point.y + 50, point.x + 125, point.y + 25);
			g2.drawLine(point.x + 100, point.y, point.x + 125, point.y + 25);
			g2.drawLine(point.x + 100, point.y + 25, point.x + 100, point.y);
			g2.drawLine(point.x + 125, point.y + 25, point.x + 100, point.y + 25);

		}
	*/
	}
}