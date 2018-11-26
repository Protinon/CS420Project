package UML;

import java.util.ArrayList;

public class AddDependencyAction implements Action {
	private ArrayList<Dependency> dependencies;

	private Class parent;
	private Class child;

	private String childM;
	private String parentM;

	public AddDependencyAction(Class c1, Class c2, ArrayList<Dependency> dependencies, String childM,
			String parentM) {
		this.dependencies = dependencies;
		this.parent = c1;
		this.child = c2;
		this.childM = childM;
		this.parentM = parentM;
	}

	public void doAction() {
		if (parent != null && child != null) {
			Dependency cl = new Dependency(parent, child);
			dependencies.add(cl);
			cl.setChildMultiplicity(childM);
			cl.setParentMultiplicity(parentM);
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
