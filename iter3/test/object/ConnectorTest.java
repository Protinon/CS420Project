package object;

import java.awt.Point;

import org.junit.jupiter.api.Test;

public class ConnectorTest {
	Controller c = new Controller();

	@Test
	public void testCase1() {
		c.addClass(new Point(0, 0));
		c.addClass(new Point(200, 200));

		c.addAggregation(new Point(5,5));
		c.addAggregation(new Point(205, 205));
		
	}
	
	@Test
	public void testCase2() {
		c.addClass(new Point(0, 200));
		c.addClass(new Point(100, 0));

		c.addAggregation(new Point(5,205));
		c.addAggregation(new Point(105, 5));
		
	}
	
	@Test
	public void testCase3() {
		c.addClass(new Point(0, 0));
		c.addClass(new Point(100, 200));

		c.addAggregation(new Point(5,5));
		c.addAggregation(new Point(105, 205));
		
	}
	
	@Test
	public void testCase4() {
		c.addClass(new Point(200,200));
		c.addClass(new Point(0,0));
		
		c.addAggregation(new Point(205, 205));
		c.addAggregation(new Point(5,5));
	}
	
	@Test
	public void testCase5() {
		c.addClass(new Point(100, 200));
		c.addClass(new Point(0,0));
		
		c.addAggregation(new Point(105, 205));
		c.addAggregation(new Point(5,5));
	}
	
	@Test
	public void testCase6() {
		c.addClass(new Point(0, 0));
		c.addClass(new Point(0,200));
		
		c.addAggregation(new Point(5,5));
		c.addAggregation(new Point(105, 205));

	}
}
