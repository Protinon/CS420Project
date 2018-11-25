package UML;

import java.awt.Point;

public interface Relationship {
	public void update();
	public void setClass1(Class c1);
	public void setClass2(Class c2);
	public Class getClass1();
	public Class getClass2();
	public void setLocation();
	public Point getLocation1();
	public Point getLocation2();
	
	
}