package action;

import java.util.ArrayList;

import object.Dependency;
import object.Class;

public class AddDependencyAction implements Action {
	private ArrayList<Dependency> dependencies;

	private Class parent;
	private Class child;

	private String childM;
	private String parentM;
	
	private Dependency dep;

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
			dep = new Dependency(parent, child);
			dependencies.add(dep);
			
			dep.setChildMultiplicity(childM);
			dep.setParentMultiplicity(parentM);
	
			parent.setChild(child);
			child.setParent(parent);
			
			parent.setParentRelated();
			child.setChildRelated();
		}
	}

	public void undoAction() {
		dependencies.remove(dep);
		dep.setChildMultiplicity("");
		dep.setParentMultiplicity("");
		parent.removeChild(child);
		child.removeParent(parent);
	}
}