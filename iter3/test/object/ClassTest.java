package object;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//75% Coverage

class ClassTest {

	public Class clazz;

	@BeforeEach
	public void setup() {
		clazz = new Class(50, 50);
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
		assertEquals(longName.substring(0, 21), clazz.getName());

		clazz.setName(veryLongName);
		assertEquals(veryLongName.substring(0, 21), clazz.getName());
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
		assertEquals(longAtts, clazz.getAttributes());

		clazz.setAttributes(veryLongAtts);
		assertEquals(veryLongAtts.substring(0, 63), clazz.getAttributes());
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
		assertEquals(longOps, clazz.getOperations());

		clazz.setOperations(veryLongOps);
		assertEquals(veryLongOps.substring(0, 63), clazz.getOperations());
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

	@Test
	public void testGetHeight() {
		assertEquals(72, clazz.getHeight());

		clazz.setAttributes("This will use two lines.");
		assertEquals(96, clazz.getHeight());

		clazz.setOperations("This will use three lines, so let's see if the height updates.");
		assertEquals(144, clazz.getHeight());
	}

	@Test
	public void testGetWidth() {
		assertEquals(150, clazz.getWidth());
	}

	@Test
	public void testSetGetRelated() {
		Class p = new Class(100, 100);
		clazz.setParent(p);
		clazz.setChildRelated(true);

		p.setChild(clazz);
		p.setParentRelated(true);

		assertEquals(p, clazz.getParent());
		assertEquals(p.isAChild(), false);
		assertEquals(p.isAParent(), true);

		assertEquals(clazz, p.getChild());
		assertEquals(clazz.isAParent(), false);
		assertEquals(clazz.isAChild(), true);
	}

	@Test
	public void testPaintComponent() {
		Controller c = new Controller();
		c.addClass(new Point(0, 0));
		c.getClasses().get(0).setAttributes("123456789112345678901234567");
		c.getClasses().get(0).setAttributes("12345678911234567890123456789012345678901234");
		c.getClasses().get(0).setOperations("123456789112345678901234567");
		c.getClasses().get(0).setOperations("12345678911234567890123456789012345678901234");

	}
}
