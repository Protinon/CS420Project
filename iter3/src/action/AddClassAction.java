package action;

import java.awt.Point;
import java.util.ArrayList;

import object.Canvas;
import object.Class;

public class AddClassAction implements Action {
	private Point p;
	
	private Class classBox;
	
	private ArrayList<Class> classes;
	private Canvas rightPane;
	
	public AddClassAction(Point p, ArrayList<Class> classes, Canvas rightPane) {
		this.p = p;
		this.classes = classes;
		this.rightPane = rightPane;
	}
	
	public Class getObject() {
		return classBox;
	}
	
	public void doAction() { 
		classBox = new Class(p.x, p.y, rightPane);
		classes.add(classBox);
	}
	
	public void undoAction() {
		classes.remove(classBox);
	}
}
