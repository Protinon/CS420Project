package object;

import static org.junit.Assert.assertEquals;
//100% Coverage

import java.awt.Point;

import org.junit.jupiter.api.Test;

public class RelationshipTest {
	Controller con = new Controller();
	Canvas r = new Canvas(con);
	Class temp = new Class(0, 0,r);
	Class temp2 = new Class(200, 0,r);
	Class temp3 = new Class(150, 200,r);
	Class temp4 = new Class(400, 200,r);
	Class temp5 = new Class(400, 400,r);
	Class temp6 = new Class(600, 400,r);

	Aggregation a = new Aggregation(new Class(0, 0,r), new Class(200, 0,r));
	Association as = new Association(new Class(200, 200,r), new Class(400, 200,r));
	Composition c = new Composition(new Class(400, 400,r), new Class(600, 400,r));
	Dependency d = new Dependency(new Class(600, 600,r), new Class(800, 600,r));
	Generalization g = new Generalization(new Class(0, 600,r), new Class(300, 600,r));

	@Test
	public void testContains() {
		assertEquals(true, a.contains(new Point(180, 0 + temp.getHeight() / 2)));
		assertEquals(false, a.contains(new Point(300, 200 + temp.getHeight() / 2)));

		assertEquals(true, as.contains(new Point(380, 200 + temp.getHeight() / 2)));
		assertEquals(false, as.contains(new Point(0, 0 + temp.getHeight() / 2)));

		assertEquals(true, c.contains(new Point(580, 400 + temp.getHeight() / 2)));
		assertEquals(false, c.contains(new Point(0, 0 + temp.getHeight() / 2)));

		assertEquals(true, d.contains(new Point(780, 600 + temp.getHeight() / 2)));
		assertEquals(false, d.contains(new Point(0, 0 + temp.getHeight())));

		assertEquals(true, g.contains(new Point(280, 600 + temp.getHeight() / 2)));
		assertEquals(false, g.contains(new Point(600, 600 + temp.getHeight() / 2)));
	}

	@Test
	public void testToString() {
		assertEquals("Aggregation", a.toString());

		assertEquals("Association", as.toString());

		assertEquals("Composition", c.toString());

		assertEquals("Dependency", d.toString());

		assertEquals("Generalization", g.toString());
	}

	@Test
	public void testSetGetParentChild() {
		a.setClass1(temp);
		assertEquals(temp, a.getClass1());
		a.setClass2(temp2);
		assertEquals(temp2, a.getClass2());

		as.setClass1(temp2);
		assertEquals(temp2, as.getClass1());
		as.setClass2(temp3);
		assertEquals(temp3, as.getClass2());

		c.setClass1(temp3);
		assertEquals(temp3, c.getClass1());
		c.setClass2(temp4);
		assertEquals(temp4, c.getClass2());

		d.setClass1(temp4);
		assertEquals(temp4, d.getClass1());
		d.setClass2(temp5);
		assertEquals(temp5, d.getClass2());

		g.setClass1(temp5);
		assertEquals(temp5, g.getClass1());
		g.setClass2(temp6);
		assertEquals(temp6, g.getClass2());

	}

	@Test
	public void testSetGetMultiplicties() {
		a.setParentMultiplicity("1");
		a.setChildMultiplicity("2");
		assertEquals("1", a.getParentMultiplicity());
		assertEquals("2", a.getChildMultiplicity());

		as.setParentMultiplicity("3");
		as.setChildMultiplicity("4");
		assertEquals("3", as.getParentMultiplicity());
		assertEquals("4", as.getChildMultiplicity());

		c.setParentMultiplicity("5");
		c.setChildMultiplicity("6");
		assertEquals("5", c.getParentMultiplicity());
		assertEquals("6", c.getChildMultiplicity());

		d.setParentMultiplicity("7");
		d.setChildMultiplicity("8");
		assertEquals("7", d.getParentMultiplicity());
		assertEquals("8", d.getChildMultiplicity());

		g.setParentMultiplicity("9");
		g.setChildMultiplicity("10");
		assertEquals("9", g.getParentMultiplicity());
		assertEquals("10", g.getChildMultiplicity());
	}

