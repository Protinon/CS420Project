package object;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;
//100% Coverage
public class ArrowTest {
	Controller c = new Controller();

	@Test
	public void testCase1() {
		c.addClass(new Point(0, 0));
		c.addClass(new Point(200, 200));

		c.addAggregation(new Point(5, 5));
		c.addAggregation(new Point(205, 205));
		
		c.deleteObject(c.getAggregations().get(0).getLocation2());

		c.addClass(new Point(0, 0));
		c.addClass(new Point(200, 200));

		c.addComposition(new Point(5, 5));
		c.addComposition(new Point(205, 205));

		c.deleteObject(c.getCompositions().get(0).getLocation2());

		c.addClass(new Point(0, 0));
		c.addClass(new Point(200, 200));

		c.addDependency(new Point(5, 5));
		c.addDependency(new Point(205, 205));

		c.deleteObject(c.getDependencies().get(0).getLocation2());

		c.addClass(new Point(0, 0));
		c.addClass(new Point(200, 200));

		c.addGeneralization(new Point(5, 5));
		c.addGeneralization(new Point(205, 205));

		c.deleteObject(c.getGeneralizations().get(0).getLocation2());

	}

	@Test
	public void testCase2() {
		c.addClass(new Point(0, 200));
		c.addClass(new Point(100, 0));

		c.addAggregation(new Point(5, 205));
		c.addAggregation(new Point(105, 5));

		c.deleteObject(c.getAggregations().get(0).getLocation2());

		c.addClass(new Point(0, 200));
		c.addClass(new Point(100, 0));

		c.addComposition(new Point(5, 205));
		c.addComposition(new Point(105, 5));

		c.deleteObject(c.getCompositions().get(0).getLocation2());

		c.addClass(new Point(0, 200));
		c.addClass(new Point(100, 0));

		c.addDependency(new Point(5, 205));
		c.addDependency(new Point(105, 5));

		c.deleteObject(c.getDependencies().get(0).getLocation2());

		c.addClass(new Point(0, 200));
		c.addClass(new Point(100, 0));

		c.addGeneralization(new Point(5, 205));
		c.addGeneralization(new Point(105, 5));

		c.deleteObject(c.getGeneralizations().get(0).getLocation2());
	}

	@Test
	public void testCase3() {
		c.addClass(new Point(0, 0));
		c.addClass(new Point(100, 200));

		c.addAggregation(new Point(5, 5));
		c.addAggregation(new Point(105, 205));

		c.deleteObject(c.getAggregations().get(0).getLocation2());

		c.addClass(new Point(0, 0));
		c.addClass(new Point(100, 200));

		c.addComposition(new Point(5, 5));
		c.addComposition(new Point(105, 205));

		c.deleteObject(c.getCompositions().get(0).getLocation2());

		c.addClass(new Point(0, 0));
		c.addClass(new Point(100, 200));

		c.addDependency(new Point(5, 5));
		c.addDependency(new Point(105, 205));

		c.deleteObject(c.getDependencies().get(0).getLocation2());

		c.addClass(new Point(0, 0));
		c.addClass(new Point(100, 200));

		c.addGeneralization(new Point(5, 5));
		c.addGeneralization(new Point(105, 205));

		c.deleteObject(c.getGeneralizations().get(0).getLocation2());

	}

	@Test
	public void testCase4() {
		c.addClass(new Point(200, 200));
		c.addClass(new Point(0, 0));

		c.addAggregation(new Point(205, 205));
		c.addAggregation(new Point(5, 5));

		c.deleteObject(c.getAggregations().get(0).getLocation2());

		c.addClass(new Point(200, 200));
		c.addClass(new Point(0, 0));

		c.addComposition(new Point(205, 205));
		c.addComposition(new Point(5, 5));

		c.deleteObject(c.getCompositions().get(0).getLocation2());

		c.addClass(new Point(200, 200));
		c.addClass(new Point(0, 0));

		c.addDependency(new Point(205, 205));
		c.addDependency(new Point(5, 5));

		c.deleteObject(c.getDependencies().get(0).getLocation2());

		c.addClass(new Point(200, 200));
		c.addClass(new Point(0, 0));

		c.addGeneralization(new Point(205, 205));
		c.addGeneralization(new Point(5, 5));

		c.deleteObject(c.getGeneralizations().get(0).getLocation2());
	}

