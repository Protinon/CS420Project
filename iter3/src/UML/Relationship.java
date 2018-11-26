package UML;

import java.awt.Point;

public interface Relationship {
public Arrow getArrow();
public void update();
public void setClass1(Class c);
public void setClass2(Class c);
public Class getClass1();
public Class getClass2();
public void setLocation();
public Point getLocation1();
public Point getLocation2();
public Point getArrowEndLocation();
}