	@Test
	public void testSetLocation() {
		a.setLocation();
		a.setClass1(new Class(0, 200,r));
		a.setClass2(new Class(200, 190,r));
		a.setLocation();
		a.setClass1(new Class(100, 200,r));
		a.setClass2(new Class(200, 0,r));
		a.setLocation();
		a.setClass1(new Class(100, 0,r));
		a.setClass2(new Class(200, 200,r));
		a.setLocation();
		a.setClass1(new Class(200, 200,r));
		a.setClass2(new Class(0, 0,r));
		a.setLocation();
		a.setClass1(new Class(200, 0,r));
		a.setClass2(new Class(0, 200,r));
		a.setLocation();
		a.setClass1(new Class(200, 200,r));
		a.setClass2(new Class(100, 0,r));
		a.setLocation();
		a.setClass1(new Class(200, 0,r));
		a.setClass2(new Class(100, 200,r));
		a.setLocation();
		a.setClass1(temp);
		a.setClass2(temp2);

		as.setLocation();
		as.setClass1(new Class(0, 200,r));
		as.setClass2(new Class(200, 190,r));
		as.setLocation();
		as.setClass1(new Class(100, 200,r));
		as.setClass2(new Class(200, 0,r));
		as.setLocation();
		as.setClass1(new Class(100, 0,r));
		as.setClass2(new Class(200, 200,r));
		as.setLocation();
		as.setClass1(new Class(200, 200,r));
		as.setClass2(new Class(0, 0,r));
		as.setLocation();
		as.setClass1(new Class(200, 0,r));
		as.setClass2(new Class(0, 200,r));
		as.setLocation();
		as.setClass1(new Class(200, 200,r));
		as.setClass2(new Class(100, 0,r));
		as.setLocation();
		as.setClass1(new Class(200, 0,r));
		as.setClass2(new Class(100, 200,r));
		as.setLocation();
		as.setClass1(temp2);
		as.setClass2(temp3);

		c.setLocation();
		c.setClass1(new Class(0, 200,r));
		c.setClass2(new Class(200, 190,r));
		c.setLocation();
		c.setClass1(new Class(100, 200,r));
		c.setClass2(new Class(200, 0,r));
		c.setLocation();
		c.setClass1(new Class(100, 0,r));
		c.setClass2(new Class(200, 200,r));
		c.setLocation();
		c.setClass1(new Class(200, 200,r));
		c.setClass2(new Class(0, 0,r));
		c.setLocation();
		c.setClass1(new Class(200, 0,r));
		c.setClass2(new Class(0, 200,r));
		c.setLocation();
		c.setClass1(new Class(200, 200,r));
		c.setClass2(new Class(100, 0,r));
		c.setLocation();
		c.setClass1(new Class(200, 0,r));
		c.setClass2(new Class(100, 200,r));
		c.setLocation();
		c.setClass1(temp3);
		c.setClass2(temp4);

		d.setLocation();
		d.setClass1(new Class(0, 200,r));
		d.setClass2(new Class(200, 190,r));
		d.setLocation();
		d.setClass1(new Class(100, 200,r));
		d.setClass2(new Class(200, 0,r));
		d.setLocation();
		d.setClass1(new Class(100, 0,r));
		d.setClass2(new Class(200, 200,r));
		d.setLocation();
		d.setClass1(new Class(200, 200,r));
		d.setClass2(new Class(0, 0,r));
		d.setLocation();
		d.setClass1(new Class(200, 0,r));
		d.setClass2(new Class(0, 200,r));
		d.setLocation();
		d.setClass1(new Class(200, 200,r));
		d.setClass2(new Class(100, 0,r));
		d.setLocation();
		d.setClass1(new Class(200, 0,r));
		d.setClass2(new Class(100, 200,r));
		d.setLocation();
		d.setClass1(temp4);
		d.setClass2(temp5);

		g.setLocation();
		g.setClass1(new Class(0, 200,r));
		g.setClass2(new Class(200, 190,r));
		g.setLocation();
		g.setClass1(new Class(100, 200,r));
		g.setClass2(new Class(200, 0,r));
		g.setLocation();
		g.setClass1(new Class(100, 0,r));
		g.setClass2(new Class(200, 200,r));
		g.setLocation();
		g.setClass1(new Class(200, 200,r));
		g.setClass2(new Class(0, 0,r));
		g.setLocation();
		g.setClass1(new Class(200, 0,r));
		g.setClass2(new Class(0, 200,r));
		g.setLocation();
		g.setClass1(new Class(200, 200,r));
		g.setClass2(new Class(100, 0,r));
		g.setLocation();
		g.setClass1(new Class(200, 0,r));
		g.setClass2(new Class(100, 200,r));
		g.setLocation();
		g.setClass1(temp5);
		g.setClass2(temp6);

	}

