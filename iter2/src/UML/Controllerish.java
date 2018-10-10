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
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Controllerish extends JPanel {
	private static final long serialVersionUID = 1L;

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

	boolean aSelectedShape = false;
	boolean selected = false;
	boolean pointed = false;
	boolean deletePressed = false;
	boolean classed = false;
	boolean commented = false;
	boolean aggregated = false;
	boolean depended = false;
	boolean associated = false;
	boolean composited = false;
	boolean generalized = false;

	Point p1;

	Rectangle selectedShape;

	int pointLimit = 50;
	int classBoxLimit = 20;
	int commentBoxLimit = 20;

	public Controllerish(JPanel left) {

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

		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {

				pointed = false;
				deletePressed = false;
				classed = false;
				commented = false;
				aggregated = false;
				depended = false;
				associated = false;
				composited = false;
				generalized = false;
				selected = true;

			}
		});

		pointButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {

				pointed = true;
				deletePressed = false;
				classed = false;
				commented = false;
				aggregated = false;
				depended = false;
				associated = false;
				composited = false;
				generalized = false;
				selected = false;

			}
		});

		classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pointed = false;
				deletePressed = false;
				classed = true;
				commented = false;
				aggregated = false;
				depended = false;
				associated = false;
				composited = false;
				generalized = false;
				selected = false;

			}
		});

		commentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pointed = false;
				deletePressed = false;
				classed = false;
				commented = true;
				aggregated = false;
				depended = false;
				associated = false;
				composited = false;
				generalized = false;
				selected = false;

			}
		});

		aggregationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pointed = false;
				deletePressed = false;
				classed = false;
				commented = false;
				aggregated = true;
				depended = false;
				associated = false;
				composited = false;
				generalized = false;
				selected = false;

			}
		});

		generalizationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pointed = false;
				deletePressed = false;
				classed = false;
				commented = false;
				aggregated = false;
				depended = false;
				associated = false;
				composited = false;
				generalized = true;
				selected = false;

			}
		});

		dependencyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pointed = false;
				deletePressed = false;
				classed = false;
				commented = false;
				aggregated = false;
				depended = true;
				associated = false;
				composited = false;
				generalized = false;
				selected = false;

			}
		});

		associationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pointed = false;
				deletePressed = false;
				classed = false;
				commented = false;
				aggregated = false;
				depended = false;
				associated = true;
				composited = false;
				generalized = false;
				selected = false;

			}
		});

		compositionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pointed = false;
				deletePressed = false;
				classed = false;
				commented = false;
				aggregated = false;
				depended = false;
				associated = false;
				composited = true;
				generalized = false;
				selected = false;

			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {

				pointed = false;
				deletePressed = true;
				classed = false;
				commented = false;
				aggregated = false;
				depended = false;
				associated = false;
				composited = false;
				generalized = false;
				selected = false;

			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {

				if (aSelectedShape == true) {
					if (selectedShape.contains(e.getX(), e.getY())) {
						int dx = e.getX() - p1.x;
						int dy = e.getY() - p1.y;
						selectedShape.setLocation(selectedShape.x + dx, selectedShape.y + dy);
						p1 = e.getPoint();
						repaint();
					}
				}

			}
		});

		this.addMouseListener(new MouseAdapter() {

			Rectangle remover;
			Rectangle remover2;
			Rectangle remover3;
			
			@Override
			public void mousePressed(MouseEvent e) {

				p1 = new Point(e.getX(), e.getY());

				if (pointed == true) 
				{
					if (pointRects.size() < pointLimit) 
					{
						pointRects.add(new Rectangle(p1.x, p1.y, 5, 5));
						repaint();
					}
				}
				
				if (deletePressed == true) 
				{
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

				if (classed == true) 
				{
					if (classBoxes.size() < classBoxLimit) 
					{
						classBoxes.add(new Rectangle(p1.x, p1.y, 200, 200));
						repaint();
					}
				}

				if (commented == true) 
				{
					if (commentBoxes.size() < commentBoxLimit) 
					{
						commentBoxes.add(new Rectangle(p1.x, p1.y, 125, 50));
						repaint();
					}
				}

				if (associated == true) 
				{
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

				if (generalized == true) 
				{
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
				}

				if (depended == true) 
				{
					for (Rectangle p2 : pointRects) 
					{
						if (p2.contains(p1)) 
						{
							dependedPoints.add(p2);
							repaint();
						}
					}
				}

				if (aggregated == true) 
				{
					for (Rectangle p2 : pointRects) 
					{
						if (p2.contains(p1)) 
						{
							aggregatedPoints.add(p2);
							repaint();
						}
					}
				}

				if (composited == true) 
				{
					for (Rectangle p2 : pointRects) 
					{
						if (p2.contains(p1)) 
						{
							compositedPoints.add(p2);
							repaint();
						}
					}
				}

				if (selected == true) 
				{
					for (Rectangle p : pointRects) 
					{
						if (p.contains(p1)) 
						{
							selectedShape = p;
							aSelectedShape = true;
						}
					}
					for (Rectangle r : classBoxes) 
					{
						if (r.contains(p1)) 
						{
							selectedShape = r;
							aSelectedShape = true;
						}
					}

					for (Rectangle p : commentBoxes) 
					{
						if (p.contains(p1.x, p1.y)) 
						{
							selectedShape = p;
							aSelectedShape = true;
						}
					}
				}
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLACK);

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

	}
}