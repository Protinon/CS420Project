package UML;

import java.awt.Point;
import java.util.ArrayList;

public class AddDependencyAction implements Action {
	private Point p1;
	private Point p2;
	
	private ArrayList<Dependency> dependencies;
	private ArrayList<Class> classes;
	
	private Class parent;
	private Class child;

	public AddDependencyAction(Point p1, Point p2, ArrayList<Dependency> dependencies, ArrayList<Class> classes) {
		this.dependencies = dependencies;
		this.p1 = p1;
		this.p2 = p2;
		this.classes = classes;
	}

	public void doAction() {
		for (Class c : classes) {
			if (c.contains(p1)) {
				parent = c;
			} else if (c.contains(p2)) {
				child = c;
			}
		}
		
		if (parent != null && child != null) {
			dependencies.add(new Dependency(parent, child));
			parent.setParentRelated(true);
			parent.setChild(child);
			child.setChildRelated(true);
			child.setParent(parent);
		}
	}

	public void undoAction() {
		dependencies.remove(parent);
		dependencies.remove(child);
	}
}