	@Test
	public void testGetLocations() {

		a.setLocation();
		assertEquals(new Point(0 + temp.getWidth(), temp.getHeight() / 2), a.getLocation1());
		assertEquals(new Point(184, temp2.getHeight() / 2), a.getLocation2());
		assertEquals(new Point(200, temp2.getHeight() / 2), a.getArrowEndLocation());
		assertEquals(new Point(a.getLocation1().x + 10, a.getLocation1().y - 10), a.getParentMultiplicityPoint());
		assertEquals(new Point(a.getArrowEndLocation().x - 20, a.getArrowEndLocation().y + 20),
				a.getChildMultiplicityPoint());

		as.setClass1(temp);
		as.setClass2(temp2);
		as.setLocation();
		assertEquals(new Point(0 + temp.getWidth(), temp.getHeight() / 2), as.getLocation1());
		assertEquals(new Point(200, temp2.getHeight() / 2), as.getLocation2());
		assertEquals(new Point(200, temp2.getHeight() / 2), as.getArrowEndLocation());
		assertEquals(new Point(as.getLocation1().x + 10, as.getLocation1().y - 10), as.getParentMultiplicityPoint());
		assertEquals(new Point(as.getArrowEndLocation().x - 20, as.getArrowEndLocation().y + 20),
				as.getChildMultiplicityPoint());

		c.setClass1(temp);
		c.setClass2(temp2);
		c.setLocation();
		assertEquals(new Point(0 + temp.getWidth(), temp.getHeight() / 2), c.getLocation1());
		assertEquals(new Point(184, temp2.getHeight() / 2), c.getLocation2());
		assertEquals(new Point(200, temp2.getHeight() / 2), c.getArrowEndLocation());
		assertEquals(new Point(c.getLocation1().x + 10, c.getLocation1().y - 10), c.getParentMultiplicityPoint());
		assertEquals(new Point(c.getArrowEndLocation().x - 20, c.getArrowEndLocation().y + 20),
				c.getChildMultiplicityPoint());

		d.setClass1(temp);
		d.setClass2(temp2);
		d.setLocation();
		assertEquals(new Point(0 + temp.getWidth(), temp.getHeight() / 2), d.getLocation1());
		assertEquals(new Point(184, temp2.getHeight() / 2), d.getLocation2());
		assertEquals(new Point(200, temp2.getHeight() / 2), d.getArrowEndLocation());
		assertEquals(new Point(d.getLocation1().x + 10, d.getLocation1().y - 10), d.getParentMultiplicityPoint());
		assertEquals(new Point(d.getArrowEndLocation().x - 20, d.getArrowEndLocation().y + 20),
				d.getChildMultiplicityPoint());

		g.setClass1(temp);
		g.setClass2(temp2);
		g.setLocation();
		assertEquals(new Point(0 + temp.getWidth(), temp.getHeight() / 2), g.getLocation1());
		assertEquals(new Point(184, temp2.getHeight() / 2), g.getLocation2());
		assertEquals(new Point(200, temp2.getHeight() / 2), g.getArrowEndLocation());
		assertEquals(new Point(g.getLocation1().x + 10, g.getLocation1().y - 10), g.getParentMultiplicityPoint());
		assertEquals(new Point(g.getArrowEndLocation().x - 20, g.getArrowEndLocation().y + 20),
				g.getChildMultiplicityPoint());
	}
	
