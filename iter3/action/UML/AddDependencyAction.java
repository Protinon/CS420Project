package UML;

import java.awt.Point;
import java.util.ArrayList;

public class AddDependencyAction implements Action {
	private Point p1, p2;
	private ArrayList<Dependency> dependencies;
	private ArrayList<Class> classes;
	private Class class1, class2;

	public AddDependencyAction(Point p1, Point p2, ArrayList<Dependency> dependencies, ArrayList<Class> classes) {
		this.dependencies = dependencies;
		this.p1 = p1;
		this.p2 = p2;
		this.classes = classes;
	}

	public void doAction() {
		for (Class c : classes) {
				if (c.contains(p1)) {
					class1 = c;
				} else if (c.contains(p2)) {
					class2 = c;
				}
			}
		dependencies.add(new Dependency(class1,class2));
		class1.setRelated(true);
		class2.setRelated(true);
	}

	public void undoAction() {
		dependencies.remove(class1);
		dependencies.remove(class2);
	}
}
