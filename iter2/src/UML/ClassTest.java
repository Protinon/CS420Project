package UML;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class ClassTest {
	Class defaultTest = new Class(50, 50);
	Class normalTest = new Class(50, 50);
	Class emptyTest = new Class(50, 50);
	Class longTest = new Class(50, 50);
	Class veryLongTest = new Class(50, 50);

	@Test
	void testSetGetName() {

		String defaultName = "Name", normalName = "Name Test", emptyName = "", longName = "This is too long of a name.",
				veryLongName = "This is a very long name for a class, especially one being represented as a UML Diagram";

		normalTest.setName(normalName);
		emptyTest.setName(emptyName);
		longTest.setName(longName);
		veryLongTest.setName(veryLongName);

		assertEquals(defaultName, defaultTest.getName());
		assertEquals(normalName, normalTest.getName());
		assertEquals(emptyName, emptyTest.getName());
		assertEquals(longName.substring(0, 25), longTest.getName());
		assertEquals(veryLongName.substring(0, 25), veryLongTest.getName());

	}

	@Test
	void testSetGetAttributes() {

		String defaultAtts = "Attributes", normalAtts = "Attributes Test", emptyAtts = "",
				longAtts = "This is a sentence with more than 25 characters.",
				veryLongAtts = "Attributes will probably be long in the future, but right now that is not allowed because the code doesn't support it.";

		normalTest.setAttributes(normalAtts);
		emptyTest.setAttributes(emptyAtts);
		longTest.setAttributes(longAtts);
		veryLongTest.setAttributes(veryLongAtts);

		assertEquals(defaultAtts, defaultTest.getAttributes());
		assertEquals(normalAtts, normalTest.getAttributes());
		assertEquals(emptyAtts, emptyTest.getAttributes());
		assertEquals(longAtts.substring(0, 25), longTest.getAttributes());
		assertEquals(veryLongAtts.substring(0, 25), veryLongTest.getAttributes());

	}

	@Test
	void testSetGetOperations() {

		String defaultOps = "Operations", normalOps = "Operations Test", emptyOps = "",
				longOps = "25 characters is not enough for operations.",
				veryLongOps = "Operations will probably be long in the future, but right now that is not allowed because the code doesn't support it.";

		normalTest.setOperations(normalOps);
		emptyTest.setOperations(emptyOps);
		longTest.setOperations(longOps);
		veryLongTest.setOperations(veryLongOps);

		assertEquals(defaultOps, defaultTest.getOperations());
		assertEquals(normalOps, normalTest.getOperations());
		assertEquals(emptyOps, emptyTest.getOperations());
		assertEquals(longOps.substring(0, 25), longTest.getOperations());
		assertEquals(veryLongOps.substring(0, 25), veryLongTest.getOperations());

	}
	
	@Test
	void testContains() {
		Point upperLeftCorner = new Point(50, 50), insideObject = new Point(54, 60), 
				aboveObject = new Point(49, 50), notNearObject = new Point(200, 300);
		
		assertEquals(true, veryLongTest.contains(upperLeftCorner));
		assertEquals(true, veryLongTest.contains(insideObject));
		assertEquals(false, veryLongTest.contains(aboveObject));
		assertEquals(false, veryLongTest.contains(notNearObject));
		
	}
	
	@Test
	void testSetLocation() {
		
		Point defaultLocation = new Point(50,50), negativeLocation = new Point(-10, -10), 
				normalLocation = new Point(100,100), outsideScreen = new Point(-100, -100);
		
		emptyTest.setLocation(negativeLocation);
		normalTest.setLocation(normalLocation);
		longTest.setLocation(outsideScreen);
		
		assertEquals(defaultLocation, defaultTest.getLocation());
		assertEquals(negativeLocation, emptyTest.getLocation());
		assertEquals(normalLocation, normalTest.getLocation());
		assertEquals(outsideScreen, longTest.getLocation());
		
	}
}
