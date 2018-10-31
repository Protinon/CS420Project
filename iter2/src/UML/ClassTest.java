package UML;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClassTest {

	@Test
	void testSetName(){
		
		String n = "Test";
		Class nameTest = new Class(0,0);
		
		nameTest.setName(n);
		
		assertEquals(n, nameTest.name);
		
		
	}
	
	@Test
	void testSetAttributes() {
		
		String a = "Stuff goes here";
		
		Class attTest = new Class(0,0);
		
		attTest.setAttributes(a);
		
		assertEquals(a, attTest.attributes);
	}
	@Test
	void testSetOperations() {
		
		String o = "TestMethodForJUnit()";
		
		Class opTest = new Class(0,0);
		
		opTest.setOperations(o);
		
		assertEquals(o, opTest.operations);
	}
}