	@Test
	public void testGetArrow() {
		a.getArrow();
		as.getArrow();
		c.getArrow();
		d.getArrow();
		g.getArrow();
	}
	
	@Test
	public void testPaintRelationships() {
		Controller c = new Controller();
		c.addClass(new Point(0,0));
		c.addClass(new Point(185, 0));
		c.addAggregation(new Point(5,5));
		c.addAggregation(new Point(190, 5));
		c.getAggregations().get(0).setChildMultiplicity("1");
		c.getAggregations().get(0).setParentMultiplicity("1");
		
		c.addClass(new Point(0,0));
		c.addClass(new Point(185, 0));
		c.addAssociation(new Point(5,5));
		c.addAssociation(new Point(190, 5));
		c.getAssociations().get(0).setChildMultiplicity("1");
		c.getAssociations().get(0).setParentMultiplicity("1");	
		
		c.addClass(new Point(0,0));
		c.addClass(new Point(185, 0));
		c.addComposition(new Point(5,5));
		c.addComposition(new Point(190, 5));
		c.getCompositions().get(0).setChildMultiplicity("1");
		c.getCompositions().get(0).setParentMultiplicity("1");
		
		c.addClass(new Point(0,0));
		c.addClass(new Point(185, 0));
		c.addDependency(new Point(5,5));
		c.addDependency(new Point(190, 5));
		c.getDependencies().get(0).setChildMultiplicity("1");
		c.getDependencies().get(0).setParentMultiplicity("1");
		
		c.addClass(new Point(0,0));
		c.addClass(new Point(185, 0));
		c.addGeneralization(new Point(5,5));
		c.addGeneralization(new Point(190, 5));
		c.getGeneralizations().get(0).setChildMultiplicity("1");
		c.getGeneralizations().get(0).setParentMultiplicity("1");
		
		c.addClass(new Point(0,200));
		c.addClass(new Point(100,0));
		c.addDependency(new Point(0, 205));
		c.addDependency(new Point(105, 5));
		c.getDependencies().get(1).setChildMultiplicity("1");
		c.getDependencies().get(1).setParentMultiplicity("1");		
	
		c.addClass(new Point(0,0));
		c.addClass(new Point(100,200));
		c.addDependency(new Point(0, 5));
		c.addDependency(new Point(105, 205));
		c.getDependencies().get(2).setChildMultiplicity("1");
		c.getDependencies().get(2).setParentMultiplicity("1");	
		
		c.addClass(new Point(400,200));
		c.addClass(new Point(200,400));
		c.addDependency(new Point(405, 205));
		c.addDependency(new Point(205, 405));
		c.getDependencies().get(3).setChildMultiplicity("1");
		c.getDependencies().get(3).setParentMultiplicity("1");
		
		c.addClass(new Point(600, 300));
		c.addClass(new Point(500, 500));
		c.addDependency(new Point(605, 305));
		c.addDependency(new Point(505, 505));
		c.getDependencies().get(4).setChildMultiplicity("1");
		c.getDependencies().get(4).setParentMultiplicity("1");
		
		c.addClass(new Point(800, 400));
		c.addClass(new Point(700, 200));
		c.addDependency(new Point(805, 405));
		c.addDependency(new Point(705, 205));
		c.getDependencies().get(5).setChildMultiplicity("1");
		c.getDependencies().get(5).setParentMultiplicity("1");
	}
}
