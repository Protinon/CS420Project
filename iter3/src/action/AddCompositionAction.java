package action;

import java.util.ArrayList;

import object.Composition;
import object.Class;

public class AddCompositionAction implements Action {
	private ArrayList<Composition> compositions;

	private Class parent;
	private Class child;

	private String childM;
	private String parentM;
	
	private Composition comp;

	public AddCompositionAction(Class c1, Class c2, ArrayList<Composition> compositions, String childM,
			String parentM) {
		this.compositions = compositions;
		this.parent = c1;
		this.child = c2;
		this.childM = childM;
		this.parentM = parentM;
	}

	public void doAction() {
		if (parent != null && child != null) {
			comp = new Composition(parent, child);
			compositions.add(comp);
			
			comp.setChildMultiplicity(childM);
			comp.setParentMultiplicity(parentM);
	
			parent.setChild(child);
			child.setParent(parent);
			
			parent.setParentRelated();
			child.setChildRelated();
		}
	}

	public void undoAction() {
		compositions.remove(comp);
		comp.setChildMultiplicity("");
		comp.setParentMultiplicity("");
		parent.removeChild(child);
		child.removeParent(parent);
	}
}