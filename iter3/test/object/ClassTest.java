package object;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//73.2% Coverage
class ClassTest {

	public Class clazz, clazzz;
	Canvas r;
	Controller c;

	@BeforeEach
	public void setup() {
		c = new Controller();
		r = new Canvas(c);
		clazz = new Class(50, 50, r);
		clazzz = new Class(300,300, r);
	}

	// Set name formality-unused function
	@Test
	public void testSetAndGetName() {
		String defaultName = "Name", normalName = "Name Test", emptyName = "";

		assertEquals(defaultName, clazz.getName());

		clazz.setName(normalName);
		assertEquals(normalName, clazz.getName());

		clazz.setName(emptyName);
		assertEquals(emptyName, clazz.getName());
	}

	// Set attributes formality - not used function
	@Test
	public void testSetGetAttributes() {

		String defaultAtts = "Attributes", normalAtts = "Attributes Test", emptyAtts = "";

		assertEquals("+ " + defaultAtts, clazz.getAttributes());

		clazz.setAttributes(normalAtts);
		assertEquals("+ " + normalAtts, clazz.getAttributes());

		clazz.setAttributes(emptyAtts);
		assertEquals("+ " + emptyAtts, clazz.getAttributes());
	}

	// Set operations formality - not used function
	@Test
	public void testSetGetOperations() {

		String defaultOps = "Operations", normalOps = "Operations Test", emptyOps = "";
				
		assertEquals("- " + defaultOps, clazz.getOperations());

		clazz.setOperations(normalOps);
		assertEquals("- " + normalOps, clazz.getOperations());

		clazz.setOperations(emptyOps);
		assertEquals("- " + emptyOps, clazz.getOperations());
	}

	@Test
	public void testContains() {
		Point upperLeftCorner = new Point(50, 50), insideObject = new Point(54, 60), aboveObject = new Point(49, 50),
				negative = new Point(-8, 6);

		assertEquals(true, clazz.contains(upperLeftCorner));
		assertEquals(true, clazz.contains(insideObject));
		assertEquals(false, clazz.contains(aboveObject));
		clazz.setLocation(-10, 5);
		assertEquals(true, clazz.contains(negative));

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
	public void testGetHeight() throws AWTException {
		assertEquals(64, clazz.getHeight());
	}

	@Test
	public void testGetWidth() {
		assertEquals(130, clazz.getWidth());
	}

	@Test
	public void testSetGetRelated() {		
		clazz.setParent(clazzz);
		clazz.setChildRelated();
		clazz.setParentRelated();
		
		clazzz.setChild(clazz);
		clazzz.setParentRelated();
		clazzz.setChildRelated();

		assertEquals(true, clazz.getParents().contains(clazzz));
		assertEquals(clazzz.isAChild(), false);
		assertEquals(clazzz.isAParent(), true);

		assertEquals(true, clazzz.getChildren().contains(clazz));
		assertEquals(clazz.isAParent(), false);
		assertEquals(clazz.isAChild(), true);
	}
	
	@Test
	public void testDelete() {
		clazz.delete();
		assertEquals(null, clazz.getNameTextBox());
		assertEquals(null, clazz.getAttributesTextBox());
		assertEquals(null, clazz.getOperationsTextBox());

	}

	@Test
	public void testPaintComponent() {
		c.addClass(new Point(0, 0));
	}

	@Test
	public void removeChildParent() {
		clazz.setParent(clazzz);
		clazzz.setChild(clazz);
		
		assertEquals(true, clazz.getParents().contains(clazzz));
		assertEquals(true, clazzz.getChildren().contains(clazz));
		
		clazz.removeParent(clazzz);
		clazzz.removeChild(clazz);
		
		assertEquals(false, clazz.getParents().contains(clazzz));
		assertEquals(false, clazzz.getChildren().contains(clazz));
	}
}
