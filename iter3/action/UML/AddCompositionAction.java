package UML;

import java.util.ArrayList;

public class AddCompositionAction implements Action {
	private ArrayList<Composition> compositions;

	private Class parent;
	private Class child;

	private String childM;
	private String parentM;

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
			Composition cl = new Composition(parent, child);
			compositions.add(cl);
			cl.setChildMultiplicity(childM);
			cl.setParentMultiplicity(parentM);
			parent.setParentRelated(true);
			parent.setChild(child);
			child.setChildRelated(true);
			child.setParent(parent);
		}
	}

	public void undoAction() {
		compositions.remove(parent);
		compositions.remove(child);
	}
}
