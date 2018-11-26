package UML;

import java.util.ArrayList;

public class AddDependencyAction implements Action {
	private ArrayList<Dependency> dependencies;

	private Class parent;
	private Class child;

	public AddDependencyAction (Class c1, Class c2, ArrayList<Dependency> dependencies) {
		this.dependencies = dependencies;
		this.parent = c1;
		this.child = c2;
	}

	public void doAction() {
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
