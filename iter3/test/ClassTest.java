package UML;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassTest {
	
	public Class clazz;
	
	@BeforeEach
	public void setup() {
		clazz = new Class(50,50);
	}

	@Test
	public void testSetAndGetName() {
		String defaultName = "Name", normalName = "Name Test", emptyName = "", longName = "This is too long of a name.",
				veryLongName = "This is a very long name for a class, especially one being represented as a UML Diagram";

		assertEquals(defaultName, clazz.getName());
		
		clazz.setName(normalName);
		assertEquals(normalName, clazz.getName());
		
		clazz.setName(emptyName);
		assertEquals(emptyName, clazz.getName());
		
		clazz.setName(longName);
		assertEquals(longName.substring(0, 25), clazz.getName());
		
		clazz.setName(veryLongName);
		assertEquals(veryLongName.substring(0, 25), clazz.getName());
	}

	@Test
	public void testSetGetAttributes() {

		String defaultAtts = "Attributes", normalAtts = "Attributes Test", emptyAtts = "",
				longAtts = "This is a sentence with more than 25 characters.",
				veryLongAtts = "Attributes will probably be long in the future, but right now that is not allowed because the code doesn't support it.";
		
		assertEquals(defaultAtts, clazz.getAttributes());

		clazz.setAttributes(normalAtts);
		assertEquals(normalAtts, clazz.getAttributes());
		
		clazz.setAttributes(emptyAtts);
		assertEquals(emptyAtts, clazz.getAttributes());
		
		clazz.setAttributes(longAtts);
		assertEquals(longAtts.substring(0, 25), clazz.getAttributes());
		
		clazz.setAttributes(veryLongAtts);
		assertEquals(veryLongAtts.substring(0, 25), clazz.getAttributes());
	}

	@Test
	public void testSetGetOperations() {

		String defaultOps = "Operations", normalOps = "Operations Test", emptyOps = "",
				longOps = "25 characters is not enough for operations.",
				veryLongOps = "Operations will probably be long in the future, but right now that is not allowed because the code doesn't support it.";

		assertEquals(defaultOps, clazz.getOperations());

		clazz.setOperations(normalOps);
		assertEquals(normalOps, clazz.getOperations());

		clazz.setOperations(emptyOps);
		assertEquals(emptyOps, clazz.getOperations());
		
		clazz.setOperations(longOps);
		assertEquals(longOps.substring(0, 25), clazz.getOperations());
		
		clazz.setOperations(veryLongOps);
		assertEquals(veryLongOps.substring(0, 25), clazz.getOperations());
	}

	@Test
	public void testContains() {
		Point upperLeftCorner = new Point(50, 50), insideObject = new Point(54, 60), aboveObject = new Point(49, 50),
				notNearObject = new Point(200, 300);

		assertEquals(true, clazz.contains(upperLeftCorner));
		assertEquals(true, clazz.contains(insideObject));
		assertEquals(false, clazz.contains(aboveObject));
		assertEquals(false, clazz.contains(notNearObject));

	}

	@Test
	public void testSetGetLocation() {

		Point defaultLocation = new Point(50, 50), negativeLocation = new Point(-10, -10),
				normalLocation = new Point(100, 100), outsideScreen = new Point(-100, -100);

		assertEquals(defaultLocation, clazz.getLocation());

		clazz.setLocation(negativeLocation);
		assertEquals(negativeLocation, clazz.getLocation());
		
		clazz.setLocation(normalLocation);
		assertEquals(normalLocation, clazz.getLocation());
		
		clazz.setLocation(outsideScreen);
		assertEquals(outsideScreen, clazz.getLocation());
	}
}
