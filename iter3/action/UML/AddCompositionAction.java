package UML;

import java.awt.Point;
import java.util.ArrayList;

public class AddCompositionAction implements Action {
	private Point p1;
	private Point p2;
	
	private ArrayList<Composition> compositions;
	private ArrayList<Class> classes;
	
	private Class parent;
	private Class child;

	public AddCompositionAction(Point p1, Point p2, ArrayList<Composition> compositions, ArrayList<Class> classes) {
		this.compositions = compositions;
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
			compositions.add(new Composition(parent, child));
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