	@Test
	public void testCase5() {
		c.addClass(new Point(100, 200));
		c.addClass(new Point(0, 0));

		c.addAggregation(new Point(105, 205));
		c.addAggregation(new Point(5, 5));

		c.getAggregations().removeAll(c.getAggregations());

		c.addClass(new Point(100, 200));
		c.addClass(new Point(0, 0));

		c.addComposition(new Point(105, 205));
		c.addComposition(new Point(5, 5));

		c.getCompositions().removeAll(c.getCompositions());

		c.addClass(new Point(100, 200));
		c.addClass(new Point(0, 0));

		c.addDependency(new Point(105, 205));
		c.addDependency(new Point(5, 5));

		c.getDependencies().removeAll(c.getDependencies());

		c.addClass(new Point(100, 200));
		c.addClass(new Point(0, 0));

		c.addGeneralization(new Point(105, 205));
		c.addGeneralization(new Point(5, 5));

		c.getGeneralizations().removeAll(c.getGeneralizations());
	}

	@Test
	public void testCase6() {
		c.addClass(new Point(0, 0));
		c.addClass(new Point(0, 200));

		c.addAggregation(new Point(5, 5));
		c.addAggregation(new Point(105, 205));

		c.getAggregations().removeAll(c.getAggregations());

		c.addClass(new Point(0, 0));
		c.addClass(new Point(0, 200));

		c.addComposition(new Point(5, 5));
		c.addComposition(new Point(105, 205));

		c.getCompositions().removeAll(c.getCompositions());

		c.addClass(new Point(0, 0));
		c.addClass(new Point(0, 200));

		c.addDependency(new Point(5, 5));
		c.addDependency(new Point(105, 205));

		c.getDependencies().removeAll(c.getDependencies());

		c.addClass(new Point(0, 0));
		c.addClass(new Point(0, 200));

		c.addGeneralization(new Point(5, 5));
		c.addGeneralization(new Point(105, 205));

		c.getGeneralizations().removeAll(c.getGeneralizations());
	}
	
	@Test
	public void testContains() {
		c.addClass(new Point(0,0));
		c.addClass(new Point(200, 0));
		
		c.addAggregation(new Point(5,5 ));
		c.addAggregation(new Point(205,5));
		
		assertEquals(true, c.getAggregations().get(0).getArrow().contains(new Point(195, 0 + c.getClasses().get(0).getHeight()/2)));
		assertEquals(false, c.getAggregations().get(0).getArrow().contains(new Point(400, 400+ c.getClasses().get(0).getHeight()/2)));
		
		c.addClass(new Point(0,200));
		c.addClass(new Point(200, 200));
		
		c.addComposition(new Point(5,205));
		c.addComposition(new Point(205,205));
		assertEquals(true, c.getCompositions().get(0).getArrow().contains(new Point(195, 200+ c.getClasses().get(0).getHeight()/2)));
		assertEquals(false, c.getCompositions().get(0).getArrow().contains(new Point(0,0+ c.getClasses().get(0).getHeight()/2)));
		
		c.addClass(new Point(50, 300));
		c.addClass(new Point(250, 300));
		
		c.addDependency(new Point(55, 305));
		c.addDependency(new Point(255, 305));
		assertEquals(true, c.getDependencies().get(0).getArrow().contains(new Point(245, 300+ c.getClasses().get(0).getHeight()/2)));
		assertEquals(false, c.getDependencies().get(0).getArrow().contains(new Point(0, 0+ c.getClasses().get(0).getHeight()/2)));

		c.addClass(new Point(400, 400));
		c.addClass(new Point(600, 400));
		
		c.addGeneralization(new Point(405,405 ));
		c.addGeneralization(new Point(605,405));
		assertEquals(true, c.getGeneralizations().get(0).getArrow().contains(new Point(595, 400 + c.getClasses().get(0).getHeight()/2)));
		assertEquals(false, c.getGeneralizations().get(0).getArrow().contains(new Point(0, 0+ c.getClasses().get(0).getHeight()/2)));
	}
}
