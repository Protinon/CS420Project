package action;

import java.awt.Point;
import java.util.ArrayList;

import object.Class;

public class AddClassAction implements Action {
	private Point p;
	
	private Class classBox;
	
	private ArrayList<Class> classes;
	
	public AddClassAction(Point p, ArrayList<Class> classes) {
		this.p = p;
		this.classes = classes;
	}
	
	public Class getObject() {
		return classBox;
	}
	
	public void doAction() { 
		classBox = new Class(p.x, p.y);
		classes.add(classBox);
	}
	
	public void undoAction() {
		classes.remove(classBox);
	}
}
